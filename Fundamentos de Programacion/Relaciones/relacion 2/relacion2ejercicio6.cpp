//María Peinado Toledo
//Relación 2. Ejercicio 6. 21/11/2020

#include <iostream>
using namespace std;

void leerDatos(int& num1, int& num2){
    do{
        cout<<"Introduzca limite inferior: ";
        cin>>num1;

        cout<<"Introduzca limite superior: ";
        cin>>num2;
    }while(num2<=num1);
}

int primerPar(int num1){
    if(num1%2!=0){
        num1++;
    }
    return num1;
}

bool esPrimo(int num){
    int divisor=2;
    while((divisor<num)&&(num%divisor!=0)){
        divisor++;
    }
    return (divisor >=num);
}

int sumatorio(int num1, int cont){
    int suma=num1-cont;
    return suma;
}

int main(){
    int num1,num2,pPar,cont,suma;
    bool primo,numero;

    leerDatos(num1,num2);
    pPar=primerPar(num1);

    while(pPar<=num2){
        cont=1;
        numero=false;


    while(!numero){
        suma=sumatorio(pPar,cont);
        primo=esPrimo(suma);

        if(primo&&suma!=1){
            suma=pPar-suma;
            if((primo)&&(suma!=1)){
                cout<<pPar<<" = "<<suma<<" + "<<pPar-suma<<endl;
                numero=true;
            }
        }
        cont++;
    }
    pPar=pPar+2;
    }

    cout<<"Todos los pares en el rango elegido cumplen la conjetura."<<endl;
    return 0;

}




