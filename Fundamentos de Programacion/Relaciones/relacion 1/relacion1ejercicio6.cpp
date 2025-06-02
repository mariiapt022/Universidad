//María Peinado Toledo
//Relación 1. Ejercicio 6. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num;
    bool pertenece_a_xuy= false;

    cout<<"Introduzca su numero:";
    cin>>num;

    if((num>=3 && num<=4)||(num>=6 && num<=9)){
        pertenece_a_xuy = true;
    }
    if(pertenece_a_xuy){
        cout<<"Su numero pertenece al conjunto XUY={3,4,6,8,9}U{6,7,8,3}.";
    }else{
        cout<<"Su numero no pertence al conjunto XUY={3,4,6,8,9}U{6,7,8,3}.";
    }
    return 0;
}

