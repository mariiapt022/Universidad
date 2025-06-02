//Control 2. Ejercicio 5

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TVector;

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

bool ordenado(const TArray& v){
    int valor=v.datos[0],aux=1;
    bool orden=false;

    for(int i=1;i<v.num;i++){
        if(v.datos[i]>valor&&aux!=0){
            orden=true;
        }else{
            orden=false;
            aux=0;
        }
        valor=v.datos[i];
    }

    return orden;
}

int main(){
    TArray v;

    bool orden;
    aCero(v);
    leerDatos(v);
    orden=ordenado(v);

    if(orden){
        cout<<"El array SI esta ordenado. ";
    }else{
        cout<<"El array NO esta ordenado. ";
    }

    return 0;
}












