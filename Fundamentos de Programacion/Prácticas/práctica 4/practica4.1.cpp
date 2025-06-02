//María Peinado Toledo
//Práctica 4. Ejercicio 1. 25/11/2020

#include <iostream>
using namespace std;

int leerAltura (int& h){
    do{
        cout<<"Introduzca a altura de su piramide (0<n<10): ";
        cin>>h;
    }while(h<=0||h>=10);

    return h;
}

void escribirBlancos(int num){
    for(int x=0;x<num;x++){
        cout<<"  ";
    }
}

void escribirAscendiente(int num){
    for(int x=1; x<=num;x++){
        cout<<x<<" ";
    }
}

void escribirDescendiente(int num){
    for(int x=num-1; x>=1;x--){
        cout<<x<<" ";
    }
}


void escribirPiramide(int fila){
    escribirAscendiente(fila);
    escribirDescendiente(fila);
}



int main(){
    int h;
    h= leerAltura(h);

    for(int fila=1; fila<=h;fila++){
        escribirBlancos(h-fila);
        escribirPiramide(fila);
        cout<<endl;
    }

    return 0;
}

