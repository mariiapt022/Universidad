//Control 2. Ejercicio 18

#include <iostream>
#include <array>
using namespace std;
const int MAX=50;
typedef array <int,MAX> TArray;


void aCero(TArray& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}

void calcularFrecuencia(TArray& v, char letra){
    int i=letra-'A';
    v[i]++;
}

void leerDatos(TArray& v, char letra){
    cout<<"Introduzca una secuencia de letras mayusculas (punto para terminar): ";
    cin>>letra;
    while(letra!='.'){
        calcularFrecuencia(v,letra);
        cin>>letra;
    }
}



void imprimirDatos(TArray& v){
    char letra='A';

    for(int i=0;i<MAX;i++){
        if(v[i]!=0){
            cout<<letra<<": "<<v[i]<<endl;
        }
        letra++;
    }
}

int main(){
    TArray v;
    char letra;

    aCero(v);
    leerDatos(v,letra);
    imprimirDatos(v);
    return 0;
}


//Prueba BAACABDPBHBH









