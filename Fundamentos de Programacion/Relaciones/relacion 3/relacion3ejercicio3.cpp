//María Peinado Toledo
//Relación 3. Ejercicio 3. 03/12/2020

#include <array>
#include <iostream>
using namespace std;
const int MAX=10;
typedef array<int, MAX>TVector;

void leerDatos(TVector& v){
    cout<<"Introduzca "<<MAX<<" numeros enteros: ";

    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
}

int encontrarMinimo(const TVector& v){
    int minimo=v[0];

    for(int i=1;i<MAX;i++) {
        if (minimo>v[i]) {
        minimo = v[i];
        }
    }

    return minimo;
}


int main(){
    TVector v;
    leerDatos(v);

    int minimo,mayor;
    minimo=encontrarMinimo(v);
    mayor=v[0];
    int i=0;
    while((i<MAX)&&(v[i]<=minimo)){
        i++;
        if(v[i]>minimo){
        mayor=v[i];
        }
    }

    cout<<"Un elemento Mayor que el Minimo es: "<<mayor<<endl;
    return 0;
}















