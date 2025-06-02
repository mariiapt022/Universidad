//Ejercicio 2. Práctica 7

#include <iostream>
#include <array>
using namespace std;
const int N=4;
typedef array<int,N>TFila;
typedef array<TFila,N>TMatriz;

void Leerdatos (TMatriz& a) {
    cout << "Introduzca por filas una matriz " << N << " x " << N << " :" << endl;
    for (int i=0;i<N;i++) {
        for (int j=0;j<N;j++) {
            cin >> a[i][j];
        }
    }
}

void SaberSim (TMatriz& a) {
    bool simetrica=true;
     for (int i=0;i<N;i++) {
        for (int j=0;j<N;j++) {
            if (a[j][i]!=a[i][j]) {
                simetrica=false;
            }
        }
    }
    if (simetrica==true) {
        cout << "SI es simetrica";
    } else {
        cout << "NO es simetrica";
    }
}





int main()
{
    TMatriz a;
    Leerdatos (a);
    SaberSim(a);

    return 0;
}
