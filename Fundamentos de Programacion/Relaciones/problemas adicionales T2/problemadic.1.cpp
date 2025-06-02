//María Peinado Toledo
//Problemas adicionales Tema 2. Ejercicio 1. 01/11/2020

#include <iostream>
using namespace std;

int main()
{
    int n, num, contador=0, potencia=1;

    cout<<"Introduzca el numero: ";
    cin>>num;

    cout<<"Introduzca el valor de n: ";
    cin>>n;

    for(int i=2; num>potencia; i++){
        contador++;
        potencia=1;

        for(int j=0; j<n; j++){
            potencia=potencia*i;
        }
    }
    cout<<"La raiz n-esima de "<<num<<" es: "<<contador<<endl;

    return 0;
}
