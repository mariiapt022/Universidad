#include <iostream>
using namespace std;

int main()
{
    int N, mayor=0, contador=0,i=2;
    bool primo=true;

    cout<<"Introduzca una secuencia de numeros enteros positivos terminada en 0: ";
    cin>>N;

    while(N!=0){

        for(int i=2; i<N; i++){
            if(N%i==0){
                primo=false;
            }
        }

        if(primo=true){
            if(N>mayor){
                mayor=N;
            }
        }
        cin>>N;
    }

    if(mayor==0){
        cout<<"No hay ningun primo en la secuencia.";
    }else{
        cout<<"El mayor primo de la secuencia es: "<<mayor;
    }

    return 0;
}
