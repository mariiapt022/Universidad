//María Peinado Toledo
//Práctica 3. Ejercicio 1.2(do-while). 28/10/2020

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

    do{
         suma=suma+cont;
        cont++;
    }while (cont<=N);

    cout<<"La suma de los "<<N<<" primeros numeros es "<<suma<<endl;

    return 0;
}
