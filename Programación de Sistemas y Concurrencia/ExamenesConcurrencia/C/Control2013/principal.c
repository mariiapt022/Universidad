#include <stdio.h>
#include <assert.h>
#include "control2013.h"

int main(void) {

	T_Planificador lista;

    crear(&lista);
    assert(lista == NULL);

    mostrar(lista);

    planificar(&lista);
    assert(lista == NULL);

    insertar_tarea(&lista, 1, "t3");
    assert(lista->pri == 1);

    planificar(&lista);
    assert(lista == NULL);

    insertar_tarea(&lista, 8, "t1");
    insertar_tarea(&lista, 3, "t7");
    insertar_tarea(&lista, 4, "t8");
    insertar_tarea(&lista, 8, "t2");
    insertar_tarea(&lista, 1, "t3");
    assert(lista->pri == 8);
    assert(lista->sig->pri == 8);
    assert(lista->sig->sig->pri == 4);
    assert(lista->sig->sig->sig->pri == 3);
    assert(lista->sig->sig->sig->sig->pri == 1);
    mostrar(lista); // 8 8 4 3 1

    planificar(&lista);
    planificar(&lista);
    assert(lista->pri == 4);

    mostrar(lista); // 4 3 1

    unsigned ok;
    eliminar_tarea(&lista,"t7",&ok);
    assert(ok == 1);
    eliminar_tarea(&lista,"t8",&ok);
    assert(ok == 1);
    eliminar_tarea(&lista,"t10",&ok);
    assert(ok == 0);
    assert(lista->pri == 1);
    mostrar(lista);
    
    destruir(&lista);
    mostrar(lista);

    return 0;
}

