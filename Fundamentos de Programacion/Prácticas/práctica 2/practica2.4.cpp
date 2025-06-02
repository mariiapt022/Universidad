//María Peinado Toledo
//Práctica 2. Ejercicio 4. 21/10/2020

#include <iostream>
using namespace std;


int main ()
{
    int dia, mes, anyo;

    cout<<"Introduzca el dia: ";
    cin>>dia;
    cout<<"Introduzca el mes: ";
    cin>>mes;
    cout<<"Introduzca el anyo: ";
    cin>>anyo;

    cout<<"Su fecha es el dia "<<dia<<" de ";
    switch (mes){
        case 1:
        cout<<"Enero";
        break;
        case 2:
        cout<<"Febrero";
        break;
        case 3:
        cout<<"Marzo";
        break;
        case 4:
        cout<<"Abril";
        break;
        case 5:
        cout<<"Mayo";
        break;
        case 6:
        cout<<"Junio";
        break;
        case 7:
        cout<<"Julio";
        break;
        case 8:
        cout<<"Agosto";
        break;
        case 9:
        cout<<"Septiembre";
        break;
        case 10:
        cout<<"Octubre";
        break;
        case 11:
        cout<<"Noviembre";
        break;
        case 12:
        cout<<"Diciembre";
        break;
    }
    cout<<" de "<<anyo<<".";
    return 0;

}
