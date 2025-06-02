//María Peinado Toledo
//Relación 1. Ejercicio 1. 16/10/2020

#include <iostream>
using namespace std;

int main ()
{
    int num;
    bool par= false;

    cout << "Introduzca su número entero:";
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

