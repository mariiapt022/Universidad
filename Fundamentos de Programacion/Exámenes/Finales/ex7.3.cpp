//Examen 7. Ejercicio 3.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TPalabras;
struct TTexto{
    TPalabras palabra;
    int tam;
};

bool esta(const TTexto& v,const string& palabra){
    int i=0;
    while(i<v.tam&&v.palabra[i]!=palabra){
        i++;
    }
    return i<v.tam;
}

bool cumplePatron(const string& patron,const string& palabra){
    int i=0,j=0;
    bool cumple=true;
    bool ya=false;

    while(i<patron.size()&&cumple){
        while(j<palabra.size()&&!ya){
            if(patron[i]==palabra[j]){
                ya=true;
                cumple=true;
            }else{
                cumple=false;
                j++;
            }
        }
        ya=false;
        i++;
    }

    return cumple;
}

void leerDatos(TTexto& v,string& patron){
    string palabra;
    v.tam=0;
    cout<<"Introduzca el patron: ";
    cin>>patron;
    cout<<"Introduzca el texto (FIN para terminar): "<<endl;
    cin>>palabra;
    while(palabra!="FIN"){
        if(!esta(v,palabra)&&cumplePatron(patron,palabra)){
            v.palabra[v.tam]=palabra;
            v.tam++;
        }
        cin>>palabra;
    }
}

void mostrar(TTexto& v,string patron){
    cout<<"Las palabras que contienen el patron "<<patron<<" son: "<<endl;
    for(int i=0;i<v.tam;i++){
        cout<<v.palabra[i]<<" ";
    }
}

int main(){
    TTexto v;
    string patron;
    leerDatos(v,patron);
    mostrar(v,patron);
    return 0;
}

//CREO QUE IREMOS A LA DIRECCION QUE NOS DIERON Y TAMBIEN IREMOS A LA DIRECCION NUEVA QUE YO CONOCIA FIN
