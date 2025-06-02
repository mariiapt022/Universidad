//María Peinado Toledo
//Práctica 7. Ejercicio 4. 13/01/2021

#include <iostream>
#include <array>
using namespace std;
const int N=5;
typedef array<int,N>TFila;
typedef array<TFila,N>TMatriz;

void Iniciar(TMatriz& a, int k, int fil, int col){
    cout << "El cuadrado magico para N="<<N<<" es: "<< endl;
    for (int i=0;i<N;i++) {
        for (int j=0;j<N;j++) {
            a[i][j]=0;
            a[fil][col]=k;
        }
    }
}

void Secuencia(TMatriz& a, int& k, int& fil, int& col, int cont) {
   while (k<cont) {
      k++;
      fil--;
      col--;
    if (fil==-1) {
        fil=N-1;
    }
    if (col==-1) {
        col=N-1;
    }
    if ((a[fil][col]!=0)) {
        fil=fil+2;
        col++;
    }
    a[fil][col]=k;
    if ((fil==0)&&(col==0)) {
      fil=2;
      col=1;
   }
   }
}

void Mostrar (const TMatriz& a) {
    for (int i=0;i<N;i++) {
        for (int j=0;j<N;j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main()
{
    TMatriz a;
    int k=1,fil=0,col=N/2;
    int cont=N*N;
    Iniciar(a,k,fil,col);
    Secuencia(a,k,fil,col,cont);
    Mostrar(a);

    return 0;
}
