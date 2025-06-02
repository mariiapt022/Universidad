//María Peinado Toledo
//Relación 1. Ejercicio 19. 22/10/2020

#include <iostream>
using namespace std;
int main()
{
    int contComas=0, contCar=0;
    char car;
    cout<<"Introduzca su texto acabado en punto: ";
    car=cin.get();

    while(car!='.'){
        contCar++;
        if(car == ','){
            contComas++;
        }
    car=cin.get();
    }
    cout<<"Numero de comas: "<< contComas <<endl;
    cout<<"Numero de caracteres: "<<contCar;

    return 0;
}
