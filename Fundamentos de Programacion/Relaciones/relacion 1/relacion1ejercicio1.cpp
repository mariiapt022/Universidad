//Mar�a Peinado Toledo
//Relaci�n 1. Ejercicio 1. 16/10/2020

#include <iostream>
using namespace std;

int main ()
{
    int num;
    bool par= false;

    cout << "Introduzca su n�mero entero:";
    cin>>num;

    if(num%2==0){
        par = true;
        }
    if(par){
        cout<<"El numero es par";
    }else{
        cout<<"El numero no es par";
    }

    return 0;
}

