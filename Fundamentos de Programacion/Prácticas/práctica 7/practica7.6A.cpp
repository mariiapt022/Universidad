//María Peinado Toledo
//Práctica 7. Ejercicio 6A.(19 tercera rel) 13/01/2021

#include <iostream>
#include <array>
using namespace std;
const int CARGOS=15;
const int PARTIDOS=10;
typedef array <int,PARTIDOS>TFilas;
typedef array <TFilas,CARGOS>TMatriz;
typedef array <int,PARTIDOS>TDatos;

void aCero(TMatriz& mat,TDatos& v){
    for(int i=0;i<PARTIDOS;i++){
        v[i]=0;
        for(int j=0;j<CARGOS;j++){
            mat[i][j]=0;
        }
    }

}

void leerDatos(TMatriz& mat,int& cargos,int& partidos){
    cout<<"Introduzca el numero de cargos: ";
    cin>>cargos;
    cout<<"Introduzca el numero de partidos: ";
    cin>>partidos;

    for(int i=0;i<partidos;i++){
        cout<<"Partido "<<char(i+65)<<": ";
        cin>>mat[i][0];
    }
}

void construirFila(TMatriz& mat,int numFila,int cargos){
    int primero=mat[numFila][0];
    for(int i=0;i<cargos;i++){
        mat[numFila][i]=primero/(i+1);
    }
}

void encontrarMayor(TMatriz& mat,TDatos& v,int cargos,int partidos){
    int mayor=mat[0][0];
    int cont=0,partido,cargo;
    while(cont<cargos){
       for(int i=0;i<partidos;i++){
        for(int j=0;j<cargos;j++){
            if(mat[i][j]>mayor){
                mayor=mat[i][j];
                partido=i;
                cargo=j;
            }
        }
        }
        mat[partido][cargo]=0;
        mayor=0;
        v[partido]++;
        cont++;
    }
}

void escribir(TDatos& v,int partidos){
    for(int i=0;i<partidos;i++){
        if(v[i]!=0){
            cout<<"Partido "<<char(i+65)<<" : "<<v[i];
        }
        cout<<endl;
    }
}

int main(){
    TMatriz mat;
    TDatos v;
    int cargos,partidos;
    aCero(mat,v);
    leerDatos(mat,cargos,partidos);
    for(int i=0;i<partidos;i++){
        construirFila(mat,i,cargos);
    }
    encontrarMayor(mat,v,cargos,partidos);
    cout<<"Los cargos electos son: "<<endl;
    escribir(v,partidos);

    return 0;
}











