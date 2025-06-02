//Examen 13. Ejercicio 1.
#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TVector;

void leerDatos(TVector& v){
    cout<<"Introduzca "<<MAX<<" numeros naturales: ";
    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
}

double calcularMedia(TVector& v){
    double suma=0;
    double media;
    for(int i=0;i<MAX;i++){
        suma=suma+v[i];
    }
    media=suma/MAX;
    return media;
}

void buscar_mayig_media(TVector& v,double media){
    int i=0;
    while(i<MAX&&v[i]<media){
        i++;
    }
    cout<<"El primer elemento >= q la media es "<<v[i]<<" se encuentra en: "<<i;
}

int main(){
    TVector v;
    double media;
    leerDatos(v);
    media=calcularMedia(v);
    cout<<media<<endl;
    buscar_mayig_media(v,media);
    return 0;
}

//3 1 4 0 7 2 5 9 8 6
