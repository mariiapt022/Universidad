//*Mar�a Peinado Toledo
//Programa: Dise�a un algoritmo que lea un car�cter (suponemos que ser� una letra may�scula),
//le convierta a min�scula y lo muestre por pantalla.

#include <iostream>
using namespace std;

int main ()

{

    char mayuscula;
    int minuscula;

    cout << "Programa para convertir may�sculas a min�sculas" <<endl;
    cout << endl << "Introduzca una letra may�scula ";
    cin >> mayuscula;

    minuscula= int(mayuscula)+32;
    //32 puestos entre una mayusc�la y su min�scula

    cout << "Su letra min�scula es" << char(minuscula) << endl;

    return 0;

}

