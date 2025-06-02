//María Peinado Toledo
//Relación 1. Ejercicio 5. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num;
    bool pertenece_a_x= false;

    cout<<"Introduzca su numero:";
    cin>>num;

    if((num>=1 && num<=3)||(num>=7 && num<=9)){
        pertenece_a_x = true;
    }
    if(pertenece_a_x){
        cout<<"Su numero pertenece al conjunto X={1,2,3,7,8,9}.";
    }else{
        cout<<"Su numero no pertence al conjunto X={1,2,3,7,8,9}.";
    }
    return 0;
}
