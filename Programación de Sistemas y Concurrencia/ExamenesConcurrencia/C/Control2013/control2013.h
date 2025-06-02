#include <stdio.h>

typedef struct Tarea *T_Planificador;

struct Tarea
{
    char *id;
    int pri;
    T_Planificador sig;
};

void crear(T_Planificador *planif);
void insertar_tarea(T_Planificador *planif,int pri,char *id);
void mostrar (T_Planificador planificador);
void eliminar_tarea(T_Planificador *planif,char *id,unsigned *ok);
void planificar(T_Planificador *planif);
void destruir(T_Planificador *planif);