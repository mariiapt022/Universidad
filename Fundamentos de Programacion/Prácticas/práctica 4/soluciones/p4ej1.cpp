//María Peinado Toledo
//Práctica 4. Ejercicio 1. 25/11/2020

#include <iostream>
using namespace std;

void leerAltura(int&n){
    do{
        cout<<"Introduzca un numero natural (0<n<10): ";
        cin>>n;
    }while(n<=0 || n>=10);
}

void escribirBlancos(int num){
    for(int x=0; x<num;x++){
        cout<<"  ";
    }
}

void escribirAscendente(int num){
    for(int x=1; x<=num; x++){
        cout<<x<<" ";
    }
}
void escribirDescendente(int num){
    for(int x=num-1; x>=1; x--){
        cout<<x<<" ";
    }
}

void escribirPiramide(int fila){
    escribirAscendente(fila);
    escribirDescendente(fila);
}




int main(){
    int altura;

    leerAltura(altura);

    for(int fila=1; fila<=altura; fila++){
        escribirBlancos(altura-fila);
        escribirPiramide(fila);
        cout<<endl;
    }

    return 0;
}

