//María Peinado Toledo
//Práctica 3. Ejercicio 2. 28/10/2020

#include <iostream>
using namespace std;
int main()
{
    int numMod,i;
    float media,precioMod,suma;
    suma=0;

    cout<<"Introduzca numero de modelos de coche: ";
    cin>>numMod;

    for(i=1;i<=numMod;i++){
        cout<<"Precio modelo "<<i<<": ";
        cin>>precioMod;
        suma=suma+precioMod;
    }

    media= suma/numMod;

    cout<<"El valor medio de los "<<numMod<<" de coche asciende a:"<<media;

    return 0;


}
