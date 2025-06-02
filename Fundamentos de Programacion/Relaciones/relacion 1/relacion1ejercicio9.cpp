//María Peinado Toledo
//Relación 1. Ejercicio 9. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    char c;
    bool letra;

    cout<<"Introduzca su dato:";
    cin>>c;

    if((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
        cout<<"Su dato es una letra.";
    }else{
        cout<<"Su dato no es una letra.";
    }
    return 0;

}

