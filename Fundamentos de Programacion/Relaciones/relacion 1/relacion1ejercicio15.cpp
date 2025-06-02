//María Peinado Toledo
//Relación 1. Ejercicio 15. 16/10/2020

#include <iostream>
using namespace std;
int main()
{
    int unidades, precio;
    cout<<"Introduzca el numero de unidades: ";
    cin>>unidades;

    if(unidades==1){
        precio=unidades*100;
        cout<<"Su precio total es de: "<<precio;
    }else if(unidades==2){
        precio=unidades*95;
        cout<<"Su precio total es de: "<<precio;
    }else if(unidades==3){
        precio=unidades*90;
        cout<<"Su precio total es de: "<<precio;
    }else if(unidades>=4){
        precio=unidades*85;
        cout<<"Su precio total es de: "<<precio;
    }
    return 0;
}
