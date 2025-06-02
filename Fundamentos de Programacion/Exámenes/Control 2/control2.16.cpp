//Control 2. Ejercicio 16

#include <iostream>
#include <array>
using namespace std;
const int MAX=7;
typedef array <int,MAX> TVector;


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
}

void invertir(TVector& v){

    for(int i=MAX-1;i>=0;i--){
        cout<<v[i]<<" ";

    }

}

int main(){
    TVector v;

    aCero(v);
    leerDatos(v);
    invertir(v);

    return 0;
}


//Prueba 24 12 45 90 7 9 15
