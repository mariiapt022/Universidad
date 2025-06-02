//Examen 13. Ejercicio 3.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_LONG_DIST=20;
struct Longitud{
    int num;
    int ocurrencias=0;
};
typedef array <Longitud,MAX_LONG_DIST>TLongitudes;
struct TDatos{
    TLongitudes datos;
    int tam;
};

bool esta(const TDatos& v,const int num){
    int i=0;
    while(i<v.tam&&v.datos[i].num!=num){
        i++;
    }
    return i<v.tam;
}

int buscarIndice(const TDatos& v,const int num){
    int i=0;
    while(i<v.tam&&v.datos[i].num!=num){
        i++;
    }
    return i;
}

void leerDatos(TDatos& v){
    string palabra;
    int ind;
    v.tam=0;
    cout<<"Introduzca un texto (FIN para terminar): "<<endl;
    cin>>palabra;
    while(palabra!="FIN"){
        if(!esta(v,palabra.size())){
            v.datos[v.tam].num=palabra.size();
            v.datos[v.tam].ocurrencias++;
            v.tam++;
        }else{
            ind=buscarIndice(v,palabra.size());
            v.datos[ind].ocurrencias++;
        }
        cin>>palabra;
    }
}

void mostrar(TDatos& v){
    cout<<"Longitudes  Ocurrencias"<<endl;
    for(int i=0;i<v.tam;i++){
        cout<<v.datos[i].num<<"                "<<v.datos[i].ocurrencias<<endl;
    }
}

int main(){
    TDatos v;
    leerDatos(v);
    mostrar(v);
    return 0;
}

//CREO QUE IREMOS A MI CASA PRIMERO Y QUE DESPUES IREMOS A LA CASA QUE QUIERAS FIN
