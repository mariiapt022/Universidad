//María Peinado Toledo
//Práctica 6. Ejercicio 1. 09/12/2020

#include <iostream>
#include <array>
using namespace std;
const int TAM=10;
typedef array <int,TAM> TArray;

void leerDatos(TArray& v){
    cout<<"Introduzca "<<TAM<<" numeros enteros: ";

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

    cout<<"El mayor del array es: "<<mayor<<endl;
}

int main(){

    TArray v;
    leerDatos(v);
    mayor(v);

    return 0;

}
