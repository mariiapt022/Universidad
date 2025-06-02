//María Peinado Toledo
//Práctica 3. Ejercicio 5. 01/11/2020

#include <iostream>
using namespace std;
int main ()
{
    int N;
    float fra, pi=4, numerador=2, denominador=3;

    do{
    cout<<"Introduzca un numero entero positivo: ";
    cin>>N;
    }while (N<=0);

    for (int contador=1; contador<=N; contador++){
        fra=numerador/denominador;
        pi=pi*fra;
        if ((contador%2)!=0){
          numerador+=2;
        } else {
          denominador+=2;
        }
    }

    cout<<"El valor de Pi es aproximadamente: "<<pi;

    return 0;
}
