//Examen 12. Ejercicio 2.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int N=8;
typedef array <char,N>TFilas;
typedef array <TFilas,N>TMatriz;

void leerDatos(TMatriz& m,string& palabra){

    cout<<"Introduzca "<<N<<" cadenas de "<<N<<" letras cada una de ellas: "<<endl;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>m[i][j];
        }
    }

    cout<<"Introduzca la palabra a buscar: ";
    cin>>palabra;
}

bool norte(const TMatriz& m,const string palabra,const int fi,const int co){
    bool cumple=true;
    int j=0,i=fi;
    if(fi==0){
        cumple=false;
    }
    while(i>=0&&cumple){
        if(m[i][co]!=palabra[j]){
            cumple=false;
        }
        j++;
        i--;
    }
    return cumple;
}

bool sur(const TMatriz& m,const string palabra,const int fi,const int co){
    bool cumple=true;
    int j=0,i=fi;
    if(fi==N-1){
        cumple=false;
    }
    while(i<N&&cumple){
        if(m[i][co]!=palabra[j]){
            cumple=false;
        }
        j++;
        i++;
    }
    return cumple;
}

bool este(const TMatriz& m,const string palabra,const int fi,const int co){
    bool cumple=true;
    int j=0,i=co;
    if(co==N-1){
        cumple=false;
    }
    while(i<N&&cumple){
        if(m[fi][i]!=palabra[j]){
            cumple=false;
        }
        j++;
        i++;
    }
    return cumple;
}

bool oeste(const TMatriz& m,const string palabra,const int fi,const int co){
    bool cumple=true;
    int j=0,i=co;
    if(co==0){
        cumple=false;
    }
    while(i>=0&&cumple){
        if(m[fi][i]!=palabra[j]){
            cumple=false;
        }
        j++;
        i--;
    }
    return cumple;
}

void buscarPalabra(TMatriz& m,string palabra){
    int cont=0;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(m[i][j]==palabra[0]){
                if(norte(m,palabra,i,j)){
                    cout<<"La palabra "<<palabra<<" esta en la posicion ("<<i<<","<<j<<") Norte.";
                    cont++;
                }else if(sur(m,palabra,i,j)){
                    cout<<"La palabra "<<palabra<<" esta en la posicion ("<<i<<","<<j<<") Sur.";
                    cont++;
                }else if(este(m,palabra,i,j)){
                    cout<<"La palabra "<<palabra<<" esta en la posicion ("<<i<<","<<j<<") Este.";
                    cont++;
                }else if(oeste(m,palabra,i,j)){
                    cout<<"La palabra "<<palabra<<" esta en la posicion ("<<i<<","<<j<<") Oeste.";
                    cont++;
                }
            }
        }
    }

    if(cont==0){
        cout<<"La palabra no esta.";
    }
}

int main(){
    TMatriz m;
    string palabra;
    leerDatos(m,palabra);
    buscarPalabra(m,palabra);
    return 0;
}

/*
wynapjgu
fplmodrd
ipiankee
riurkxrd
cjogomid
ikgoxpiq
lcdrghef
sgnpycft
*/
