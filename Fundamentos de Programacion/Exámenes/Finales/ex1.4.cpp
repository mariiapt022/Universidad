//Examen 1. Ejercicio 4

#include <iostream>
#include <array>
using namespace std;
const int N=3;
const int M=4;
typedef array <int,M>TFilas;
typedef array <TFilas,N>TMatriz;
typedef array <int,N*M>TDatos;

void aCero(TMatriz& mat,TDatos& v){
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            mat[i][j]=0;
        }
    }
    for(int k=0;k<N*M;k++){
        v[k]=0;
    }
}

void leerDatos(TMatriz& mat, int& k){
    cout<<"Introduzca un natural k: ";
    cin>>k;

    cout<<"Introduzca una matriz "<<N<<"x"<<M<<": "<<endl;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<M;co++){
            cin>>mat[fi][co];
        }
    }
}

int calcularRep(TMatriz& mat,int num){
    int cont=0;
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            if(mat[i][j]==num){
                cont++;
            }
        }
    }
    return cont;
}
bool esta(TDatos& v,int num){
    int cont=0;
    for(int i=0;i<N*M;i++){
        if(num==v[i]){
            cont++;
        }
    }
    return cont!=0;
}
void encontrarMayorRep(TMatriz& mat,int k,TDatos& v){
    int mayorRep=0,copia,cont=0,numero,z=0;
    cout<<"Los "<<k<<" valores que mas se repiten son: ";
    while(cont<k){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!esta(v,mat[i][j])){
                    copia=calcularRep(mat,mat[i][j]);
                    if(copia>mayorRep){
                        mayorRep=copia;
                        numero=mat[i][j];
                    }
                }
            }
        }
        if(!esta(v,numero)){
            v[z]=numero;
            z++;
        }
        mayorRep=0;
        cont++;
    }
}

void escribir(TDatos& v,int k){
    for(int i=0;i<k;i++){
        if(v[i]!=0){
            cout<<v[i]<<" ";
        }
    }
}

int main(){
    TMatriz mat;
    TDatos v;
    int k;
    aCero(mat,v);
    leerDatos(mat,k);
    encontrarMayorRep(mat,k,v);
    escribir(v,k);

    return 0;
}


/*
45 -17 867 45
2 867 -17 3
1 -2 45 3

45 -17 867 45
2 867 -17 3
1 -2 45 3

45 -17 867 45
2 867 -17 3
1 -2 45 3

*/















