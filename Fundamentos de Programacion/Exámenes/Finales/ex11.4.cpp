//Examen 11. Ejercicio 4
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TVector;
struct TTexto{
    TVector datos;
    int tam;
};

bool esta(const string palabra,const char letra){
    int i=0;
    while(i<palabra.size()&&palabra[i]!=letra){
        i++;
    }
    return i<palabra.size();
}


bool sonLocogramas(const string patron,const string palabra){
    bool cumple=true;
    int i=0,j=0;

    if(patron.size()!=palabra.size()){
        cumple=false;
    }

    while(i<patron.size()&&cumple){
        if(!esta(palabra,patron[i])){
            cumple=false;
        }
        i++;
    }

    while(j<palabra.size()&&cumple){
        if(!esta(patron,palabra[j])){
            cumple=false;
        }
        j++;
    }

    return cumple;
}

bool estaT(const TTexto& v,const string palabra){
    int i=0;
    while(i<v.tam&&v.datos[i]!=palabra){
        i++;
    }
    return i<v.tam;
}

void mostrar(TTexto& v){
    for(int i=0;i<v.tam;i++){
        cout<<v.datos[i]<<" ";
    }
}

int main(){
    TTexto v;
    string palabra,patron;
    cout<<"Introduzca un texto (FIN para terminar): "<<endl;
    cin>>patron;

    v.tam=0;
    cin>>palabra;
    while(palabra!="FIN"){
        if(!estaT(v,palabra)&&sonLocogramas(patron,palabra)){
            v.datos[v.tam]=palabra;
            v.tam++;
        }
        cin>>palabra;
    }

    cout<<endl;

    mostrar(v);

    return 0;
}
