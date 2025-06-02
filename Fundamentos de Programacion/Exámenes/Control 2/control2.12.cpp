//Control 2. Ejercicio 12

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TVector;

struct TLista{
    TVector datos;
    int num;
};

void aCero(TLista& lista1,TLista& lista2){

    for(int i=0;i<MAX;i++){
        lista1.datos[i]=0;
    }
    for(int j=0;j<MAX;j++){
        lista2.datos[j]=0;
    }

    lista1.num=0;

}

bool estaEnLista1(TLista& lista1, int num){
    bool esta=false;

    for(int i=0;i<lista1.num;i++){
        if(lista1.datos[i]==num){
            esta=true;
        }
    }

    return esta;
}
bool estaEnLista2(TLista& lista2, int num){
    bool esta=false;

    for(int i=0;i<lista2.num;i++){
        if(lista2.datos[i]==num){
            esta=true;
        }
    }

    return esta;
}

void leerDatos(TLista& lista1, TLista& lista2, int& numRot){
    int i=0,j=0,datos1,datos2;
    cout<<"Introduzca el numero de rotaciones: ";
    cin>>numRot;

    cout<<"Introduzca la primera lista: ";
    cin>>datos1;
    while(i<MAX&&datos1>0&&!estaEnLista1(lista1,datos1)){
        lista1.datos[i]=datos1;
        i++;
        lista1.num++;
        cin>>datos1;
    }

    cin.ignore(1000,'\n');

    cout<<"Introduzca la segunda lista: ";
    cin>>datos2;
    while(j<MAX&&datos2>0&&!estaEnLista2(lista2,datos2)){
        lista2.datos[j]=datos2;
        j++;
        lista2.num++;
        cin>>datos2;
    }
}

void escribirListas(TLista& lista1, TLista& lista2){
    cout<<"lista1: ";
    for(int i=0;i<lista1.num;i++){
        cout<<lista1.datos[i]<<" ";
    }

    cout<<endl;

    cout<<"lista2: ";
    for(int j=0;j<lista2.num;j++){
        cout<<lista2.datos[j]<<" ";
    }

    cout<<endl;

}

void rotar(TLista& lista1, TLista& lista2, int numRot){
    int cont1=0,cont2=0,ant1,ant2,ahora1,ahora2;

    cout<<"Tras 6 rotaciones: "<<endl;

    while(cont1<numRot){
        ant1=lista1.datos[lista1.num-1];
        for(int i=0;i<lista1.num;i++){
            ahora1=lista1.datos[i];
            lista1.datos[i]=ant1;
            ant1=ahora1;
        }
        cont1++;
    }

    cout<<"lista1: "<<endl;
    for(int j=0;j<lista1.num;j++){
        cout<<lista1.datos[j]<<" ";
    }

    cout<<endl;

    while(cont2<numRot){
        ant2=lista2.datos[lista2.num-1];
        for(int k=0;k<lista2.num;k++){
            ahora2=lista2.datos[k];
            lista2.datos[k]=ant2;
            ant2=ahora2;
        }
        cont2++;
    }

    cout<<"lista2: "<<endl;
    for(int s=0;s<lista2.num;s++){
        cout<<lista2.datos[s]<<" ";
    }

    cout<<endl;

}


void eliminar(TLista& lista1, TLista& lista2){

    cout<<"Tras eliminar los elementos de lista1 que estan en lista2: "<<endl;

    cout<<"lista 1: "<<endl;
    for(int i=0;i<lista1.num;i++){
        if(!estaEnLista2(lista2,lista1.datos[i])){
            cout<<lista1.datos[i]<<" ";
        }
    }

    cout<<endl;

    cout<<"lista 2: "<<endl;
    for(int j=0;j<lista2.num;j++){
        cout<<lista2.datos[j]<<" ";
    }

}

int main(){
    TLista lista1, lista2;
    int numRot;

    aCero(lista1,lista2);
    leerDatos(lista1,lista2,numRot);
    escribirListas(lista1,lista2);
    rotar(lista1,lista2,numRot);
    eliminar(lista1,lista2);

    return 0;
}


//Prueba 3 8 7 4 9 8 3 -1
