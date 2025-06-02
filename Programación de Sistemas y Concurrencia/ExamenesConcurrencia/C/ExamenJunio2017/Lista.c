#include <stdio.h>
#include <stdlib.h>
#include "Lista.h"

void crearLista(TLista *lista){
    *lista = NULL;
}

void insertarPunto(TLista *lista, struct Punto punto, int * ok){
    if (*lista == NULL)
    {
        TLista newPoint = malloc(sizeof(struct Nodo));
        if (newPoint == NULL)
        {
            perror("No hay suficiente memoria disponible.\n");
            exit(-1);
        }
        newPoint->punto.x = punto.x;
        newPoint->punto.y = punto.y;
        newPoint->sig = NULL;
        *lista = newPoint;
        *ok = 1;
    }else if (punto.x < (*lista)->punto.x)
    {
        TLista newPoint = malloc(sizeof(struct Nodo));
        if (newPoint == NULL)
        {
            perror("No hay suficiente memoria disponible.\n");
            exit(-1);
        }
        newPoint->punto.x = punto.x;
        newPoint->punto.y = punto.y;
        newPoint->sig = *lista;
        *lista = newPoint;
        *ok = 1;
    }else{
        TLista ptr = *lista;
        while (ptr->sig != NULL && punto.x > ptr->sig->punto.x)
        {
            ptr = ptr->sig;
        }
        if (ptr->sig != NULL && ptr->sig->punto.x == punto.x)
        {
            *ok = 0;
        }else
        {
           TLista newPoint = malloc(sizeof(struct Nodo));
            if (newPoint == NULL)
            {
                perror("No hay suficiente memoria disponible.\n");
                exit(-1);
            }
            newPoint->punto.x = punto.x;
            newPoint->punto.y = punto.y;
            newPoint->sig = ptr->sig;
            ptr->sig = newPoint;
            *ok = 1;     
        }
    }
}

void eliminarPunto(TLista *lista, float x,int* ok){
    if (*lista == NULL)
    {
        *ok = 0;
        printf("Lista vacía.\n");
    }else{
        TLista ptr = *lista;
        while (ptr->sig != NULL && ptr->punto.x != x)
        {
            ptr = ptr->sig;
        }
        if (ptr->sig != NULL)
        {
            TLista aux = ptr->sig;
            ptr->sig = aux->sig;
            free(aux);
        }else{
            *ok = 0;
        }
    }
}

void mostrarLista(TLista lista){
    if (lista == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        TLista ptr = lista;
        printf("Lista: ");
        while (ptr != NULL)
        {
            printf("%f|%f ",ptr->punto.x,ptr->punto.y);
            ptr = ptr->sig;
        }
        printf("\n");
    }
}

void destruir(TLista *lista){
    if (*lista == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        TLista ptr;
        while (*lista != NULL)
        {
            ptr = *lista;
            *lista = (*lista)->sig;
            free(ptr);
        }
    }
}

void leePuntos(TLista *lista, char * nFichero){
    FILE *f = fopen(nFichero,"rb");
    if (f == NULL)
    {
        printf("Error al abrir el fichero.\n");
        exit(-1);
    }
    *lista = NULL;
    int ok;
    float id[2];
    struct Punto p;
    while (fread(&id,sizeof(float),2,f) == 2)
    {
        p.x = id[0];
        p.y = id[1];
        insertarPunto(lista,p,&ok);
    }
    
}