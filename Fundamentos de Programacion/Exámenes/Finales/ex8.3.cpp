//Examen 8. Ejercicio 3.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TPalabras;
struct TDatos{
    TPalabras palabra;
    int tam;
};

bool esta(const TDatos& v,const string palabra){
    int i=0;
    while(i<v.tam&&v.palabra[i]!=palabra){
        i++;
    }
    return i<v.tam;
}

bool estaOrdenado(const string& palabra){
    char anterior=palabra[0];
    bool ordenado=true;
    int i=1;
    while(i<palabra.size()&&ordenado){
        if(palabra[i]<anterior){
            ordenado=false;
        }
        anterior=palabra[i];
        i++;
    }
    return ordenado;
}

void leerDatos(TDatos& v){
    string palabra;
    v.tam=0;
    cout<<"Introduzca el texto (FIN para terminar): "<<endl;
    cin>>palabra;
    while(palabra!="FIN"){
        if(estaOrdenado(palabra)&&!esta(v,palabra)){
            v.palabra[v.tam]=palabra;
            v.tam++;
        }
        cin>>palabra;
    }
    cout<<"Las palabras ordenadas: "<<endl;
    for(int i=0;i<v.tam;i++){
        cout<<v.palabra[i]<<" ";
    }
}

int main(){
    TDatos v;
    leerDatos(v);
    return 0;
}

//ELLOS CANTAN EL HIMNO DE SU EQUIPO DE FUTBOL CON PASION Y YO NO CANTO EL HIMNO FIN
