//María Peinado Toledo
//Práctica 1. Ejercicio 8. 14/10/2020

#include <iostream>
using namespace std;

int main()
{
    char a, b, c, d;
    cout<<"Introduzca una sus cuatro letras minusculas:";
    cin>>a>>b>>c>>d;

    a=char(int('A')+(int(a)-int('a')));
    b=char(int('A')+(int(b)-int('a')));
    c=char(int('A')+(int(c)-int('a')));
    d=char(int('A')+(int(d)-int('a')));

    cout<<"La palabra en mayuscula es:"<<a<<b<<c<<d<<endl;

    return 0;

}
