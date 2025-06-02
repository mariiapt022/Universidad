//María Peinado Toledo
//Relación 1. Ejercicio 17. 19/10/2020

#include <iostream>
using namespace std;

int main()
{
    a)
    bool test;
    int N;
    N=3;

    test = true;
    for (int contador= 1;contador<=N;contador++) {
        test = !test;
    }
    contador=1; test= false;
    contador=3; test= true;
    contador=3; test= false;
    contador=4; //Se acaba

    b)
    bool test;
    int N;
    N=3;

    test = N %2 ==0; test= false;
    for (int contador= 1;contador<=N;contador++) {
        test = !test;
    }
    contador=1; test=true;
    contador=2; test=false;
    contador=3; test=true;
    contador=4; //Se acaba
}
