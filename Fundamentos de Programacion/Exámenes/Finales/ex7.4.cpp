//Examen 7. Ejercicio 4
#include <iostream>
#include <string>
#include <array>
using namespace std;
const int MAX=100;
struct TLetra{
    char letra;
    int rep=0;
};
typedef array <TLetra,MAX>TPalabra;
struct TDatos{
    TPalabra cadena;
    int tam=2;
};

void leerDatos(string& cadena1,string& cadena2){
    cout<<"Introduzca la primera cadena: ";
    cin>>cadena1;

    cout<<"Introduzca la segunda cadena: ";
    cin>>cadena2;
}



bool esta(const string& cadena,const char letra){
    int i=0;
    while(i<cadena.size()&&cadena[i]!=letra){
        i++;
    }
    return i<cadena.size();
}

int posicion(const string& cadena,const char letra,const int pos){
    int i=pos;
    while(i<cadena.size()&&cadena[i]!=letra){
        i++;
    }
    return i;
}

int repeticiones(const string& cadena,const char letra){
    int cont=0;
    for(int i=0;i<cadena.size();i++){
        if(cadena[i]==letra){
            cont++;
        }
    }
    return cont;
}


void coincidencias(string& cadena1,string& cadena2){
    int pos,rep1,rep2;
    int contM=0,contD=0;

    for(int i=0;i<cadena1.size();i++){
        if(cadena1[i]==cadena2[i]){
            contM++;
        }else if(esta(cadena2,cadena1[i])){
            contD++;
        }

    }

    cout<<"Coincidencias en mismas posiciones: "<<contM<<endl;
    cout<<"Coincidencias en distintas posiciones: "<<contD<<endl;

}

int main(){
    string cadena1,cadena2;
    leerDatos(cadena1,cadena2);
    coincidencias(cadena1,cadena2);
    return 0;
}


