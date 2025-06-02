//María Peinado Toledo
//Práctica 4. Ejercicio 3B. 25/11/2020

#include <iostream>
using namespace std;

void leerNumeros(int& n, int& m){
    do{
        cout<<"Introduzca el limite inferior del intervalo: ";
        cin>>n;
        cout<<"Introduzca el limite superior del intervalo: ";
        cin>>m;
    }while(n<=0||m<=0||n>=m);
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

int main(){
    int n,m;
    leerNumeros(n,m);

    for(int x=n;x<=m;x++){
        int y=sumaDivisores(x);
        if(y>x&&y<=m){
            if(x==sumaDivisores(y)){
                cout<<"Numeros amigos encontrados: "<<x<<" y "<<y<<endl;
            }
        }
    }

    return 0;
}
