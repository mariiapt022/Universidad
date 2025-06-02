#include <stdio.h>

typedef struct TNodo *TArbol;

struct TNodo {
	int num;
	TArbol izq, der;
};

// Inicializa la estructura a NULL.
void CrearABB (TArbol *arb);

// Inserta num en el arbol, no se permiten dos iguales (revisa el concepto de árbol binario de búsqueda)
void InsertarEnABB (TArbol *arb, int elem);

void RecorrerABB (TArbol arb);

// Destruye la estructura utilizada.
void DestruirABB(TArbol *arb);