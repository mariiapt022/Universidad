//María Peinado Toledo
//Práctica 4. Ejercicio 2. 25/11/2020

#include <iostream>
using namespace std;

int leerN(int& N){
    do{
        cout<<"Introduzca su numero (N>0): ";
        cin>>N;
    }while(N<=0);

    return N;
}

bool esPrimo(int num){
    int divisor=2;
    while(divisor<num&&num%divisor!=0){
        divisor++;
    }
    return divisor>=num;
}

int main(){
    int N, pPrimo=2, contPrimo=0;
    N=leerN(N);

    cout<<"Los "<<N<<" primeros primos son: ";

    while(contPrimo!=N){
        if(esPrimo(pPrimo)){
            cout<<pPrimo<<" ";
            contPrimo++;
        }
        pPrimo++;
    }

    return 0;

}
