#include <iostream>
#include <array>
#include <string>
using namespace std;


void Leerdatos(string& cadena){
    cout << "Entrada: ";
    cin >> cadena;
}

void Secuencia (const string& cadena){
   int num=0;
   int u=1;
   for (int i=0;i<cadena.size();i++) {
       int k=(cadena[cadena.size()-1-i]-int('0'))*u;
       u=u*10;
       num+=k;
   }
   cout << "Salida: " << num;
}


int main()
{
    string cadena;
    Leerdatos(cadena);
    Secuencia(cadena);
}

