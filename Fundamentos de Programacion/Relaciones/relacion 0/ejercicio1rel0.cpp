/* María Peinado Toledo
Programa: calculadora de radianes
*/

#include <iostream>
using namespace std;
const float PI = 3.14159;

//Inicio del programa principal

int main ()
{
    int grados,minutos,segundos;

    cout <<"Introduzca su ángulo en grados, minutos y segundos:";
    cin >> grados >> minutos >> segundos;

    float radianes = ((PI/180)*grados)+(((PI/180)/60)*minutos)+(((PI/180)/3600)*segundos);

    cout << "Su ángulo es de:" << radianes << "radianes";

    return 0;


}
