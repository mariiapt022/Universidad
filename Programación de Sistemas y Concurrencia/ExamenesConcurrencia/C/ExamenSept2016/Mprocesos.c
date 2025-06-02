#include <stdio.h>
#include <stdlib.h>
#include "Mprocesos.h"

void Crear(LProc *lista){
    *lista = NULL;
}

void AnadirProceso(LProc *lista, int idproc){
   LProc newProc = malloc(sizeof(struct Proceso));
   if (newProc == NULL)
   {
       perror("No hay suficiente memoria disponible.\n");
       exit(-1);
   }

   newProc->id = idproc;
   if (*lista == NULL)
   {
       *lista = newProc;
       (*lista)->sig = *lista;
   }else
   {
       newProc->sig = (*lista)->sig;
       (*lista)->sig = newProc;
       *lista = newProc;
   }
}

void EjecutarProcesos(LProc lista){
    if (lista == NULL)
    {
        printf("No hay procesos para ejecutar.\n");
    }else{
        LProc ptr = lista;
        do
        {
            printf("%i ",ptr->sig->id);
            ptr = ptr->sig;
        } while (ptr != lista);
        printf("\n");
    }
}

void EliminarProceso(int idproc, LProc *lista){
    if (*lista == NULL)
    {
        printf("Lista vacía.\n");
    }else if ((*lista)->sig == *lista && (*lista)->id == idproc)
    {
        LProc aux = *lista;
        *lista = NULL;
        free(aux);
    }else{
        LProc ptr = *lista;
        while (ptr->sig->id != idproc)
        {
            ptr = ptr->sig;
        }
        LProc aux = ptr->sig;
        if (aux == *lista)
        {
            *lista = ptr;
        }
        ptr->sig = aux->sig;
        free(aux);
    }
}

void EscribirFichero (char * nomf, LProc *lista){
    FILE *file = fopen(nomf,"wb");
    if (file == NULL)
    {
        perror("Error al abrir el archivo");
        exit(-1);
    }

    
    int cnt = 0;
    int id[10];
    LProc ptr = (*lista)->sig;
    (*lista)->sig = NULL;
    
    while (*lista != NULL)
    {
        *lista = ptr->sig;
        id[cnt] = ptr->id;
        free(ptr);
        cnt ++;
        ptr = *lista;
    }

    fwrite(&cnt,sizeof(int),1,file);
    fwrite(&id,sizeof(int),cnt,file);
    fclose(file);
}