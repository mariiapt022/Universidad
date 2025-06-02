//María Peinado Toledo
//Relación 1. Ejercicio 26. 24/10/2020

#include <iostream>
using namespace std;
int main()
{
    int intento=29, cont,suma;
    bool encontrado=false;

    while(!encontrado){
        suma=1;
        for(int i=2; i<=(intento/2);i++){
            if(intento%i==0){
                suma=suma+i;
            }
        }

        if(suma==intento){
            encontrado=true;
        }else{
            intento++;
        }

    }

    cout<<"El primer numero perfecto mayor que 28 es: "<<intento<<endl;
}
