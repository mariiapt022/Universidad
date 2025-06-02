/*
 * Principal.c
 *
 *  Created on: 18/06/2012
 *      Author: PSCC
 */

#include <stdio.h>
#include "MProcesos.h"
#include <stdlib.h>


int main () {

	LProc plan;


	printf("Creamos una lista vacia\n");
	Crear(&plan);
	EjecutarProcesos(plan);

	printf("Anadir proceso  1 \n");
	AnadirProceso(&plan,1);
	printf("Anadir proceso 8\n");
	AnadirProceso(&plan,8);
	printf("Anadir proceso 3 \n");
	AnadirProceso(&plan,3);
	printf("Anadir proceso  4 \n");
	AnadirProceso(&plan,4);
	printf("Anadir proceso 6 \n");
	AnadirProceso(&plan,6);

	EjecutarProcesos(plan);

	printf("Eliminamos proceso 1\n");
	EliminarProceso(1,&plan);
	EjecutarProcesos(plan);

	printf("Eliminamos proceso 6\n");
	EliminarProceso(6,&plan);
	EjecutarProcesos(plan);

	EscribirFichero("Salida.bin",&plan);
	EjecutarProcesos(plan);
	FILE *f = fopen("Salida.bin","rb");
	if (f == NULL)
	{
		perror("Error al abrir el archivo.\n");
		exit(-1);
	}

	int id;
	int nproc;
	fread(&nproc,sizeof(int),1,f);
	printf("Hay %i procesos: ",nproc);
	while (fread(&id,sizeof(int),1,f) == 1)
	{
		printf("%i ",id);
	}
	
	fclose(f);
	return 0;

}
