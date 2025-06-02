//Examen 1. Ejercicio 2

#include <iostream>
#include <array>
#include <string>
using namespace std;
const int N=6;
typedef array <char,N>TFilas;
typedef array <TFilas,N>TMatriz;

void aCero(TMatriz& mat){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            mat[i][j]=0;
        }
    }
}

void leerDatos(TMatriz& mat,string& secuencia){
    cout<<"Introduzca la matriz clave: "<<endl;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<N;co++){
            cin>>mat[fi][co];
        }
    }

    cout<<"Introduzca su secuencia de caracteres: ";
    cin>>secuencia;

}

void buscar(TMatriz& mat, char letra,int& fi,int& co){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(letra==mat[i][j]){
                fi=i;
                co=j;
            }
        }
    }
}

void cifrar(TMatriz& mat,string secuencia,string& cifrado){
    int j=0,tam,f1,c1,f2,c2;
    cifrado="";
    for(int i=0;i<secuencia.size();i=i+2){
        buscar(mat,secuencia[i],f1,c1);
        buscar(mat,secuencia[i+1],f2,c2);
        cifrado[j]=mat[f1][f2];
        cifrado[j+1]=mat[c1][c2];
        j=j+2;
    }

    for(int k=0;k<secuencia.size();k++){
        cout<<cifrado[k];
    }
}


int main(){
    TMatriz mat;
    string secuencia,cifrado;
    aCero(mat);
    leerDatos(mat,secuencia);
    cifrar(mat,secuencia,cifrado);
    return 0;
}

/*Prueba
p k a f 5 v
e o 9 t y 0
s 3 z 7 d j
r b n u m 1
2 w 4 h 8 g
c x 6 q i l
*/
