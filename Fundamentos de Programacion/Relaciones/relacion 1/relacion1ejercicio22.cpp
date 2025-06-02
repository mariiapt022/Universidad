//María Peinado Toledo
//Relación 1. Ejercicio 22. 01/11/2020

#include <iostream>
using namespace std;

const char CADENA0 = 'a';
const char CADENA1 = 'b';
const char CADENA2 = 'c';

int main()
{
    char leido0, leido1, leido2;
    bool encontrado = false;

    cout << "Introduzca una cadena de caracteres acabada en punto: ";
    leido2 = cin.get();

    while(leido2 != '.' && !encontrado){
        if(leido0 == CADENA0 && leido1 == CADENA1 && leido2 == CADENA2)
        {
            encontrado = true;
        }
        leido0 = leido1;
        leido1 = leido2;
        leido2 = cin.get();
    }

    if(encontrado){
        cout << "Cadena " << CADENA0 << CADENA1 << CADENA2 << " SI encontrada" << endl;
    }else{
        cout << "Cadena " << CADENA0 << CADENA1 << CADENA2 << " NO encontrada" << endl;
    }
    return 0;
}
