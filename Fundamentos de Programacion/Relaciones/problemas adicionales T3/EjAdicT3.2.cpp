//María Peinado Toledo
//Ejercicios Adicionales Tema 3. Ejercicio 2. 26/11/2020

#include <iostream>
using namespace std;


int calcularTerminos(int num){
    int operacion=1;

    if(num%2==0){
        for(int i=2;i<=num;i=i+2){
            operacion=operacion*i;
        }
    }else{
        for(int i=1;i<=num;i=i+2){
            operacion=operacion*i;
        }
    }

    return operacion;
}

double calcularFraccion(double contador,double fraccion){
    double numerador,denominador;

    numerador=calcularTerminos(contador);
    denominador=calcularTerminos(contador-1);
    fraccion=numerador/denominador;

    return fraccion;
}

double calcularSuma(double contador,double fraccion,double suma){

    while(fraccion<5){
        fraccion=calcularFraccion(contador,fraccion);
        suma=suma+fraccion;
        contador=contador+2;
        if(fraccion>=5){
            suma=suma-fraccion;
        }
    }

    return suma;
}

int main(){
    double suma=0,fraccion,contador=2;

    suma=calcularSuma(contador,fraccion,suma);
    cout<<suma;


    return 0;
}












