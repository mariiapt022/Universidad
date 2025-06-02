//Examen 3. Ejericicio 6.
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX=50;
struct TToken{
    string palabra;
    int rep=0;
};
typedef array<TToken,MAX>TVector;
struct TDatos{
    TVector token;
    int tam;
};

void aCero(TDatos& d){
    for(int i=0;i<MAX;i++){
        d.token[i].palabra="";
        d.token[i].rep=0;
    }
}

bool estaS(const string& separadores,const char letra){
    int i=0;
    while(i<separadores.size()&&separadores[i]!=letra){
        i++;
    }
    return i<separadores.size();
}

bool estaD(const TDatos& d,const string& palabra){
    int i=0;
    while(i<d.tam&&d.token[i].palabra!=palabra){
        i++;
    }
    return i<d.tam;
}

int buscarIndice(const TDatos& d,const string& palabra){
    int i=0;
    while(i<d.tam&&d.token[i].palabra!=palabra){
        i++;
    }
    return i+1;
}

void leerDatos(string& separadores,string& cadena){
    cout<<"Introduzca los separadores: ";
    getline(cin,separadores);

    cout<<"Introduzca la cadena: ";
    getline(cin,cadena);
}

void obtenerTokens(const string& cadena,const string& separadores,TDatos& d){
    int tam=0,aux,ind;
    d.tam=0;
    string nombre;

    for(int i=0;i<cadena.size();i=i+tam){
        tam=0;
        aux=i;
        while(!estaS(separadores,cadena[aux])){
            aux++;
            tam++;
        }

        nombre=cadena.substr(i,tam);

        if(!estaD(d,nombre)){
            d.token[d.tam].palabra=nombre;
            d.token[d.tam].rep=1;
            d.tam++;
        }else{
            ind=buscarIndice(d,nombre);
            d.token[ind].rep++;
        }
        i++;
    }
    cout<<"hola";

}

void mostrar(TDatos& d){
    for(int i=0;i<d.tam;i++){
        cout<<d.token[i].palabra<<","<<d.token[i].rep<<endl;
    }
}

int main(){
    TDatos d;
    string separadores,cadena;

    aCero(d);

    leerDatos(separadores,cadena);

    obtenerTokens(cadena,separadores,d);

    mostrar(d);

    return 0;
}

//Andrea Maria;Juan;Perez Lopez;Juan Antonio;Maria

