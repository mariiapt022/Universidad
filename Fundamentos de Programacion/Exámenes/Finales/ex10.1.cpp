//Examen 10. Ejercicio 1
#include <iostream>
#include <array>
using namespace std;
const int FIL=3;
const int COL=4;
typedef array <int,COL>TFilas;
typedef array <TFilas,FIL>TMatriz;

void leerDatos(TMatriz& mat){
    cout<<"Introduzca una matriz "<<FIL<<"x"<<COL<<" : "<<endl;
    for(int i=0;i<FIL;i++){
        for(int j=0;j<COL;j++){
            cin>>mat[i][j];
        }
    }
}

int sumaMayoresImpares(const TMatriz& mat){
    int mayor=0,suma=0;
    for(int i=0;i<FIL;i++){
        for(int j=0;j<COL;j++){
            if(mat[i][j]>mayor&&mat[i][j]%2!=0){
                mayor=mat[i][j];
            }
        }
        suma=suma+mayor;
        mayor=0;
    }
    return suma;
}

int main(){
    TMatriz mat;
    int suma;
    leerDatos(mat);
    suma=sumaMayoresImpares(mat);
    cout<<"La suma de los mayores impares de las filas es: "<<suma;
    return 0;
}

/*
6 4 12 2
5 2 7 3
4 9 5 11
*/
