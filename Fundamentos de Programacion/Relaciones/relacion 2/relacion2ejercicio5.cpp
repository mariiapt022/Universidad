//María Peinado Toledo
//Relación 2. Ejercicio 5. 21/11/2020

#include <iostream>
using namespace std;

int leerDatos(){
    int num;

    do{
        cout<<"Introduce un numero mayor que 1: ";
        cin>>num;
    }while(num<=1);

    return num;
}

bool esPrimo(int num){
    int divisor=2;
    while((divisor<num)&&(num%divisor!=0)){
        divisor++;
    }
    return (divisor>=num);
}

int main(){
    int numero, primo, divisor=2;

    numero=leerDatos();

    cout<<"Los primos divisores de "<<numero<<" son: ";

    while(numero>1){
        primo=esPrimo(divisor);
        if(primo){
            if(numero%divisor==0){
                cout<<divisor<<" ";
                numero=numero/divisor;
            }else{
                divisor++;
            }
        }else{
            divisor++;
        }
    }

    return 0;
}
