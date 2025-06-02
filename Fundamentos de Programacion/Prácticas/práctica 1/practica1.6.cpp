//María Peinado Toledo
//Práctica 1. Ejercicio 6. 14/10/2020

#include <iostream>
using namespace std;

const int KBYTES = 1024;
const int MBYTES = 1048576;

int main()
{
    int bytes,kbytes, mbytes, resto, bytesresul;

    cout<<"Introduzca un número de bytes:";
    cin>>bytes;

    mbytes= bytes/MBYTES;
    resto= bytes%MBYTES;
    kbytes= resto/KBYTES;
    bytesresul= resto%KBYTES;

    cout<<"Podemos obtener:"<<mbytes<<"MBytes,"<<kbytes<<"Kbytes,"<<bytesresul<<"Bytes.";


    return 0;
}

