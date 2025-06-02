//María Peinado Toledo
//Relación 1. Ejercicio 24. 24/10/2020

#include <iostream>
using namespace std;

int main()
{
    int num,secuencia;
    int mayor= 0, menor=99999999999999999;
    float media;

    cout<<"Introduzca la cantidad de numeros a insertar:";
    cin>>num;
    cout<<"Introduzca la secuencia de numeros terminada en 0: ";

    for(int a = 0; a < num; a++) {
    cin >> secuencia;
    if(secuencia > mayor) {
      mayor = secuencia;
    }

    if(secuencia < menor) {
      menor = secuencia;
    }

    media += secuencia;

    }

    media /= num;


  cout << "El mayor de los numeros insertados es: " << mayor << endl;
  cout << "El menor de los numeros insertados es: " << menor << endl;
  cout << "La media aritmetica de los numeros insertados es: " << media << endl;
}

