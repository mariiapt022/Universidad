#include<stdio.h>
#include<stdlib.h>
#include "ListaJugadores.h"

void crear(TListaJugadores *lc){
    *lc = NULL;
}

void insertar(TListaJugadores *lj,unsigned int id){
    
    if (*lj == NULL)
    {
        TListaJugadores newPlayer = malloc(sizeof(struct Jugador));
        if (newPlayer == NULL)
        {
            perror("No hay suficiente memoria disponible");
            exit(-1);
        }else
        {
            newPlayer->id = id;
            newPlayer->goles = 1;
            newPlayer->sig = NULL;
            *lj = newPlayer;
        }
    }else if (id == (*lj)->id)
    {
        (*lj)->goles ++;
    }else{
        TListaJugadores ptr = *lj;
        while (ptr->sig != NULL && id > ptr->sig->id)
        {
            ptr = ptr->sig;
        }
        if (ptr->sig != NULL && ptr->sig->id == id)
        {
            ptr->sig->goles ++;
        }else{
            TListaJugadores newNode = malloc(sizeof(struct Jugador));
            if (newNode == NULL)
            {
                perror("No hay suficiente memoria disponible.\n");
                exit(-1);
            }else{
                newNode->goles = 1;
                newNode->id = id;
                newNode->sig = ptr->sig;
                ptr->sig = newNode;
            }
            
        }
    }
    
}

void recorrer(TListaJugadores lj){
    if (lj == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        TListaJugadores ptr = lj;
        printf("Lista de jugadores: ");
        while (ptr != NULL)
        {
            printf("%i:%i ",ptr->id,ptr->goles);
            if (ptr->goles > 1)
            {
                printf("goles ");
            }else{
                printf("gol ");
            }
            ptr = ptr->sig;
        }
        printf("\n");   
    }
}

int longitud(TListaJugadores lj){
    int cnt = 0;
    if (lj != NULL)
    {
        TListaJugadores ptr = lj;
        while (ptr != NULL)
        {
            cnt ++;
            ptr = ptr->sig;
        }
    }
    return cnt;
}

void eliminar(TListaJugadores *lj,unsigned int n){
    if (*lj == NULL)
    {
        printf("Lista vacía");
    }else if ((*lj)->goles < n)
    {
        TListaJugadores aux = *lj;
        *lj = (*lj)->sig;
        free(aux);
    }else{
        TListaJugadores ptr = *lj;
        TListaJugadores aux;
        while (ptr->sig != NULL)
        {
            if (ptr->sig->goles < n)
            {
                aux = ptr->sig;
                ptr->sig = aux->sig;
                free(aux);
            }
            ptr = ptr->sig;
        }   
    }  
}

unsigned int maximo(TListaJugadores lj){
    int id = 0;
    int ng = 0;
    if (lj != NULL)
    {
        TListaJugadores ptr = lj;
        while (ptr != NULL)
        {
            if (ptr->goles > ng || (ptr->goles == ng && ptr->id > id))
            {
                id = ptr->id;
                ng = ptr->goles;
            }
            ptr = ptr->sig;
        }  
    }
    return id;
}

void destruir(TListaJugadores *lj){
    if (*lj == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        TListaJugadores ptr;
        while (*lj != NULL)
        {
            ptr = *lj;
            *lj = (*lj)->sig;
            free(ptr);
        }
    }
}