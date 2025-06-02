//María Peinado Toledo
//Práctica 1. Ejercicio 11. 14/10/2020

#include <iostream>
using namespace std;


int main()
{
    double nteoria, nproblemas, nfinal;

    cout<<"Introduzca la nota de la parte teorica:";
    cin>>nteoria;
    cout<<"Introduzca la nota de la parte practica:";
    cin>>nproblemas;

    nfinal= nteoria*0.7 + nproblemas*0.3;

    cout<<"Su nota final es de un:"<<nfinal<<endl;

    return 0;


}
