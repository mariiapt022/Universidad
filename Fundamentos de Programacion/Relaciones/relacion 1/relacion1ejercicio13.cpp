//María Peinado Toledo
//Relación 1. Ejercicio 13. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int n1,n2;
    bool divisor1= false;
    bool divisor2= false;

    cout<<"Introduzca su primer numero:";
    cin>>n1;

    cout<<"Introduzca su segundo numero:";
    cin>>n2;

    if (n1%n2==0){
        cout << n2<<" es divisor de "<<n1;
    }else if (n2%n1==0){
        cout << n1<<" es divisor de "<<n2;
    }else{
        cout << "Los numeros son indivisibles.";
    }
    return 0;

}
