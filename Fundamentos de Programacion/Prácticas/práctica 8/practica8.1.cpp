//María Peinado Toledo
//Práctica 8. Ejercicio 1. 25/01/2021
#include <iostream>
#include <string>
using namespace std;

void leerDatos(string& cadena){
    cout<<"Entrada: ";
    cin>>cadena;
}

void convertir(const string& cadena){
    int num=0,k,dig=1;

    for(int i=0;i<int(cadena.size());i++){
        k=(cadena[cadena.size()-1-i]-int('0'))*dig;
        num=num+k;
        dig=dig*10;
    }
    cout<<"Salida: "<<num;
}

int main(){
    string cadena;
    leerDatos(cadena);
    convertir(cadena);
    return 0;
}
