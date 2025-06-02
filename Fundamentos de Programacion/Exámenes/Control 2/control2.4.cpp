//Control 2. Ejercicio 4

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TVector;

void inicializar(TVector& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}

void leerDatos(TVector& v){

    cout<<"Introduzca "<<MAX<<" valores naturales: ";
    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
}




int valorDominante(const TVector& v){

    int valorDom=0,copia,cont=0;

    for(int i=0;i<MAX;i++){
        copia=cont;
        cont=0;
        for(int j=0;j<MAX;j++){
            if(v[i]==v[j]){
                cont++;
            }
        }

        if(cont>=copia){
            copia=cont;
            if(cont>MAX/2){
            valorDom=v[i];
            }
        }
    }



    return valorDom;
}

int main(){
    TVector v;
    int valorDom;

    inicializar(v);
    leerDatos(v);
    valorDom=valorDominante(v);

    if(valorDom==0){
        cout<<"-1";
    }else{
        cout<<"El elemento dominante del array: "<<valorDom<<endl;
    }

    return 0;
}








