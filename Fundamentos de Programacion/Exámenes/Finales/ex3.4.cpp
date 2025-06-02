//Examen 3. Ejercicio 4
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TDatos;
struct TPalabras{
    TDatos palabra;
    int nPal;
};

bool esta(const TPalabras& v,string& palabra){
    int i=0;
    while(i<v.nPal&&v.palabra[i]!=palabra){
        i++;
    }
    return i<v.nPal;
}

void leerDatos(TPalabras& v){
    string palabra;
    cout<<"Introduzca una texto (FIN para terminar): "<<endl;
    cin>>palabra;
    v.nPal=0;
    while(palabra!="FIN"&&v.nPal<MAX_PAL_DIST){
        if(!esta(v,palabra)){
            v.palabra[v.nPal]=palabra;
            v.nPal++;
        }
        cin>>palabra;
    }
}

void ordenar(TPalabras& v){
    int tam=1,cont=0;
    while(cont<v.nPal){
        for(int i=0;i<v.nPal;i++){
            if(int(v.palabra[i].size())==tam){
                cout<<v.palabra[i]<<" ";
                cont++;
            }
        }
        tam++;
    }
}

int main(){
    TPalabras v;
    leerDatos(v);
    ordenar(v);
    return 0;
}

// CREO QUE VOY A IR ESTA TARDE AL CINE Y LUEGO VOY A IR A CENAR MAS TARDE FIN
