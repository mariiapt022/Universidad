#include <iostream>
using namespace std;

//no va xq no le sale del coñarro

int main()
{
    int N, mayor=0, contador=0;
    bool perfecto=true;

    cout<<"Introduzca una secuencia de numeros enteros positivos terminada en 0: ";
    cin>>N;

    while(N!=0){
        contador=0;
        for(int i=1; i<N; i++){
            if(N%i==0){
                contador=i+contador;
            }
        }
        if(contador!=N){
                perfecto=false;
            }

        if(perfecto=true){
            if(N>mayor){
                mayor=N;
            }
        }
        cin>>N;
    }

    if(mayor==0){
        cout<<"No hay ningun numero perfecto en la secuencia.";
    }else{
        cout<<"El mayor numero perfecto de la secuencia es: "<<mayor;
    }

    return 0;
}
