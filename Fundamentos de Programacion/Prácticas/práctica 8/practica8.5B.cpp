//María Peinado Toledo
//Práctica 8. Ejercicio 5A(Ejercicio 23 rel3). 25/01/2021
#include <iostream>
#include <string>
#include <array>
using namespace std;
const int MAX_PAL_DIST=20;

struct TReg{
    string cadena;
    int priPos;
    int ultPos;
};

typedef array <TReg,MAX_PAL_DIST>TArray;

struct TDatos{
    TArray elementos;
    int numElem;
};

int buscarInd(const string& pal, const TDatos& datos) {
    int ind = 0;
    while (ind < datos.numElem && pal !=datos.elementos[ind].cadena){
        ind++;
    }
    return ind;
}

void escribir(const TDatos& datos) {
    cout << "Palabras y posiciones primera y ultima:"<<endl;
    for (int i = 0; i < datos.numElem; i++) {
        cout << datos.elementos[i].cadena << " "<< datos.elementos[i].priPos << " "<< datos.elementos[i].ultPos << endl;
    }
}

int main(){
    TDatos datos;
    string pal;
    int posCadTexto, indPalDat;

    cout << "Introduzca un texto (FIN para terminar):\n";
    datos.numElem = 0;
    cin >> pal;

    posCadTexto = 1;
    while (pal != "FIN") {
        indPalDat = buscarInd(pal,datos);

        if (indPalDat < datos.numElem) {
            datos.elementos[indPalDat].ultPos = posCadTexto;
        }else{
            datos.elementos[datos.numElem].cadena = pal;
            datos.elementos[datos.numElem].priPos = posCadTexto;
            datos.elementos[datos.numElem].ultPos = posCadTexto;
            datos.numElem++;
        }

        cin >> pal;
        posCadTexto++;
    }

    escribir(datos);

    return 0;
}

//CREO QUE IREMOS A MI CASA PRIMERO Y QUE DESPUES IREMOS A LA CASA QUE QUIERAS FIN









