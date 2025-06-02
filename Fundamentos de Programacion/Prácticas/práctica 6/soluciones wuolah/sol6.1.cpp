//prueba ej1 practica 6 maria peinado

#include <iostream>
#include <array>
using namespace std;
const int TAM=10;
typedef array <int,TAM> TArray;

void leerDatos(TArray& v){
    cout<<"Introduca "<<TAM<<" numeros enteros: ";

    for(int i=0;i<TAM;i++){
        cin>>v[i];
    }

}

void mayor(const TArray& v){
    int mayor=v[0];

    for(int i=1;i<TAM;i++){
        if(v[i]>mayor){
            mayor=v[i];
        }
    }

    cout<<mayor;

}

int main(){

    TArray v;
    leerDatos(v);
    mayor(v);

    return 0;

}
