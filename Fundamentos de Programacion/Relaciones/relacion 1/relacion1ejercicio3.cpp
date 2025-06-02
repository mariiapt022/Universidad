//María Peinado Toledo
//Relación 1. Ejercicio 3. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num;
    bool divisor_de_100=false;

    cout<<"Introduzca su numero:";
    cin>>num;

    if(100%num==0){
        divisor_de_100=true;
    }
    if(divisor_de_100){
        cout<<"El numero es divisor de 100";
    }else{
        cout<<"El numero no es divisor de 100";
    }
    return 0;

}
