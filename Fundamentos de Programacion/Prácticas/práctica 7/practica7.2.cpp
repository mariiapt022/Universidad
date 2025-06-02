//María Peinado Toledo
//Práctica 7. Ejercicio 2. 13/01/2021

#include <iostream>
#include <array>
using namespace std;
const int N=4;
const int M=4;
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

bool esSimetrica(const TMatriz& mat){
    int cont=0,para=1,fi=0,co=0;

    while(fi<N&&para!=0){
        while(co<M&&para!=0){
            if(mat[fi][co]==mat[co][fi]){
                cont++;
            }else{
                para=0;
            }
            co++;
        }
        fi++;
        co=0;
    }

    return cont==N;
}

int main(){
    TMatriz mat;
    bool simetria;

    leerDatos(mat);
    simetria=esSimetrica(mat);
    if(simetria){
        cout<<"La matriz SI es simetrica.";
    }else{
        cout<<"La matriz NO es simetrica.";
    }

    return 0;
}

/*Prueba
1 2 3 4
2 7 6 2
3 6 8 4
4 2 4 3
*/
