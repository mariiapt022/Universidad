//María Peinado Toledo
//Práctica 6. Ejercicio 5. 14/12/2020

#include <iostream>
#include <array>
using namespace std;
const int MAX=100;
typedef array<int,MAX>TArray;

struct TVector {
    int N;
    TArray lista;
};

void Rellenar (TVector& v1) {
    for (int i=0;i<MAX;i++) {
        v1.lista[i]=i+1;
    }
}

void Leerdatos (TVector& v1) {
    do {
        cout << "Introduzca el limite para calcular los primos (> 0 y <= " << MAX << ") : ";
        cin >> v1.N;
    } while ((v1.N <= 0)||(v1.N>MAX));
}

void eratostenes (TVector& v1) {
    v1.lista[0]=0;
    for (int i=1;i<v1.N;i++) {
      if(v1.lista[i] != 0){
        for (int j=i+1;j<v1.N;j++){
           if((j+1)%(i+1) == 0){
           v1.lista[j] = 0;
           }
          }
        }
      }
}

void Salida (const TVector& v1){
    cout << "Los numeros primos menores o iguales que " << v1.N << " son: " << endl;
    for (int i=0;i<v1.N;i++) {
        if (v1.lista[i] != 0) {
            cout << v1.lista[i] << " ";
        }
    }
}


int main()
{
    TVector v1;
    Rellenar (v1);
    Leerdatos(v1);
    eratostenes (v1);
    Salida (v1);

    return 0;
}
