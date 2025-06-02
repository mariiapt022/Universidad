#include <stdio.h>
#define MAXPRI 20

typedef struct Nodo *T_Array[MAXPRI];

typedef struct Proceso *T_Cola;

struct Nodo
{
    T_Cola proc;
};

struct Proceso
{
    int id;
    T_Cola sig;
};

crear(T_Array *array);


