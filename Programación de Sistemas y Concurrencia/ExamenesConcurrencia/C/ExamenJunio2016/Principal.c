/*
 * Principal.c
 *
 *  Created on: 14/6/2016
 *      Author: esc
 */

#include "ListaJugadores.h"
#include <stdio.h>
#include <stdlib.h>



// Lee el fichero y lo introduce en la lista
void cargarFichero (char * nombreFich, TListaJugadores *lj)
{	
	FILE *file = fopen(nombreFich,"rb");
	if (file == NULL)
	{
		perror("Error al abrir el archivo.\n");
		exit(-1);
	}
	unsigned int id[3];
	while (fread(&id,sizeof(unsigned),3,file) == 3)
	{
		insertar(&(*lj), id[1]);
	}
	fclose(file);
}


int main(){

	TListaJugadores lj;
	crear(&lj);
    unsigned int num_goles;
	cargarFichero ("goles.bin",&lj);
	printf("Hay un total de %d jugadores\n",longitud(lj));
	fflush(stdout);

	recorrer(lj);
	fflush(stdout);
	printf("Introduce un n�mero de goles: \n");
	fflush(stdout);
	scanf("%d",&num_goles);


	eliminar(&lj,num_goles);
	printf("--------------------------------------\n");
	recorrer(lj);
	printf("Hay un total de %d jugadores\n",longitud(lj));
	fflush(stdout);

	printf ("El jugador que m�s goles ha marcado es el que tiene ID: %d",maximo(lj));
	fflush(stdout);
	destruir (&lj);

	return 0;
}
