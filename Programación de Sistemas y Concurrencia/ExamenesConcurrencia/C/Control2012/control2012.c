#include <stdio.h>
#include <stdlib.h>
#include "control2012.h"

void CrearABB (TArbol *arb){
    *arb = NULL;
}

void InsertarEnABB (TArbol *arb, int elem){
    if (*arb == NULL)
    {
        TArbol newNode = malloc(sizeof(struct TNodo));
        newNode->num = elem;
        newNode->izq = NULL;
        newNode->der = NULL;
        *arb = newNode;
    }else{
        TArbol ptr = *arb;
        if (elem < ptr->num)
        {
            InsertarEnABB(&ptr->izq, elem);
        }else{
            InsertarEnABB(&ptr->der, elem);
        }
    }
    
}
void RecorrerABB (TArbol arb){
    if (arb == NULL)
    {
        printf("Árbol vacío\n");
    }else{
        TArbol ptr = arb;
        if (ptr->izq != NULL)
        {
            RecorrerABB(ptr->izq);
        }

        printf("%i ",ptr->num);

        if (ptr->der != NULL)
        {
            RecorrerABB(ptr->der);
        }
        
        
    }
    
}
void DestruirABB(TArbol *arb){
    if (*arb == NULL)
    {
        printf("Árbol vacío\n");
    }else{
        TArbol ptr = *arb;
        if (ptr->izq != NULL)
        {
            DestruirABB(&ptr->izq);
        }

        if (ptr->der != NULL)
        {
            DestruirABB(&ptr->der);
        }
        
        free(ptr);
        *arb = NULL;
        
    }
    
}