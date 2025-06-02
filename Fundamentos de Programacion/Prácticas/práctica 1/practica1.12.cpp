//María Peinado Toledo
//Práctica 1. Ejercicio 12. 14/10/2020

#include <iostream>
using namespace std;
int main()
{
int a=6, b=14;
int auxiliar;
cout << "a vale " << a << " y b vale " << b << endl;
// ¿Qué hacen estas tres sentencias?
auxiliar = a;
a = b;
b = auxiliar;
cout << "a vale " << a << " y b vale " << b << endl;
return 0;
}

/*Todos los grupos de sentencias hacen un intercambio de valores
(a y b). Se utiliza una varibale inmediata (auxiliar)*/
