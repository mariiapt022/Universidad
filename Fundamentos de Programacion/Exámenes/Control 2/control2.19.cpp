//Control 2. Ejercicio 19

#include <iostream>
#include <array>
using namespace std;
const int MAX=20;
typedef array <int,MAX>Componentes;

struct Vector{
    Componentes datos;
    int tam;
};

//A

void aCero(Vector& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
}

void calcularFrecuencia(Vector& v,char letra){
    int i=letra-'A';
    v.datos[i]++;
}

void leerDatos(Vector& v){
    char letra;
    cout<<"Introduzca una secuencia de letras mayusculas: ";
    cin.get()>>letra;
    calcularFrecuencia(v,letra);
}

void calcularModa(Vector& v){
    int moda=v.datos[0],cont=0;
    char letra;

    for(int i=0;i<MAX;i++){
        if(v.datos[i]>moda){
            moda=v.datos[i];
            letra=i+'A';
        }
    }

    for(int j=0;j<MAX;j++){
        if(v.datos[j]==moda){
            cont++;
        }
    }

    if(cont>1){
        cout<<"No hay moda."<<endl;
    }else{
        cout<<"La moda es: "<<letra<<"."<<endl;
    }

}

int main(){
    Vector v;

    aCero(v);
    leerDatos(v);
    calcularModa(v);

    return 0;

}


//Prueba ABACDBAD




