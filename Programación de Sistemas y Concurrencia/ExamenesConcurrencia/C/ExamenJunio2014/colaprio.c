#include <stdio.h>
#include <stdlib.h>
#include "colaprio.h"


void Insertar_Proceso(TColaPrio *cp,unsigned int id,unsigned int prio){
    TColaPrio newNode = malloc(sizeof(struct Nodo));
    if (newNode == NULL)
    {
        perror("No hay suficiente memoria disponible");
        exit(-1);
    }else{
        newNode->id = id;
        newNode->pri = prio;
        if (*cp == NULL)
        {
            newNode->sig = NULL;
            *cp = newNode;
        }else if (prio < (*cp)->pri)
        {
            newNode->sig = *cp;
            *cp = newNode;
        }else
        {
            TColaPrio ptr = *cp;
            while (ptr->sig != NULL && prio >= ptr->sig->pri)
            {
                ptr = ptr->sig;
            }
            newNode->sig = ptr->sig;
            ptr->sig = newNode;
        }
    }
}

void Crear_Cola(char *nombre, TColaPrio *cp){
    FILE *file = fopen(nombre,"rb");
    if (file == NULL)
    {
        perror("Error al abrir el fichero");
        exit(-1);
    }else{
        *cp = NULL;
        int id, prio;
        int i = 0;
        int num;
        fread(&num,sizeof(unsigned),1,file);
        while (i < num)
        {
            fread(&id,sizeof(unsigned),1,file);
            fread(&prio,sizeof(unsigned),1,file);
            Insertar_Proceso(cp,id,prio);
            i ++;
        }
        fclose(file);
    }
}

void Mostrar(TColaPrio cp){
    if (cp == NULL)
    {
        printf("Cola vacía\n");
    }else
    {
        printf("Cola: ");
        TColaPrio ptr = cp;
        while (ptr != NULL)
        {
            printf("%i|%i ",ptr->id,ptr->pri);
            ptr = ptr->sig;
        }
        printf("\n");
    }
}

void Destruir(TColaPrio *cp){
    if (*cp == NULL)
    {
        printf("Cola vacía\n");
    }else
    {
        TColaPrio ptr;
        while (*cp != NULL)
        {
            ptr = *cp;
            *cp = (*cp)->sig;
            free(ptr);
        }  
    }
}

void Ejecutar_Max_Prio(TColaPrio *cp){
    
    if (*cp == NULL)
    {
        printf("No hay procesos para ejecutar\n");
    }else
    {
        int prio = (*cp)->pri;
        TColaPrio ptr;
        while (*cp != NULL && (*cp)->pri == prio)
        {
            ptr = *cp;
            *cp = (*cp)->sig;
            free(ptr);
        }
    }
}

void Ejecutar(TColaPrio *cp, int prio){
    
    if (*cp == NULL)
    {
        printf("Cola vacía\n");
    }else if (prio == (*cp)->pri)
    {
        TColaPrio ptr;
        while (*cp != NULL && (*cp)->pri == prio)
        {
            ptr = *cp;
            *cp = (*cp)->sig;
            free(ptr);
        }
    }else{
        TColaPrio ptr = *cp;
        while (ptr->sig != NULL && ptr->sig->pri != prio)
        {
            ptr = ptr->sig;
        }
        if (ptr->sig != NULL)
        {
            TColaPrio aux;
            while (ptr->sig != NULL && ptr->sig->pri == prio)
            {
                aux = ptr->sig;
                ptr->sig = aux->sig;
                free(aux);
            }
        }else{
            printf("El proceso con prioridad %i no está en la cola\n",prio);
        } 
    }
}