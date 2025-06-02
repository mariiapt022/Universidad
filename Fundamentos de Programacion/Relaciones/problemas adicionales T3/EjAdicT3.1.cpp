//María Peinado Toledo
//Problemas adicionales Tema 3. Ejercicio 1. 26/11/2020

#include <iostream>
using namespace std;

int leer(){
    int N;
    do{
        cout<<"Introduzca su numero natural (N>0): ";
        cin>>N;
    }while(N<=0);
}

int calcularPotencia (int base, int exponente){
    int potencia=1;

    for(int i=1;i<=exponente;i++){
        potencia=potencia*base;
    }

    return potencia;
}

double calcularFraccion(double potencia,double contador){
    double fraccion;
    fraccion=contador/potencia;

    return fraccion;

}

int main(){
    int n,contador=1,exponente,base=2,potencia;
    double fraccion,suma=0;
    n=leer();

    while(contador<=n){
        exponente=contador;
        potencia=calcularPotencia(base,exponente);
        fraccion=calcularFraccion(potencia,contador);
        suma=suma+fraccion;
        contador++;
    }

    cout<<"Suma: "<<suma;
    return 0;

}
