//Ejercicio 3. Práctica 7

#include <iostream>
#include <array>
using namespace std;
const int N=5;
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

unsigned sumaFila(const TMatriz& matriz, unsigned n, unsigned fila){
 unsigned suma = 0;
 for(unsigned i = 0; i < n; i++){
  suma+= matriz[fila][i];

 }

 return suma;
}

bool sumaFilas(const TMatriz& matriz, unsigned n, unsigned& ant1){
 bool sumasNoIguales= true;
 unsigned i = 1;
 ant1 = sumaFila(matriz, n, 0);
 while(sumasNoIguales== true && i < n){
  if(ant1 == sumaFila(matriz,n, i)){
   sumasNoIguales = true;
  }else{
   sumasNoIguales = false;
  }
  i++;
 }
 return sumasNoIguales;
}

unsigned sumaColumna(const TMatriz& matriz, unsigned n, unsigned columna){
 unsigned suma = 0;
  for(unsigned i = 0; i < n; i++){
   suma+= matriz[i][columna];

  }

  return suma;
}

bool sumaColumnas(const TMatriz& matriz, unsigned n, unsigned& ant2){
 bool a = true;
 unsigned i = 1;
 ant2 = sumaColumna(matriz, n, 0);
 while(a== true && i < n){
  if(ant2 == sumaColumna(matriz,n, i)){
   a = true;
  }else{
   a = false;
  }
  i++;
 }
 return a;
}

unsigned sumaDiagonalP(const TMatriz& matriz, unsigned n){
 unsigned suma = 0;
 for(unsigned i = 0; i< n; i++){
   for(unsigned j = 0; j< n; j++){
    if(i==j){
     suma += matriz[i][j];
    }
   }
  }
 return suma;
}

unsigned sumaDiagonalS(const TMatriz& matriz, unsigned n){
 unsigned suma = 0;
 unsigned j = n-1;
 for(unsigned i = 0; i < n; i++){
  suma += matriz[i][j];
  j--;
 }
 return suma;
}

bool Es_Magica(const TMatriz& A, unsigned n, unsigned ant1, unsigned ant2){
 bool es=false;
 bool sumaFilasIgual, sumaColumnasIgual;
 sumaFilasIgual = sumaFilas(A, n, ant1);
 sumaColumnasIgual = sumaColumnas(A, n,ant2);

 if(ant1 == ant2){
 if(sumaFilasIgual== true && sumaColumnasIgual== true){

  if(sumaDiagonalP(A, n) == sumaDiagonalS(A,n) ){
    es = true;
   }
 }
 }
 return es;
}

int main() {
 TMatriz a;
 Leerdatos(a);
 int ant1=0, ant2=0;
 bool es;
 es = Es_Magica(a,N,ant1,ant2);
 cout << endl;

 if(es){
  cout << "Es un cuadro magico";
   } else {
    cout << "No es un cuadrado magico";
  }

 return 0;
}

