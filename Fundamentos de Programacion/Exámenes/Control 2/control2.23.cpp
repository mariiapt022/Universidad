//Control 2. Ejercicio 23

#include <iostream>
#include <array>
using namespace std;
const int MAX=5;
typedef array <int,MAX>TVector;

void aCero(TVector& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}


void leerDatos(TVector& v){
    cout<<"Introduzca "<<MAX<<" numeros enteros: ";
    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
    cout<<endl;
    for(int j=0;j<MAX;j++){
        cout<<v[j]<<" ";
    }
    cout<<endl;
}

void centroVector(TVector& v){
    int sumaIzq,sumaDcha;
    int c=1,centro;

    while(sumaIzq!=sumaDcha){
        sumaIzq=0;
        sumaDcha=0;
        for(int i=0;i<=c-1;i++){
            sumaIzq=sumaIzq+(c-i)*v[i];
        }
        for(int j=c+1;j<=MAX-1;j++){
            sumaDcha=sumaDcha+(j-c)*v[j];
        }
        if(sumaIzq==sumaDcha){
            centro=c;
        }else{
            centro=-1;
        }
        c++;

    }

    if(centro==-1){
        cout<<"Este vector no tiene centro.";
    }else{
        cout<<"El centro de este vector es el indice "<<centro<<"( casilla donde esta el "<<v[centro]<<" )"<<endl;
        cout<<"Sumatorio izquierda: "<<sumaIzq<<"."<<endl;
        cout<<"Sumatorio derecha: "<<sumaDcha<<"."<<endl;
    }

}

int main(){
    TVector v;
    aCero(v);
    leerDatos(v);
    centroVector(v);
    return 0;
}

//Prueba 6 2 3 0 1
