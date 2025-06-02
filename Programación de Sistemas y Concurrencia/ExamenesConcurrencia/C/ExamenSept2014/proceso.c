#include <stdlib.h>
#include <stdio.h>
#include "proceso.h"
#include <string.h>

void Crear (LSistema *ls){
    *ls = NULL;
}

void InsertarProceso (LSistema *ls, int idproc){
    LSistema newProcess = malloc(sizeof(struct proceso));
    if (newProcess != NULL)
    {
        newProcess->idproc = idproc;
        newProcess->hebra = NULL;
        newProcess->sig = NULL;
        if (*ls == NULL)
        {
            *ls = newProcess;
        }else{
            LSistema ptr = *ls;
            while (ptr->sig != NULL)
            {
                ptr = ptr->sig;
            }
            ptr->sig = newProcess;
        }
    }else{
        perror("No hay suficiente memoria disponible");
        exit(-1);
    }
    
}


void InsertarHebra (LSistema *ls, int idproc, char *idhebra, int priohebra){
    LHebra newThread = malloc(sizeof(struct hebra));
    if (newThread != NULL)
    {
        newThread->idheb = malloc(strlen(idhebra) + 1);
        strcpy(newThread->idheb, idhebra);
        newThread->prior = priohebra;
        LSistema ptr = *ls;
        while (ptr->idproc != idproc)
        {
            ptr = ptr->sig;
        }
        if (ptr->hebra == NULL)
        {
            newThread->sig = NULL;
            ptr->hebra = newThread;
        }else if(priohebra > ptr->hebra->prior){
            newThread->sig = ptr->hebra;
            ptr->hebra = newThread;
        }else{
            LHebra ptr_hebra = ptr->hebra;
            while (ptr_hebra->sig != NULL && priohebra < ptr_hebra->sig->prior)
            {
                ptr_hebra = ptr_hebra->sig;
            }
            newThread->sig = ptr_hebra->sig;
            ptr_hebra->sig = newThread;
        }
        
    }else{
        perror("No hay suficiente memoria disponible");
        exit(-1);
    }
}

void Mostrar (LSistema ls){
    if (ls != NULL)
    {
        LSistema ptr = ls;
        printf("Lista de procesos:\n");
        while (ptr != NULL)
        {
            printf("IDP%i(",ptr->idproc);
            LHebra ptr_hebra = ptr->hebra;
            while (ptr_hebra != NULL)
            {
                printf("%s/%i ",ptr_hebra->idheb,ptr_hebra->prior);
                ptr_hebra = ptr_hebra->sig;
            }
            printf(") ");
            ptr = ptr->sig;
        }
        printf("\n");
    }else{
        printf("Lista vacía.\n");
    }
    
}

void EliminarProc (LSistema *ls, int idproc){
    if (*ls != NULL)
    {
        LSistema ptr = *ls;
        if ((*ls)->idproc == idproc)
        {
            while ((*ls)->hebra != NULL)
            {
                LHebra ptr_hebra = (*ls)->hebra;
                (*ls)->hebra = (*ls)->hebra->sig;
                free(ptr_hebra);
            }
            (*ls) = (*ls)->sig;
            free(ptr);
        }else{
            while (ptr->sig->idproc != idproc)
            {
                ptr = ptr->sig;
            }
            LSistema aux = ptr->sig;
            ptr->sig = aux->sig;
            while (aux->hebra != NULL)
            {
                LHebra ptr_hebra = aux->hebra;
                aux->hebra = aux->hebra->sig;
                free(ptr_hebra);
            }
            free(aux);
        }
        
    }else
    {
        printf("Lista vacía.\n");
    }
    
    
}

void Destruir (LSistema *ls){
    while (*ls != NULL)
    {
        LSistema ptr = *ls;
        while ((*ls)->hebra != NULL)
        {
            LHebra ptr_hebra = (*ls)->hebra;
            (*ls)->hebra = (*ls)->hebra->sig;
            free(ptr_hebra);
        }
        *ls = (*ls)->sig;
        free(ptr);
    }
    
}