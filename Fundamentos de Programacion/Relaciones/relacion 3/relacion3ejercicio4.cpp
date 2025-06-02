//María Peinado Toledo
//Relación 3. Ejercicio 4. 03/12/2020

#include <array>
#include <iostream>
using namespace std;
const int MAX=10;
typedef array<int,MAX>TVector;

struct TReg{
TVector datos;
int tam;
};

void leerDatos(TReg& v){
    int cont=0;

    do{
        cout<<"Introduzca cantidad de elementos: ";
        cin>>v.tam;
    }while ((v.tam<=0)||(v.tam>MAX));

    cout<<"Introduzca "<<v.tam<<" numeros enteros: ";

    for (int i=0; i<v.tam; i++){
        cin>>v.datos[i];
        cont++;
    }

    v.tam=cont;
}

void mostrarArray(const TReg& v){
    cout<<"Array Original: ";
    for (int i=0; i<v.tam; i++){
        cout<<v.datos[i]<<" ";
    }
}

void mostrarInvertido(const TReg& v){
    int cont=v.tam-1;

    cout<<endl<<"Array Invertido: ";
    while (cont>=0){
        cout<<v.datos[cont]<<" ";
        cont--;
    }
}

int main()
{
    TReg v;

    leerDatos(v);

    mostrarArray(v);

    mostrarInvertido(v);

    return 0;
}
