//Mar�a Peinado Toledo
//Pr�ctica 2. Ejercicio 2. 21/10/2020

#include <iostream>
using namespace std;

int main()
{
    int n1, n2, n3;
    cout<<"Introduzca su primer n�mero: ";
    cin>>n1;
    cout<<"Introduzca su segundo n�mero: ";
    cin>>n2;
    cout<<"Introduzca su tercer n�mero: ";
    cin>>n3;

    if (n1 > n2 && n1 > n3) {
		cout << n1 <<" Es el mayor estricto";
	} else {
		if (n2 > n1 && n2 > n3) {
			cout << n2 <<" Es el mayor estricto";
		} else {
			if (n3 > n1 && n3 > n2) {
				cout << n3 <<" Es el mayor estricto";
			} else { cout << "No existe mayor estricto";}
		}
	}
	return 0;
}
