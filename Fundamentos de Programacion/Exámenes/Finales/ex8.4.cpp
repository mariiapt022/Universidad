//Examen 8. Ejercicio 4.
#include <iostream>
#include <array>
using namespace std;
const int F=2;
const int C=3;
typedef array <int,C>TFilas;
typedef array <TFilas,F>TMatrizM;
typedef array <TFilas,2*F>TMatrizT;

void leerDatos(TMatrizM& m){
    cout<<"Introduzca una matriz "<<F<<"x"<<C<<": "<<endl;
    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            cin>>m[i][j];
        }
    }
}

int calcularMedia(const TMatrizM& m){
    int media,total=0;
    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            total=total+m[i][j];
        }
    }
    media=total/(C*F);
    return media;
}

bool esVecino(const int fi,const int co,const int i,const int j){
    bool vecino=false;

    if(fi==i&&co==j){
        vecino=false;
    }

    if((fi-i==0)&&((co-j==1)||(j-co==1))){
        vecino=true;
    }

    if(((co-j==1)||(j-co==1))&&((fi-i==1)||(i-fi==1))){
        vecino=true;
    }

    if((co-j==0)&&((fi-i==1)||(i-fi==1))){
        vecino=true;
    }

    return vecino;

}

int mediaVecinos(const TMatrizT& t,const int fi,const int co){
    int media,cont=0,total=0;

    for(int i=0;i<F*2;i++){
        for(int j=0;j<C;j++){
            if(esVecino(fi,co,i,j)){
                total=total+t[i][j];
                cont++;
            }
        }
    }

    media=total/cont;

    return media;

}

void mostrar(TMatrizT& t){
    cout<<"Matriz T: "<<endl;
    for(int i=0;i<F*2;i++){
        for(int j=0;j<C;j++){
            cout<<t[i][j]<<" ";
        }
        cout<<endl;
    }
}

void construirMatrizT(TMatrizM& m,TMatrizT& t){
    int filaT,sig,mediaM,mediaV;
    mediaM=calcularMedia(m);

    //cout<<"PASO 1: "<<endl;
    for(int i=0;i<F;i++){
        filaT=2*i;
        sig=filaT+1;
        for(int j=0;j<C;j++){
            t[filaT][j]=m[i][j];
            t[sig][j]=0;
        }
    }


    //cout<<"PASO 2: "<<endl;//k,z
    for(int k=0;k<(F*2);k++){
        for(int z=0;z<C;z++){
            if(t[k][z]==0){
                t[k][z]=mediaM;
            }
        }
    }

    //cout<<"PASO 3: "<<endl;
    for(int fi=1;fi<F*2;fi=fi+2){
        for(int co=0;co<C;co++){
            mediaV=mediaVecinos(t,fi,co);
            t[fi][co]=mediaV;
        }
    }

}




int main(){
    TMatrizM m;
    TMatrizT t;

    leerDatos(m);
    construirMatrizT(m,t);
    mostrar(t);

    return 0;
}

/*
3 2 5
6 5 3
*/
