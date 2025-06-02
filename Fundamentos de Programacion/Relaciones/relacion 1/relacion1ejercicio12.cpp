//María Peinado Toledo
//Relación 1. Ejercicio 12. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int edad;

    cout<<"Introduzca una edad:";
    cin>>edad;

    if (edad >= 65){
        cout << "Jubilado";
    }else if (edad < 18){
        cout << "Menor de edad";
    }else{
        cout << "Activo";
    }
    return 0;

}
