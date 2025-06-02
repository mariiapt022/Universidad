//María Peinado Toledo
//Práctica 7. Ejercicio 1. 13/01/2021

#include <iostream>
#include <array>
using namespace std;
const int N=4;
const int M=5;
typedef array <int,M>TFila;
typedef array <TFila,N>TMatriz;

void leerDatos(TMatriz& mat){
    cout<<"Introduzca por filas una matriz "<<N<<"x"<<M<<": "<<endl;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<M;co++){
            cin>>mat[fi][co];
        }
    }
}

void encontrarMayor(TMatriz& mat){
    int mayor=mat[0][0],fila=0,columna=0;

    for(int fi=0;fi<N;fi++){
        for(int co=0;co<M;co++){
            if(mat[fi][co]>mayor){
                mayor=mat[fi][co];
                fila=fi;
                columna=co;
            }
        }
    }

    cout<<"El mayor de la matriz es: "<<mayor<<" que aprece en la posicion: ["<<fila<<"] ["<<columna<<"].";
}

int main(){
    TMatriz mat;
    leerDatos(mat);
    encontrarMayor(mat);
    return 0;
}


/*Prueba
3 5 -2 7 5
4 7 -4 9 8
3 2 5 9 12
8 4 12 11 8
*/
