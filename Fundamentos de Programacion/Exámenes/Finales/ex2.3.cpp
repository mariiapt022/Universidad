//Examen 2. Ejercicio 3

#include <iostream>
#include <string>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TGastos;
typedef array <char,MAX>TVector;

struct TPersonas{
    TVector p;
    string nombre;
};

void aCero(TGastos& g){
    for(int i=0;i<MAX;i++){
        g[i]=0;
    }
}

bool esta(TPersonas& p,string nombre,int tam){
    int cont=0;
    for(int i=0;i<tam;i++){
        if(nombre.p[i]==nombre){
            cont++;
        }
    }
    return cont!=0;
}

int buscarMismo(TPersonas& p,string nombre,int tam){
    int pos=0;
    for(int i=0;i<tam;i++){
        if(p[i]==nombre){
            pos=i;
        }
    }
    return pos;
}

void leerDatos(TGastos& g,TPersonas& p,int& tam,string nombre){
    char nombre;
    int i=0,pos,gasto;
    tam=0;
    cout<<"Introduzca nombres y gastos (FIN para terminar): "<<endl;
    cout<<"Nombre: ";
    cin>>nombre;
    while(nombre!="FIN"){
        cout<<"Gastos: ";
        if(!esta(p,nombre,tam)){
            p[i]=nombre;
            cin>>g[i];
        }else{
           pos=buscarMismo(p,nombre,tam);
           cin>>gasto;
           g[pos]=+gasto;
        }
        cout<<endl;
        i++;
        tam++;
        cout<<"Nombre: ";
        cin>>nombre;
    }
}

void imprimirDatos(TGastos& g,TPersonas& p,int tam){
    for(int i=0;i<tam;i++){
        cout<<p[i]<<": "<<g[i]<<endl;
    }
}

int main(){
    TPersonas p;
    TGastos g;
    string nombres;
    int tam;
    aCero(g);
    leerDatos(g,p,tam);
    imprimirDatos(g,p,tam);
    return 0;
}
























