#include <stdio.h>
#include <assert.h>
#include "control2012.h"

int main(void) {

	TArbol prueba;

    CrearABB(&prueba);

    InsertarEnABB(&prueba, 30);
    InsertarEnABB(&prueba, 27);
    InsertarEnABB(&prueba, 40);
    InsertarEnABB(&prueba, 3);
    InsertarEnABB(&prueba, 5);
    InsertarEnABB(&prueba, 32);

    assert(prueba->num==30);
    assert(prueba->izq->num==27);
    assert(prueba->izq->izq->num==3);
    assert(prueba->izq->izq->der->num==5);
    assert(prueba->der->num==40);
    assert(prueba->der->izq->num==32);

    RecorrerABB(prueba);

    DestruirABB(&prueba);

    RecorrerABB(prueba);

    return 0;
}

