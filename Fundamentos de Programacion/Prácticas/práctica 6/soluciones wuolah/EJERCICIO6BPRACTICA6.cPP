//María Peinado Toledo
//Práctica 6. Ejercicio 6B (Ejercicio 11 de la Tercera relación). 14/12/2020

#include <iostream>
#include <array>
using namespace std;
const int N=5;
typedef array<int,N>TArray;

struct TVector{
    bool tienecentro;
    int izq,der,ind,num,res;
    TArray V;
};

void Leerdatos (TVector& v1) {
    cout << "El contenido del vector es: ";
     for (int i=0;i<N;i++) {
        cin >> v1.V[i];
        if (v1.V[i]<0) {
        cout << "ERROR: Numero negativo" << endl;
     }
    }
}

void centroVector (TVector& v1) {
    int I,i2;
    v1.tienecentro=false;
    v1.izq = 0, v1.der = 0;
    for (int c=1;c<=N-2;c++) {
    for (int i=0;i<=c-1;i++) {
        v1.izq += ((c-i)*(v1.V[i]));
    }
    for (int j=c+1;j<=N-1;j++) {
        v1.der += ((j-c)*(v1.V[j]));
    }
    if (v1.izq==v1.der) {
        v1.tienecentro = true;
        v1.ind=c;
        v1.num=v1.V[c];
        v1.res=v1.izq;
    }
  }
}

void Salida (TVector& v1) {
    if (v1.tienecentro==true){
    cout << "El centro de este vector es el indice " << v1.ind << " (casilla donde esta el " << v1.num << ") ya que " << endl;
    cout << "ambos sumatorios dan: " << v1.res;
} else {
    cout << "Este vector no tiene centro";
 }
}

int main()
{
    TVector v1;
    Leerdatos (v1);
    centroVector (v1);
    Salida (v1);

  return 0;
}
