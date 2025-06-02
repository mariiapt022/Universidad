//María Peinado Toledo
//Relación 1. Ejercicio 8. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    char c;
    bool mayuscula=false;

    cout<<"Introduzca su letra:";
    cin>>c;

    if(c>='A' && c<='Z'){
        cout<<"La letra es mayuscula";
    }else{
        cout<<"La letra es minuscula";
    }
    return 0;
}

