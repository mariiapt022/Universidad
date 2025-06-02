//María Peinado Toledo
//Práctica 4. Ejercicio 2. 25/11/2020

#include <iostream>
using namespace std;

void leerN(int& num){
    do{
        cout<<"Introduzca un numero n (>0): ";
        cin>>num;
    }while(num<=0);
}

bool esPrimo(int num){
    int posDivisor=2;

    while(posDivisor<num && num%posDivisor!=0){
        posDivisor++;
    }
    return posDivisor>=num;
}

int main(){
    int n,contPrimos=0,supuestoPrimo=2;
    leerN(n);
    cout<<"Los "<<n<<" primero primos son: ";

    while(contPrimos<n){
        if(esPrimo(supuestoPrimo)){
            cout<<supuestoPrimo<<" ";
            contPrimos++;
        }
        supuestoPrimo++;
    }
    return 0;
}
