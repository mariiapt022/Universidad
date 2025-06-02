//Examen 1. Ejercicio 3.
#include <iostream>
#include <string>
#include <array>
using namespace std;
const int MAX_PAL_DIST=20;
struct TPalabra{
    string palabra;
    int primera=0;
    int ultima=0;
};
typedef array <TPalabra,MAX_PAL_DIST>TPalabras;
struct TDatos{
    TPalabras datos;
    int tam;
};

bool esta(const TDatos& v,const string palabra){
    int i=0;
    while(i<v.tam&&v.datos[i].palabra!=palabra){
        i++;
    }
    return i<v.tam;
}

int buscarIndice(const TDatos& v,const string palabra){
    int i=0;
    while(i<v.tam&&v.datos[i].palabra!=palabra){
        i++;
    }
    return i;
}

void leerDatos(TDatos& v){
    string palabra;
    int pos=1,ind;
    v.tam=0;
    cout<<"Introduzca un texto (FIN para terminar): "<<endl;
    cin>>palabra;
    while(palabra!="FIN"){
        if(!esta(v,palabra)){
            v.datos[v.tam].palabra=palabra;
            v.datos[v.tam].primera=pos;
            v.datos[v.tam].ultima=pos;
            v.tam++;
        }else{
          ind=buscarIndice(v,palabra);
          v.datos[ind].ultima=pos;
        }
        pos++;
        cin>>palabra;
    }
}

void mostrar(TDatos& v){
    for(int i=0;i<v.tam;i++){
        cout<<v.datos[i].palabra<<": "<<v.datos[i].primera<<" "<<v.datos[i].ultima;
        cout<<endl;
    }
}

int main(){
    TDatos v;
    leerDatos(v);
    mostrar(v);
    return 0;
}

//CREO QUE IREMOS A MI CASA PRIMERO Y QUE DESPUES IREMOS A LA CASA QUE QUIERAS FIN
