//María Peinado Toledo
//Relación 1. Ejercicio 21. 24/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num, secuencia;
    do{
        cout<<"Introduzca su numero entero distinto de 0:";
        cin>>num;
    }while(num==0);

    cout<<"Introduzca una secuencia de numeros enteros terminada en cero.";
    do{
        cin>>secuencia;
    }while((secuencia!=num)&& (secuencia!=0));

    if(num==secuencia){
        cout<<"El numero "<<num<<" si aparece en la secuencia.";
    }else{
        cout<<"El numero "<<num<<" no aparece en la secuencia.";
    }
    return 0;
}


