//María Peinado Toledo
//Práctica 1. Ejercicio 5. 14/10/2020

#include <iostream>
using namespace std;

int main()
{
    char a,b,c,d;
    cout<<"Introduzca su primera letra:";
    cin>>a;
    cout<<"Introduzca su segunda letra:";
    cin>>b;
    cout<<"Introduzca su tercera letra:";
    cin>>c;
    cout<<"Introduzca su cuarta letra:";
    cin>>d;

    cout<< "Su palabra es:"<<a<<b<<c<<d<<endl;

    cout<< "Su nueva palabra es:"<< char(int(a)+1)<<char(int(b)+1)<<char(int(c)+1)<<char(int(d)+1)<<endl;
    return 0;

}
