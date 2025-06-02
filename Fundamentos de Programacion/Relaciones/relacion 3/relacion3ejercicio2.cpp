//María Peinado Toledo
//Relación 3. Ejercicio 2. 03/12/2020

#include <array>
#include <iostream>
using namespace std;
const int MAX=10;
typedef array<int, MAX>TVector;


void leerDatos(TVector& v,int& elem){
    cout<<"Introduzca el valor a buscar: ";
    cin>>elem;

    cout<<"Introduzca "<<MAX<<" numeros enteros: ";
    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
}

bool buscar(const TVector& v, int elem){
    int i=0;
    while((i<MAX)&&(v[i]!=elem)){
        i++;
    }

    return v[i]==elem;
}

int main(){
    TVector v;
    int elem;
    leerDatos(v,elem);

    if(buscar(v,elem)){
        cout<<"Elemento contenido.";
    }else{
        cout<<"Elemento no contenido.";
    }

    return 0;
}











