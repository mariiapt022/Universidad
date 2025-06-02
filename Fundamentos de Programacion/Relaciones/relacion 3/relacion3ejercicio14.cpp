//María Peinado Toledo
//Relación 3. Ejercicio 14. 16/12/2020

#include <iostream>
#include <array>
using namespace std;
const int NUM_FILAS=4;
const int NUM_COLUMNAS=4;
typedef array<int ,NUM_COLUMNAS> TFila;
typedef array<TFila,NUM_FILAS> TMatriz;

void leerMatriz(TMatriz& mat){
    cout<<"Introduzca los elementos de la matriz "<<NUM_FILAS<<"x"<<NUM_COLUMNAS<<" fila a fila: ";
    for(int fi=0;fi<NUM_FILAS;fi++){
        for(int co=0;co<NUM_COLUMNAS;co++){
            cin>>mat[fi][co];
        }
    }
}

bool estaContenido(const TMatriz& mat, int num){
    int fi=0,co=0;
    bool encontrado=false;

    while((fi<NUM_FILAS)&&(!encontrado)){
        co=0;
        while((co<NUM_FILAS)&&(!encontrado)){
            if(mat[fi][co]==num){
                encontrado=true;
            }
            co++;
        }
        fi++;
    }

    return encontrado;
}

int main(){
    int num;
    TMatriz mat;
    leerMatriz(mat);
    cout<<"Introduzca el dato a buscar dentro de la matriz: ";
    cin>>num;

    if(estaContenido(mat,num)){
        cout<<"El elemento SI esta contenido en la matriz.";
    }else{
        cout<<"El elemento NO esta contenido en la matriz.";
    }

    return 0;
}






















