//Ejercicio 1. Práctica 7

#include <iostream>
#include <array>
using namespace std;
const int N=4;
const int M=5;
typedef array<int,M>TFila;
typedef array<TFila,N>TMatriz;

void Leerdatos (TMatriz& a) {
    cout << "Introduzca por filas una matriz " << N << " x " << M << " :" << endl;
    for (int i=0;i<N;i++) {
        for (int j=0;j<M;j++) {
            cin >> a[i][j];
        }
    }
}

void SaberMayor (const TMatriz& a) {
     int x=a[0][0],fil,col;
     for (int i=0;i<N;i++) {
        for (int j=0;j<M;j++) {
            if (x<a[i][j]) {
                x=a[i][j];
                fil=i+1;
                col=j+1;
            }
        }
    }
    cout << "El mayor de la matriz es: " << x << " que aparece en la posicion: [" << fil << "] [" << col << "]";
}



int main()
{
    TMatriz a;
    Leerdatos (a);
    SaberMayor (a);

    return 0;
}

