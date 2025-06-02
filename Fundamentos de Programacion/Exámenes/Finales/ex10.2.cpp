//Examen 10. Ejercicio 2.
#include <iostream>
#include <array>
using namespace std;
const int TAM=10;
typedef array <int,TAM>TVector;

void leerDatos(TVector& v){
    cout<<"Introduzca "<<TAM<<" numeros naturales: ";
    for(int i=0;i<TAM;i++){
        cin>>v[i];
    }
}

int mayorLongitud(const TVector& v){
    int mayortam=0,tam=1,anterior=v[0];

    for(int i=0;i<TAM;i++){
        if(v[i]>=anterior){
            tam++;
        }else{
            tam=1;
        }
        anterior=v[i];
        if(tam>mayortam){
            mayortam=tam;
        }
    }
    return mayortam;
}

int main(){
    TVector v;
    int mayorL;
    leerDatos(v);
    mayorL=mayorLongitud(v);
    cout<<"La longitud de la mayor subsucesion es: "<<mayorL;
    return 0;
}
