//María Peinado Toledo
//Relación 1. Ejercicio 7. 16/10/2020

#include <iostream>
using namespace std;

int main()
{
    int x,y;
    bool mayores_de_10=true;

    cout<<"Introduzca un valor para 'x' y otro para 'y' respectivamente:";
    cin>>x>>y;

    if(x<10 && y<10){
        mayores_de_10=false;
    }
    if(mayores_de_10){
        cout<<"Sus numeros son mayores de 10";
    }else{
        cout<<"Alguno de sus numeros o ambos son menores de 10";
    }
    return 0;

}
