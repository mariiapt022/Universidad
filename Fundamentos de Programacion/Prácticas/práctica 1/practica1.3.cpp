//María Peinado Toledo
//Práctica 1. Ejercicio 3. 14/10/2020

/*Explica las diferencias: Cuando introducimos un entero, el compilador recoge el dato y lo
convierte al valor de tipo correspondiente. Pero en el caso de una palabra u otro dato distinto a int
el compilador quiere buscar el número al que equivale cada letra
pero como no encuentra muestra el cero*/

#include <iostream>
using namespace std;

int main ()
{
    int dato;
    cout<<"Introduzca su numero entero:";
    cin>>dato;
    cout << "Su numero entero es:" <<dato<<endl;

    return 0;

}
