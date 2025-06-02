//María Peinado Toledo
//Relación 1. Ejercicio 20. 22/10/2020

#include <iostream>
using namespace std;
int main()
{
    int num, contDigitoPar, copia, digito;
    do{
        cout<<"Introduzca su numero positivo: ";
        cin>>num;

    copia=num;

    }while(num<0);

    while(num!=0){
        digito=num%10;
        num=num/10;
        if(digito%2==0){
            contDigitoPar++;
        }
    }
    cout<<copia<<" tiene "<<contDigitoPar<<" digito(s) par(es).";

}
