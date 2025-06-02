//María Peinado Toledo
//Práctica 3. Ejercicio 4. 28/10/2020

#include <iostream>
using namespace std;
int main()
{
    char a;
    int num = 0;

    cout << "Escriba una secuencia de caracteres terminada en un punto." << endl; // prints !!!Hello World!!!
    cin.get(a);

    while(a != '.'){
        cout << int(a) << endl;
        num++;
        cin.get(a);
    }

    cout << endl;
    cout << "Se han leido "<< num << " caracteres.";

    return 0;
}
