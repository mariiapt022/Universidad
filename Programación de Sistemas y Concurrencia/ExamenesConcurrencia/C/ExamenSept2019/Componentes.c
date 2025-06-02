#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Componentes.h"


int Lista_Vacia(Lista lista){
    if (lista == NULL)
    {
        return 1;
    }else{
        return 0;
    }
    
}

int Num_Elementos(Lista  lista){
    int cnt = 0;
    if (lista != NULL)
    {
        Lista ptr = lista;
        while (ptr != NULL)
        {
            cnt ++;
            ptr = ptr->sig;
        }
    }
    return cnt;
}

void Adquirir_Componente(long *codigo,char *texto){
    printf("introduce el codigo: \n");
	scanf("%ld",codigo);
    printf("introduce el texto: \n");
	scanf("%s",texto);
}

void Lista_Imprimir(Lista lista){
    if (lista == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        Lista ptr = lista;
        printf("Lista: ");
        while (ptr != NULL)
        {
            printf("%i|%s ",ptr->codigoComponente,ptr->textoFabricante);
            ptr = ptr->sig;
        }
        printf("\n");
    }  
}

void Lista_Salvar(Lista  lista){
    FILE *f = fopen("examen.dat","wb");
    if (f == NULL)
    {
        perror("Error al abrir el fichero.\n");
        exit(-1);
    }

    int nelms = Num_Elementos(lista);
    int i = 0;
    int l;
    Lista ptr = lista;
    while (i < nelms)
    {
        l = strlen(ptr->textoFabricante);
        fwrite(&(ptr->codigoComponente),sizeof(long),1,f);
        fwrite(&l,sizeof(int),1,f);
        fwrite(&(ptr->textoFabricante),sizeof(char),l,f);
        i ++;
    }
    fclose(f);
}

Lista Lista_Crear(){
    Lista l = NULL;
    return l;
}

void Lista_Agregar(Lista *lista, long codigo, char* textoFabricante){
    Lista newComp = malloc(sizeof(Componente));
    if (newComp == NULL)
    {
        perror("No hay suficiente memoria disponible.\n");
        exit(-1);
    }
    
    newComp->codigoComponente = codigo;
    strcpy(newComp->textoFabricante,textoFabricante);
    newComp->sig = NULL;
    if (*lista == NULL)
    {
        *lista = newComp;   
    }else{
        Lista ptr = *lista;
        while (ptr->sig != NULL)
        {
            ptr = ptr->sig;
        }
        ptr->sig = newComp;
    }
    
}

void Lista_Extraer(Lista *lista){
    if (*lista == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        Lista prev = *lista;
        Lista curr = (*lista)->sig;
        if (curr == NULL)
        {
            *lista = NULL;
            free(prev);
        }else{
            while (curr->sig != NULL)
            {
                prev = curr;
                curr = curr->sig;
            }
            prev->sig = NULL;
            free(curr);
        }
    }
}

void Lista_Vaciar(Lista *lista){
    if (*lista == NULL)
    {
        printf("Lista vacía.\n");
    }else{
        Lista ptr;
        while (*lista != NULL)
        {
            ptr = *lista;
            *lista = (*lista)->sig;
            free(ptr);
        }
    }
}