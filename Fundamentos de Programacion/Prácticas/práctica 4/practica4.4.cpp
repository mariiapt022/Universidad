//María Peinado Toledo
//Práctica 4. Ejercicio 4. 25/11/2020

#include <iostream>
using namespace std;

int leerAncho(int& ancho){
    do{
      cout<<"Introduzca su numero natural (N>0): ";
      cin>>ancho;
    }while(ancho<=0);

    return ancho;
}

void dibujarBlancos(int num){
    for(int x=0;x<num;x++){
        cout<<" ";
    }
}

void dibujarAsteriscos(int num){
    for(int x=0;x<num;x++){
        cout<<"* ";
    }
}

int main(){
    int ancho;
    ancho=leerAncho(ancho);

    for(int fila=1;fila<=ancho;fila++){
        dibujarBlancos(ancho-fila);
        dibujarAsteriscos(fila);
        cout<<endl;
    }
    for(int fila=ancho-1;fila>=1;fila--){
        dibujarBlancos(ancho-fila);
        dibujarAsteriscos(fila);
        cout<<endl;
    }

    return 0;
}
