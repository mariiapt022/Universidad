#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX=27;
typedef array<int,MAX>TVector;

void Inicializar (TVector& v1, TVector& v2){
    for (int i=0;i<MAX;i++){
        v1[i]=0;
        v2[i]=0;
    }
}

void Anagrama(const TVector& v1, const TVector& v2, bool& ana,int& cont){
     ana=true;
     for (int i=0;i<MAX;i++){
        if (v1[i]!=v2[i]){
            ana=false;
        }
     }
         if (ana) {
        cont++;
     }
}

void Secuencia2(const string& palabra, TVector& v) {
    int k;
    for (int i=0;i<palabra.size();i++){
        k=int(palabra[i])-int('A');
        v[k]++;
    }
}

void Secuencia (string& primera, string& cadena, TVector& v1, TVector& v2){
    bool ana;
    int cont=0;
    cout << "Introduzca un texto terminado con la palabra FIN:" << endl;
    cin >> primera;
    Secuencia2 (primera,v1);
    cin >> cadena;
    while (cadena != "FIN") {
        Secuencia2(cadena,v2);
        Anagrama(v1,v2,ana,cont);
        for (int i=0;i<MAX;i++){
        v2[i]=0;
    }
    // cout << endl << cont << " aa " << endl;
        cin >> cadena;
    }
    cout << endl << "El numero de palabras anagramas de la primera es: " << cont;
}

int main()
{
    string primera;
    string cadena;
    TVector v1,v2;
    Inicializar(v1,v2);
    Secuencia (primera,cadena,v1,v2);
}
