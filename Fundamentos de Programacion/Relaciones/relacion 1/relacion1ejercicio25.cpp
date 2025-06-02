//María Peinado Toledo
//Relación 1. Ejercicio 25. 24/10/2020

#include <iostream>
using namespace std;

const int NUMERO_A_BUSCAR = 12;

int main()
{
   int contador, numeroLeido, primeraAparicion = 0, ultimaAparicion;
   cout << "Introduce una secuencia de numeros que termine en 0: ";
    cin >> numeroLeido;
    contador = 1;
    while(numeroLeido != 0)
    {if (numeroLeido == NUMERO_A_BUSCAR)
        {if (primeraAparicion == 0){
                primeraAparicion = contador;
                ultimaAparicion = contador;
            }else{
                ultimaAparicion = contador;
            }
        }
        cin >> numeroLeido;
        contador ++;
    }

    cout << "Primera aparicion del " << NUMERO_A_BUSCAR << ": " << primeraAparicion << endl;
    cout << "Ultima aparicion del " << NUMERO_A_BUSCAR << ": " << ultimaAparicion << endl;

    return 0;
}
