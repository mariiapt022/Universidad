//María Peinado Toledo
//Práctica 4. Ejercicio 3A. 25/11/2020

#include <iostream>
using namespace std;

void leerNumeros(int& a, int& b){
    do{
        cout<<"Introduzca su primer numero: ";
        cin>>a;
        cout<<"Introduzca su segundo numero: ";
        cin>>b;
    }while(a<=0||b<=0);
}

int sumaDivisores(int num){
    int sumaDiv=0;

    for(int x=1;x<num;x++){
        if(num%x==0){
            sumaDiv=sumaDiv+x;
        }
    }
    return sumaDiv;
}

bool sonAmigos (int a, int b){
   return (sumaDivisores(a)==b && sumaDivisores(b)==a);
}


int main(){
    int a,b;
    leerNumeros(a,b);

    if(sonAmigos(a,b)){
        cout<<"Los numeros "<<a<<" y "<<b<<" SI son amigos. ";
    }else{
        cout<<"Los numeros "<<a<<" y "<<b<<" NO son amigos. ";
    }

    return 0;
}
