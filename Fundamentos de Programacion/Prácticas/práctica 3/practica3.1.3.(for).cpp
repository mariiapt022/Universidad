//María Peinado Toledo
//Práctica 3. Ejercicio 1.3.(for). 28/10/2020

#include <iostream>
using namespace std;
int main()
{
    int N,suma;
    suma=0;

    do{
        cout<<"Introduzca su numero entero mayor que cero: ";
        cin>>N;
    }while(N<=0);

    for(int i=0; i<=N;i++){
            suma+=i;
    }
    cout<<"La suma de los "<<N<<" primeros numeros es: "<<suma<<endl;

    return 0;

}
