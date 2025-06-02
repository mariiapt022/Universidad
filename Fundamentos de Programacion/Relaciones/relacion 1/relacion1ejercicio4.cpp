//María Peinado Toledo
//Relación 1. Ejercicio 4. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num;
    bool pertenece_a_x= false;

    cout<<"Introduzca su numero:";
    cin>>num;

    if(num>=3 && num<=7){
        pertenece_a_x = true;
    }
    if(pertenece_a_x){
        cout<<"Su numero pertenece al conjunto X={3,4,5,6,7,8}.";
    }else{
        cout<<"Su numero no pertence al conjunto X={3,4,5,6,7,8}.";
    }
    return 0;
}

