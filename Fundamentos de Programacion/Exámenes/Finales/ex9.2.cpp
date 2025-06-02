//Examen 9. Ejercicio 2.
#include <iostream>
#include <array>
using namespace std;
const int F=3;
const int C=3;
typedef array <int,C>TFilas;
typedef array <TFilas,F>TMatriz;


void leerDatos(TMatriz& mat){
    cout<<"Introduzca una matriz "<<F<<"x"<<C<<": "<<endl;
    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            cin>>mat[i][j];
        }
    }
}

bool esVecino(const int fi, const int co, const int i, const int j){
    bool vecino=false;
    if(fi==i&&co==j){
        vecino=false;
    }

    if(fi-i==0&&(co-j==1||j-co==1)){
        vecino=true;
    }
    if(co-j==0&&(fi-i==1||i-fi==1)){
        vecino=true;
    }
    return vecino;
}

int mayorVecino(const TMatriz& mat,const int fi, const int co){

    int mayorV=0;

    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            if(esVecino(fi,co,i,j)&&mat[i][j]>mayorV){
                mayorV=mat[i][j];
            }
        }
    }

    return mayorV;
}

void calcularCimas(TMatriz& mat){
    int mayorV;
    cout<<"Las cimas de la matriz son: "<<endl;

    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
           mayorV=mayorVecino(mat,i,j);
           if(mat[i][j]>=mayorV){
                cout<<"Fila "<<i<<" columna "<<j<<" valor "<<mat[i][j]<<endl;
           }
        }
    }
}

int main(){
    TMatriz mat;
    leerDatos(mat);
    calcularCimas(mat);
    return 0;
}

/*
4 5 3
6 2 2
1 8 7
*/
