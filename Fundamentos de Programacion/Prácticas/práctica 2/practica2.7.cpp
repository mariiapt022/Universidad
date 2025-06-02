//María Peinado Toledo
//Práctica 2. Ejercicio 7. 21/10/2020

#include <iostream>
using namespace std;

int main()
{
    int mes;

    cout<<"Introduzca numero de mes ";
    cin>>mes;

    switch (mes){
        case 1:
        cout<<"Este mes tiene 31 dias.";
        break;
        case 2:
        cout<<"Este mes tiene 28 dias.";
        break;
        case 3:
        cout<<"Este mes tiene 31 dias.";
        break;
        case 4:
        cout<<"Este mes tiene 30 dias.";
        break;
        case 5:
        cout<<"Este mes tiene 31 dias.";
        break;
        case 6:
        cout<<"Este mes tiene 30 dias.";
        break;
        case 7:
        cout<<"Este mes tiene 31 dias.";
        break;
        case 8:
        cout<<"Este mes tiene 31 dias.";
        break;
        case 9:
        cout<<"Este mes tiene 30 dias.";
        break;
        case 10:
        cout<<"Este mes tiene 31 dias.";
        break;
        case 11:
        cout<<"Este mes tiene 30 dias.";
        break;
        case 12:
        cout<<"Este mes tiene 31 dias.";
        break;
        default:
        cout << "Mes incorrecto";
    }
    return 0;

}

