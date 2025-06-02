//María Peinado Toledo
//Práctica 3. Ejercicio 1.1. 28/10/2020

#include <iostream>
using namespace std;

int main()
{
    int N,cont,suma;
    cont=1;
    suma=0;

    do{
        cout<<"Introduzca su numero entero mayor que cero: ";
        cin>>N;
    }while(N<=0);

    while(cont<=N){
        suma=suma+cont;
        cont++;
    }

    cout<<"La suma de los "<<N<<" primeros numeros es "<<suma<<endl;

    return 0;
}

