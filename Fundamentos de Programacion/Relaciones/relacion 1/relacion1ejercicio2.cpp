//María Peinado Toledo
//Relación 1. Ejercicio 2. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num;
    bool tres_digitos= false;

    cout<<"Introduzca su número entero:";
    cin>>num;

    if(num>=100 && num<=999){
        tres_digitos= true;
    }
    if(tres_digitos){
        cout<<"El número es de tres digitos";
    }else{
    cout<<"El numero no es de tres digitos";
    }
    return 0;

}

