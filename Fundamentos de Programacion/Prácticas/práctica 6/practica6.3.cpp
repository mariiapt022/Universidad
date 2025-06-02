//María Peinado Toledo
//Práctica 6. Ejercicio 3. 09/12/2020

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TDigitos;

void aCero(TDigitos& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}


void leerDatos(TDigitos& v,int& num){

    cout<<"Introduzca una secuencia de digitos (negativo termina): "<<endl;

    do{
        cin>>num;
        if(num>=0 && num<=9){
            v[num]++;
        }

    }while(num>=0);

}

void imprimirDatos(TDigitos& v){

    cout<<"La frecuencia de cada digito es: "<<endl;

    for(int i=0;i<MAX;i++){
        cout<<i<<": "<<v[i]<<endl;
    }
}

int main(){
    TDigitos v;
    aCero(v);
    int num;

    leerDatos(v,num);
    imprimirDatos(v);

    return 0;

}

