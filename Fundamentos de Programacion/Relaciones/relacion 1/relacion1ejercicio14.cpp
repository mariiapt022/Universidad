//María Peinado Toledo
//Relación 1. Ejercicio 14. 16/10/2020

#include <iostream>
using namespace std;
int main()
{
    int n1;

    cout <<"Introduzca su numero entero:";
    cin>>n1;

    if((n1%3==0)||(n1%4==0)||(n1%5==0)){
        cout<<"Su numero es multiplo de 3,4,o 5.";
    }else{
        cout<<"Su numero no es multiplo de 3,4,ó 5.";
    }
    return 0;

}
