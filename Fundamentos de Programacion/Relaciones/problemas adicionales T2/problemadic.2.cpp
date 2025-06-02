//María Peinado Toledo
//Problemas adicionales Tema 2. Ejercicio 2. 01/11/2020

#include <iostream>
using namespace std;

int main()
{
    int n, n0, suma=0, contador=0, potencia,nFinal, digito;
    do{
        cout<<"Introduzca un numero entero mayor que 0: ";
        cin>>n;
    }while(n<=0);

    n0=n;
    nFinal=n0;

    while(n>0){
        contador++;
        n=n/10;
    }
    for(int i=n0; i>0; i=i/10){
        potencia=1;
        digito= i%10;
        for(int j=0; j<contador; j++){
            potencia=potencia*digito;
        }
        suma=suma+potencia;
    }

    if(suma==nFinal){
        cout<<"El numero "<<nFinal<<" si es un numero narcisista.";
    }else{
        cout<<"El numero "<<nFinal<<" no es un numero narcisista.";
    }

    return 0;
}
