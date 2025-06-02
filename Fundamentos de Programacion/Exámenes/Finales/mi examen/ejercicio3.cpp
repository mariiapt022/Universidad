//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A3/A4 PC1108
//Examen Febrero. Ejercicio 3. 05/02/2021

#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
struct TPalabra{
    string palabra;
    char pos;
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

void leerDatos(TDatos& v,float& charin,float& charfin){
    string palabra;
    int ind;
    char pos='0';
    charin=0,charfin=0;

    cout<<"Introduzca un texto (FIN para terminar): "<<endl;
    cin>>palabra;
    v.tam=0;
    while(palabra!="FIN"){
        charin=charin+palabra.size();
        if(!esta(v,palabra)){
            v.datos[v.tam].palabra=palabra;
            v.datos[v.tam].pos=pos;
            charfin=charfin+palabra.size();
            pos++;
        }else{
            ind=buscarIndice(v,palabra);
            v.datos[v.tam].palabra=v.datos[ind].pos;
        }
        cin>>palabra;
        v.tam++;
    }
    cout<<endl;
}

float compactacion(float charin,float charfin){
    float comp;
    comp=(charin-charfin)/charin*100;
    return comp;
}

void mostrar(TDatos& v){
    for(int i=0;i<v.tam;i++){
        cout<<v.datos[i].palabra<<" ";
    }
    cout<<endl;
}

int main(){
    TDatos v;
    float comp,in,fin;

    leerDatos(v,in,fin);
    cout<<"El texto compactado: "<<endl;
    mostrar(v);
    cout<<endl;
    comp=compactacion(in,fin);
    cout<<"El porcentaje de compactacion es de: "<<comp<<"%";
    cout<<endl;

    return 0;
}

//ES BUENO HACERLO PERO ES BUENO HACERLO AHORA AHORA ES EL MOMENTO BUENO DE HACERLO FIN
