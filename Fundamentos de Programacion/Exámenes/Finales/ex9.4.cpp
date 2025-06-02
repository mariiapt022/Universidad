//Examen 9. Ejercicio 4.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int TAM_CAR=5;
const int MAX_PAL_DIST=20;
struct TPalabra{
    string palabra;
    int num=0;
};
typedef array<TPalabra,MAX_PAL_DIST>TPalabras;
struct TDatos{
    TPalabras datos;
    int tam;
};

bool repetidas(const string patron){
    int cont=0;
    char letra='A';
    bool cumple=true;
    while(letra<='Z'&&cumple){
        for(int i=0;i<patron.size();i++){
            if(patron[i]==letra){
                cont++;
            }
        }
        if(cont>1){
            cumple=false;
        }
        cont=0;
        letra++;
    }

    return cumple;
}

bool esta(const TDatos& v,const string palabra){
    int i=0;
    while(i<v.tam&&v.datos[i].palabra!=palabra){
        i++;
    }
    return i<v.tam;
}

bool estaP(const string palabra,const char letra){
    int i=0;
    while(i<palabra.size()&&palabra[i]!=letra){
        i++;
    }
    return i<palabra.size();
}

int caracteresComun(const string patron,const string palabra){
    int cont=0;
    for(int i=0;i<patron.size();i++){
        if(estaP(palabra,patron[i])){
            cont++;
        }
    }
    return cont;
}

void mostrar(TDatos& v){
    for(int i=0;i<v.tam;i++){
        cout<<v.datos[i].palabra<<" "<<v.datos[i].num<<endl;
    }
}

int main(){
    TDatos v;
    string patron,palabra;
    bool norep;
    v.tam=0;
    do{
        cout<<"Introduzca el patron (long = "<<TAM_CAR<<", sin letras repetidas):"<<endl;
        cin>>patron;
        norep=repetidas(patron);
    }while(patron.size()!=TAM_CAR||!norep);

    cout<<"Introduzca el texto (FIN para terminar): "<<endl;
    cin>>palabra;
    while(palabra!="FIN"){
        if(!esta(v,palabra)){
            v.datos[v.tam].num=caracteresComun(patron,palabra);
            v.datos[v.tam].palabra=palabra;
            v.tam++;
        }
        cin>>palabra;
    }

    mostrar(v);

    return 0;

}

//ANTERIORMENTE IBA A TRABAJAR EN TREN PERO AHORA VOY A TRABAJAR EN AUTOMOVIL FIN
