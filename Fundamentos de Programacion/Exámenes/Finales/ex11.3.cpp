//Examen 11. Ejercicio 3
#include <iostream>
#include <array>
using namespace std;
const int TAM=5;
typedef array <char,TAM>TFilas;
typedef array <TFilas,TAM>TMatriz;

void leerDatos(TMatriz& m0,int& gen){
    cout<<"Introduzca numero de generaciones: ";
    cin>>gen;

    cout<<"Introduzca la primera generacion: "<<endl;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            cin>>m0[i][j];
        }
    }
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

bool nace(const TMatriz& m0,const int fi,const int co){
    int cont=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(esVecino(fi,co,i,j)&&m0[i][j]=='x'){
                cont++;
            }
        }
    }
    return cont==3;
}

bool siguevivo(const TMatriz& m0,const int fi,const int co){
    int cont=0;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(esVecino(fi,co,i,j)&&m0[i][j]=='x'){
                cont++;
            }
        }
    }
    return cont==3||cont==2;
}

void crearGeneracion(TMatriz& m0,TMatriz& m1){
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            if(m0[i][j]=='x'){
                    if(siguevivo(m0,i,j)){
                        m1[i][j]='x';
                    }else{
                        m1[i][j]='o';
                }
            }

            if(m0[i][j]=='o'){
                    if(nace(m0,i,j)){
                        m1[i][j]='x';
                    }else{
                        m1[i][j]='o';
                }
            }
        }
    }
}

void crearMatriz0(TMatriz& m0,TMatriz& m1){
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            m0[i][j]=m1[i][j];
        }
    }
}

void mostrar(TMatriz& m){
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            cout<<m[i][j];
        }
        cout<<endl;
    }
}

int main(){
    TMatriz m0,m1;
    int gen,cont=2;

    leerDatos(m0,gen);
    cout<<"Generacion 1 (inicial): "<<endl;
    mostrar(m0);
    cout<<endl;

    do{
        cout<<"Generacion "<<cont<<": "<<endl;

        crearGeneracion(m0,m1);

        mostrar(m1);
        crearMatriz0(m0,m1);

        cont++;

        cout<<endl;

    }while(cont<=gen);

    return 0;
}

/*
ooxoo
oxoox
xooxx
ooxoo
xoooo
*/
