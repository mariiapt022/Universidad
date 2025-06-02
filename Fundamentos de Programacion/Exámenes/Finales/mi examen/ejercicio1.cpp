//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A3/A4 PC1108
//Examen Febrero. Ejercicio 1. 05/02/2021

#include <iostream>
#include <array>
using namespace std;
const int N=6;
typedef array <int, N> TFila;
typedef array <TFila, N> TMatriz;

void generaSimetrica(TMatriz& m){
    int cont=0;
    int num=1;
    int i=0,j=0;

    while(i<N){
        j=i+1;
        while(j<N){
            if(i!=j){
                if(cont<(N*(N+1))/2){
                    m[i][j]=num;
                    m[j][i]=num;
                    num+=2;
                    cont++;
                }else{
                    m[i][j]=num;
                    m[j][i]=num;
                    num++;
                    cont++;
                }
            }
            j++;
        }
        i++;
    }

    if(num%2==0){
        num++;
    }

    for(int k=0;k<N;k++){
        for(int z=0;z<N;z++){
            if(k==z){
                m[k][z]=num;
                num+=2;
            }
        }
    }

}

void muestraMatriz(TMatriz& m){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cout<<m[i][j]<<" ";
        }
        cout<<endl;
    }
}

int main(){
   TMatriz m;
   cout<<" Generacion de Matriz Simetrica "<<N<<"x"<<N<<" con los "<< (N*(N+1))/2<<" primeros impares";
   cout<<endl;
   generaSimetrica(m);
   muestraMatriz(m);
   return 0;

}
