//Mar�a Peinado Toledo
//Relaci�n 1. Ejercicio 2. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num;
    bool tres_digitos= false;

    cout<<"Introduzca su n�mero entero:";
    cin>>num;

    if(num>=100 && num<=999){
        tres_digitos= true;
    }
    if(tres_digitos){
        cout<<"El n�mero es de tres digitos";
    }else{
    cout<<"El numero no es de tres digitos";
    }
    return 0;

}

