#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#include "control2013.h"

void crear(T_Planificador *planif){
    *planif = NULL;
}

void insertar_tarea(T_Planificador *planif,int pri,char *id){
    T_Planificador newTask = malloc(sizeof(struct Tarea));
    if (newTask == NULL)
    {
        perror("No hay suficiente memoria disponible");
        exit(-1);
    }
    newTask->id = malloc(strlen(id) + 1);
    strcpy(newTask->id,id);
    newTask->pri = pri;
    if (*planif == NULL)
    {
        newTask->sig = NULL;
        *planif = newTask;
    }else if (pri > (*planif)->pri)
    {
        newTask->sig = *planif;
        *planif = newTask;
    }else{
        T_Planificador ptr = *planif;
        while (ptr->sig != NULL && pri <= ptr->sig->pri)
        {
            ptr = ptr->sig;
        }
        newTask->sig = ptr->sig;
        ptr->sig = newTask;
    }
    
    
}

void mostrar (T_Planificador planificador){
    if (planificador == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        T_Planificador ptr = planificador;
        printf("Lista: ");
        while (ptr != NULL)
        {
            printf("%i|%s ",ptr->pri,ptr->id);
            ptr = ptr->sig;
        }
        printf("\n");
    }
}

void eliminar_tarea(T_Planificador *planif,char *id,unsigned *ok){
    if (*planif == NULL)
    {
        *ok = 0;
        printf("Lista vacía.\n");
    }else if (strcmp((*planif)->id,id) == 0)
    {
        T_Planificador aux = *planif;
        *planif = (*planif)->sig;
        free(aux);
    }else{
        T_Planificador ptr = *planif;
        while (ptr->sig != NULL && strcmp(ptr->sig->id,id) != 0)
        {
            ptr = ptr->sig;
        }
        if (ptr->sig != NULL)
        {
            T_Planificador aux = ptr->sig;
            ptr->sig = aux->sig;
            free(aux);
            *ok = 1;
        }else{
            *ok = 0;
        }
        
    }
    
}
void planificar(T_Planificador *planif){
    if (*planif == NULL)
    {
        printf("No hay procesos para ejecutar.\n");
    }else{
        T_Planificador aux = *planif;
        *planif = (*planif)->sig;
        free(aux);
    }
    
}
void destruir(T_Planificador *planif){
    if (*planif == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        T_Planificador ptr;
        while (*planif != NULL)
        {
            ptr = *planif;
            *planif = (*planif)->sig;
            free(ptr);
        }
    }
}