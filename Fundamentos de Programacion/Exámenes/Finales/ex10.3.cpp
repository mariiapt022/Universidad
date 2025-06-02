//Examen 10. Ejercicio 3.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TVector;
struct TPalabras{
    TVector palabra;
    int tam;
};

bool esta(const TPalabras& v,const string palabra){
    int i=0;
    while(i<v.tam&&v.palabra[i]!=palabra){
        i++;
    }
    return i<v.tam;
}

int sumaASCII(const string& palabra){
    int suma=0;
    for(int i=0;i<palabra.size();i++){
        suma=suma + int(palabra[i]);
    }
    return suma;
}

void mostrar(TPalabras& v){
    for(int i=0;i<v.tam;i++){
        cout<<v.palabra[i]<<" ";
    }
}

int main(){
    TPalabras v;
    int sumapatron,sumap;
    string patron,palabra;
    v.tam=0;
    cout<<"Introduzca el patron: ";
    cin>>patron;
    sumapatron=sumaASCII(patron);

    cout<<"Introduzca el texto (FIN para terminar): "<<endl;
    cin>>palabra;
    while(palabra!="FIN"){
        sumap=sumaASCII(palabra);
        if(sumap==sumapatron&&!esta(v,palabra)){
            v.palabra[v.tam]=palabra;
            v.tam++;
        }
        cin>>palabra;
    }
    cout<<endl;
    cout<<"Las palabras que cumplen la condicion son: "<<endl;
    mostrar(v);

    return 0;
}



//SACA DE CASA EL CAKI SOLO BEBO AGUA EN CASA CON EL CAKI FIN













