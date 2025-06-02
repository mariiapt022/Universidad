//Control 2. Ejercicio 1  MALL

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TVector;

struct TArray{
    TVector datos;
    int num;
};

void aCero(TArray& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
}

void leerDatos(TArray& v){
    cout<<"Introduzca el tamaño del array: ";
    cin>>v.num;

    cout<<"Introduzca "<<v.num<<" numeros enteros: ";
    for(int i=0;i<v.num;i++){
        cin>>v.datos[i];
    }
}


void ordenar (TArray& v){

    int minimo,aux;

    for(int i=0;i<v.num;i++){
        minimo=v.datos[i];
        for(int j=i+1;j<v.num;j++){
            if(v.datos[j]<v.datos[i]){
                minimo=v.datos[j];
                v.datos[j]=v.datos[i];
            }

            aux=v.datos[i];
            v.datos[i]=minimo;
            minimo=aux;
        }
        cout<<minimo<<" ";
    }

}

/*
void ordenar(TReg& v){
    int minimo, aux;

    for (int i=0; i<v.tam; i++){
        minimo=i;
        for (int j=i+1; j<v.tam; j++){
            if (v.datos[j]<v.datos[minimo]){
                minimo=j;
            }
        }
        aux=v.datos[i];
        v.datos[i]=v.datos[minimo];
        v.datos[minimo]=aux;
    }
}
*/


int main(){
    TArray v;

    aCero(v);
    leerDatos(v);
    ordenar(v);

    return 0;

}


//Prueba: 2 7 12 89 5 2 9 10












