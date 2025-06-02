//María Peinado Toledo
//Relación 1. Ejercicio 23. 01/11/2020

#include <iostream>
using namespace std;
int main()
{

    int n, anterior1, anterior2, actual, contador;
    do{
        cout << "Introduzca un numero natural n (mayor que 0): ";
        cin >> n;
    } while(n<=0);
    anterior2 = 0;
    anterior1 = 1;

    contador = 3;

    if (n == 1)
    {
        actual = anterior2;
    }
    else if (n == 2)
    {
        actual = anterior1;
    }
    else
    {
        while(contador<=n)
        {
            actual = anterior2 + anterior1;

            anterior2 = anterior1;
            anterior1 = actual;

            contador++;
        }

    }

    cout << "El numero " << n << " en la serie de Fibonacci es el " << actual << endl;

    return 0;
}

