//María Peinado Toledo
//Práctica 2. Ejercicio 6. 21/10/2020

#include <iostream>
using namespace std;

const double PRIMEROS_100= 0.5;
const double SIGUIENTES_150= 0.35;
const double RESTO= 0.25;

int main()
{
    int consumoTotal;
    float precioFinal;

    cout<<"Introduzca el consumo del contador: ";
    cin>>consumoTotal;

    if(consumoTotal<=100){
        precioFinal= 1+ (consumoTotal * PRIMEROS_100);
    }else if(consumoTotal<=250){
        precioFinal= 1 + (100 * PRIMEROS_100) + ((consumoTotal-100) * SIGUIENTES_150);
    }else if(consumoTotal>250){
        precioFinal= 1 + (100 * PRIMEROS_100) + (150* SIGUIENTES_150)+ ((consumoTotal-250)*RESTO);
    }

    cout<<"El importe a pagar es de "<<precioFinal<<" euros.";
    return 0;


}
