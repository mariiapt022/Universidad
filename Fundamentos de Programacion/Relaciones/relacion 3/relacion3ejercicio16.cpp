//María Peinado Toledo
//Relación 3. Ejercicio 16. 19/12/2020

#include <iostream>
#include <array>
using namespace std;
const int MAX=5;
typedef array<int, MAX> TFilas;
typedef array<TFilas, MAX> TArrayBid;

struct TMatriz{
    TArrayBid datos;
    int nfi,nco;
};

void leerDatos(TMatriz& mat){
    do{
        cout<<"Introduzca numero de filas y columnas (max "<<MAX<<"x"<<MAX<<"): ";
        cin>>mat.nfi>>mat.nco;
    }while((mat.nfi<1)||(mat.nfi>MAX)||(mat.nco<1)||(mat.nco>MAX));

    cout<<"Introduzca la matriz fila a fila: "<<endl;

    for(int fi=0;fi<mat.nfi;fi++){
        for(int co=0;co<mat.nco;co++){
            cin>>mat.datos[fi][co];
        }
    }
}

int menor(const TMatriz& mat,int fi){
    int res=mat.datos[fi][0];
    for(int co=1;co<mat.nco;co++){
        if(mat.datos[fi][co]<res){
            res=mat.datos[fi][co];
        }
    }

    return res;
}

int mayor(const TMatriz& mat,int co){
    int res=mat.datos[0][co];
    for(int fi=1;fi<mat.nfi;fi++){
        if(mat.datos[fi][co]>res){
            res=mat.datos[fi][co];
        }
    }

    return res;
}

void mostrarPuntosSilla(const TMatriz& mat){
    int menorr;

    cout<<"Sus puntos sillas son: "<<endl;
    for(int fi=0;fi<mat.nfi;fi++){
        menorr=menor(mat,fi);
        for(int co=0;co<mat.nco;co++){
            if(mat.datos[fi][co]==menorr){
                if(mat.datos[fi][co]==mayor(mat,co)){
                    cout<<"Fila: "<<fi<<", Columna: "<<co<<endl;
                }
            }
        }
    }
}

int main(){
    TMatriz mat;
    leerDatos(mat);
    mostrarPuntosSilla(mat);

    return 0;

}



















