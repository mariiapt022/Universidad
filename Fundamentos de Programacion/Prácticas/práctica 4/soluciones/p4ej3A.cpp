//María Peinado Toledo
//Práctica 4. Ejercicio 3A. 25/11/2020

#include <iostream>
using namespace std;

void leerNumeros(int& a, int& b){
    do{
        cout<<"Introduce el primero numero a(>0): ";
        cin>>a;
    }while(a<=0);
    do{
        cout<<"Introduce el segundo numero b(>0): ";
        cin>>b;
    }while(b<=0);
}

int sumaDivisores(int num){
    int suma=0;
    for(int x=1;x<num;x++){
        if(num%x==0){
            suma=suma+x;
        }
    }
    return suma;
}

bool sonAmigos(int a, int b){
    return sumaDivisores(a)==b&&sumaDivisores(b)==a;
}

int main(){
    int a,b;
    leerNumeros(a,b);
    if(sonAmigos(a,b)){
        cout<<"El numero "<<a<<" y "<<b<<" SI son amigos."<<endl;
    }else{
        cout<<"El numero "<<a<<" y "<<b<<" NO son amigos."<<endl;
    }

    return 0;
}

