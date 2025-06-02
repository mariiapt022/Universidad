//María Peinado Toledo
//Práctica 1. Ejercicio 9. 14/10/2020

#include <iostream>
using namespace std;

int main()
{
    int n1, n2, suma;
    cout<<"Introduzca su primer numero:";
    cin>>n1;
    cout<<"Introduzca su segundo numero:";
    cin>>n2;

    suma= n1+n2;

    cout<<"El resultado de la suma de ellos es:"<<suma;

    return 0;

}

/*El programa no funciona para la suma de 1 + 3000000000 porque el último valor
excede del valor máximo permitido para los enteros de int.*/
