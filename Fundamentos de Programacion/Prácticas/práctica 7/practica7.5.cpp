//María Peinado Toledo
//Práctica 7. Ejercicio 5. 13/01/2021

#include <iostream>
#include <array>
const int MAX=10;
using namespace std;
typedef array <int,MAX>TVector;

void aCero(TVector& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}

void leerDatos(TVector& v){
    cout<<"Introduzca una sentencia de "<<MAX<<" numeros naturales: ";
    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
}

int encontrarMayor(TVector& v){
    int mayor=v[0];
    for(int i=0;i<MAX;i++){
        if(v[i]>mayor){
            mayor=v[i];
        }
    }
    return mayor;
}

void apariciones(TVector& v, int num){
    int cont=0;
    for(int i=0;i<MAX;i++){
        if(v[i]==num){
            cont++;
        }
    }
    cout<<num<<" aparece "<<cont<<" veces, en las posiciones: ";
    for(int i=0;i<MAX;i++){
        if(v[i]==num){
            cout<<i+1<<" ";
            v[i]=0;
        }
    }
}

void mostrar(TVector& v){
    int cont=0,mayor;
    while(cont<MAX){
      mayor=encontrarMayor(v);
      if(mayor!=0){
        apariciones(v,mayor);
        cout<<endl;
      }

      cont++;
    }
}

int main(){
    TVector v;
    aCero(v);
    leerDatos(v);
    mostrar(v);
    return 0;
}

//Prueba 7 10 143 10 52 143 72 10 143 7

