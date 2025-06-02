//Examen 2. Ejercicio 2

#include <iostream>
#include <array>
using namespace std;
const int N=3;
typedef array <int,N>TFilas;
typedef array <TFilas,N>TMatriz;

void aCero(TMatriz& mat){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            mat[i][j]=0;
        }
    }
}

void leerDatos(TMatriz& mat){
    cout<<"Introduzca una matriz "<<N<<"x"<<N<<": "<<endl;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<N;co++){
            cin>>mat[fi][co];
        }
    }
}

bool elementos(const TMatriz& mat){
    int cont=0;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<N;co++){
            if(mat[fi][co]>=0&&mat[fi][co]<100){
                cont++;
            }
        }
    }

    return cont==N*N;
}

int sumaFila(const TMatriz& mat,int numFila){
    int suma=0;
    for(int co=0;co<N;co++){
        suma=suma+mat[numFila][co];
    }

    return suma;
}

int sumaColumna(const TMatriz& mat,int numColum){
    int suma=0;
    for(int fi=0;fi<N;fi++){
        suma=suma+mat[fi][numColum];
    }

    return suma;
}

bool sumas(const TMatriz& mat){
    int sumaFi,sumaCo,cont=0;
    for(int i=0;i<N;i++){
        sumaFi=sumaFila(mat,i);
        sumaCo=sumaColumna(mat,i);
        if(sumaCo==100){
            cont++;
        }
        if(sumaFi==100){
            cont++;
        }
    }

    return cont==N*2;

}

int main(){
    TMatriz mat;
    bool elem,sum;
    aCero(mat);
    leerDatos(mat);
    elem=elementos(mat);
    sum=sumas(mat);
    if(elem&&sum){
        cout<<"La matriz SI es doblemente estocastica normalizada.";
    }else{
        cout<<"La matriz NO es doblemente estocastica normalizada.";
    }
    return 0;
}

/*
Prueba

20 30 50
50 0 50
30 70 0

20 30 50
55 -5 50
25 75 0
*/








