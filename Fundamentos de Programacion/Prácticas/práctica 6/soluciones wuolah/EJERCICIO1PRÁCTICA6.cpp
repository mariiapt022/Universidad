/* Ejercicio 1 de la Práctica 6 de Laboratorio
   autor: Jesús Escudero Moreno
*/

#include <iostream>
#include <array>
using namespace std;
const int TAM=10;
typedef array<int,TAM>TVector;

void Leer (TVector& v1) {
    cout << "Introduzca 10 numeros enteros: ";
    for (int i=0;i<TAM;i++) {
        cin >> v1[i];
    }
}

void Secuencia (const TVector& v1) {
    int x=v1[0];
    for (int i=1;i<TAM;i++) {
        if (v1[i]>x) {
            x=v1[i];
        }
    }
    cout << "El mayor del array es: " << x;
}





int main()
{
    TVector v1;
    Leer (v1);
    Secuencia (v1);

    return 0;
}

