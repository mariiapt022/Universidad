//Control 2. Ejercicio 7

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TArray;

void aCero(TArray& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}

void leerDatos(TArray& v){
    cout<<"Introduzca "<<MAX<<" numeros enteros: ";

    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
}

float calcularMedia(const TArray& v){
    int suma=0;
    float media;

    for(int i=0;i<MAX;i++){
        suma=suma+v[i];
    }

    media=suma/MAX;

    return media;
}


float indiceArray(const TArray& v, float media){
    int indice=0, cont=1;

    for(int i=0;i<MAX;i++){
        if(v[i]>=media&&cont!=0){
            indice=i;
            cont=0;
        }
    }

    return indice;
}

int main(){
    TArray v;
    float media;
    int indice;

    aCero(v);
    leerDatos(v);

    media=calcularMedia(v);
    cout<<media<<endl;
    indice=indiceArray(v,media);

    cout<<"El primer elemento mayor o igual que la media se encuentra en la posicion: "<<indice<<"."<<endl;

    return 0;
}

//Prueba: 3 1 4 0 7 2 5 9 8 6


