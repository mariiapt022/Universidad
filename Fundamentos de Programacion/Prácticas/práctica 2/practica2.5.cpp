//María Peinado Toledo
//Práctica 2. Ejercicio 5. 21/10/2020

#include <iostream>
using namespace std;

const int PRECIO_UNIDAD = 100;
const double IVA = 0.12;
const double DESCUENTO = 0.05;

int main()
{
    int numUnidades;
    float precioTotal,precioDescuento;
    cout<<"Introduzca el numero de unidades: ";
    cin>>numUnidades;

    precioTotal= numUnidades*PRECIO_UNIDAD + (numUnidades*PRECIO_UNIDAD)*IVA;

    if(precioTotal>300){
        precioDescuento= precioTotal-(precioTotal)*DESCUENTO;
        cout<<"Se aplica un descuento del"<<DESCUENTO*100<<"%"<<endl;
        cout<<"Su precio final es de "<<precioDescuento<<" euros.";
    }else{
        cout<<"Su precio final es de "<<precioTotal<<" euros.";
    }
    return 0;

}
