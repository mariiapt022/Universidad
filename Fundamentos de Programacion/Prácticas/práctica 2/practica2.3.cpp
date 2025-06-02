//María Peinado Toledo
//Práctica 2. Ejercicio 3. 21/10/2020

#include <iostream>
using namespace std;

int main()
{
    char a;
    cout<<"Introduzca su caracter: ";
    cin>>a;

    if (a>='A' && a <='Z'){
		cout << "Es un caracter"<< endl;
	} else {
		if ( a >='a' && a<='z') {
			cout << "Es un caracter"<< endl;
		} else if (a=='.'){ cout << "Es un punto"<< endl;
		}else {cout << "Error"<< endl; }
	}
	return 0;

}
