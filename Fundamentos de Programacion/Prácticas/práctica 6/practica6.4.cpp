//María Peinado Toledo
//Práctica 6. Ejercicio 4. 09/12/2020

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


int calcularMayor(const TDigitos& v){
    int mayor=v[0];
    for(int i=1;i<MAX;i++){
        if(v[i]>mayor){
            mayor=v[i];
        }
    }
    return mayor;
}


void imprimirGrafica(TDigitos& v, int mayor){

    cout<<"Su histograma es: "<<endl;
    cout<<endl;

    int copia=mayor;

    for(int i=0;i<mayor;i++){
        for(int j=0;j<MAX;j++){
            if(v[j]==copia){
                cout<<"* ";
                v[j]=v[j]-1;
            }else{
                cout<<"  ";
            }
        }

        copia=calcularMayor(v);
        cout<<endl;
    }

    cout<<"0 1 2 3 4 5 6 7 8 9";

}

int main(){
    TDigitos v;
    int num,mayor;

    aCero(v);
    leerDatos(v,num);
    mayor=calcularMayor(v);
    imprimirGrafica(v,mayor);

    return 0;

}




