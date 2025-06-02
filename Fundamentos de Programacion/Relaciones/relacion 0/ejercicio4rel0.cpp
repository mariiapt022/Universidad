//*María Peinado Toledo
//Programa: Diseña un algoritmo que lea un carácter (suponemos que será una letra mayúscula),
//le convierta a minúscula y lo muestre por pantalla.

#include <iostream>
using namespace std;

int main ()

{

    char mayuscula;
    int minuscula;

    cout << "Programa para convertir mayúsculas a minúsculas" <<endl;
    cout << endl << "Introduzca una letra mayúscula ";
    cin >> mayuscula;

    minuscula= int(mayuscula)+32;
    //32 puestos entre una mayuscúla y su minúscula

    cout << "Su letra minúscula es" << char(minuscula) << endl;

    return 0;

}

