//Control 2. Ejercicio 22

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TVector;

struct TLista{
    TVector datos;
    int num;
};

void aCero(TLista& lista1, TLista& lista2){
    for(int i=0;i<MAX;i++){
        lista1.datos[i]=0;
        lista2.datos[i]=0;
    }
    lista1.num=0;
    lista2.num=0;
}

void leerDatos(TLista& lista1, int& x){
    cout<<"Introduzca la cantidad de numeros: ";
    cin>>lista1.num;

    cout<<"Introduzca "<<lista1.num<<" numeros enteros: ";
    for(int i=0;i<lista1.num;i++){
        cin>>lista1.datos[i];
    }

    cout<<"Introduzca x (numRep): ";
    cin>>x;
}

bool estaEnLista2(TLista& lista2,int num){
    bool esta=false;

    for(int i=0;i<lista2.num;i++){
        if(lista2.datos[i]==num){
            esta=true;
        }
    }

    return esta;
}

void crearLista2(TLista& lista1, TLista& lista2, int x){

    int valor, cont=0, k=0;

    for(int i=0;i<lista1.num;i++){
        valor=lista1.datos[i];
        for(int j=0;j<lista1.num;j++){
            if(valor==lista1.datos[j]){
                cont++;
            }
        }

        if(cont==x&&!estaEnLista2(lista2,valor)){
            lista2.datos[k]=valor;
            k++;
            lista2.num++;
        }
        cont=0;
    }

    cout<<"La lista cribada: ";
    for(int z=0;z<lista2.num;z++){
        cout<<lista2.datos[z]<<" ";
    }

}

int main(){
    TLista lista1,lista2;
    int x;
    aCero(lista1,lista2);
    leerDatos(lista1,x);
    crearLista2(lista1,lista2,x);
    return 0;
}






