#include <stdlib.h>
#include <stdio.h>
#include "circular.h"

void Crear (LProc *lista){
    *lista = NULL;    
}

void AnyadirProceso (LProc *lista, int idproc){
    LProc newNode = malloc(sizeof(struct circular));
    if (newNode != NULL){
        newNode->pid = idproc;
        if (*lista == NULL)
        {
            newNode->sig = newNode;
            *lista = newNode;
        }else if((*lista)->sig == (*lista)){
            (*lista)->sig = newNode;
            newNode->sig = *lista;
        }else{
            LProc ptr = *lista;
            do
            {
                ptr = ptr->sig;
            } while (ptr->sig != (*lista));
            ptr->sig = newNode;
            newNode->sig = *lista;
        }
    }else{
        perror("No hay suficiente memoria disponible");
        exit(-1);
    }
}

void MostrarLista(LProc lista){
    if (lista != NULL)
    {
        LProc ptr = lista;
        printf("Lista: ");
        do
        {
            printf("%i ",ptr->pid);
            ptr = ptr->sig;
        } while (ptr != lista);
        printf("\n");
        
    }else{
        printf("Lista vacía \n");
    }
    
}

void EjecutarProceso(LProc *lista){
    if (*lista != NULL)
    {
        if ((*lista)->sig == *lista)
        {
            LProc ptr = *lista;
            free(ptr);
            *lista = NULL;
        }else{
            LProc aux = *lista;
            LProc ptr = (*lista)->sig;
            while (ptr->sig != *lista)
            {
                ptr = ptr->sig;
            }
            ptr->sig = (*lista)->sig;
            free(aux);
            *lista = ptr->sig;
        }
        
    }
    
}
