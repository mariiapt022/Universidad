//Examen 8. Ejercicio 2.
#include <iostream>
#include <array>
using namespace std;
const int TAM=7;
typedef array <int,TAM>TFilas;
typedef array <TFilas,TAM>TMatriz;

void aCero(TMatriz& mat){
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            mat[i][j]=0;
        }
    }
}

void construirMatriz(TMatriz& mat){
    int suma=0,izq,arriba,tope;

    for(int i=0;i<TAM;i++){
        mat[0][i]=1;
        mat[i][0]=1;
    }

    for(int j=1;j<TAM;j++){
        for(int k=1;k<TAM;k++){
            tope=TAM-j;
            if(k<tope){
                izq=k-1;
                arriba=j-1;
                suma=mat[arriba][k]+mat[j][izq];
                mat[j][k]=suma;
            }
        }
    }

}

void mostrar(TMatriz& mat){
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(mat[i][j]!=0){
                cout<<mat[i][j]<<" ";
            }
        }
        cout<<endl;
    }
}

int main(){
    TMatriz mat;
    aCero(mat);
    construirMatriz(mat);
    mostrar(mat);
    return 0;
}
