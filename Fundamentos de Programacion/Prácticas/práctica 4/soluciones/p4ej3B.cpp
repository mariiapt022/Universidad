//María Peinado Toledo
//Práctica 4. Ejercicio 3B. 25/11/2020

#include <iostream>
using namespace std;


void leerNumeros(int&n, int&m){
    do{
        cout<<"Introduce inicio del intervalo, n= ";
        cin>>n;
        cout<<"Introduce final del intervalo, (>n) m= ";
        cin>>m;
    }while(m<=n);
}

int sumaDivisores(int num){
    int suma=0;
    for(int x=1; x<num; x++){
        if(num%x==0){
            suma=suma+x;
        }
    }
    return suma;
}

int main(){
    int n,m;
    leerNumeros(n,m);

    for(int x=n; x<=m;x++){
        int y=sumaDivisores(x);
        if(y>x){
            if(x==sumaDivisores(y)){
                cout<<"Numeros amigos encontrados: "<<x<<", "<<y<<endl;
            }
        }
    }
    return 0;
}
