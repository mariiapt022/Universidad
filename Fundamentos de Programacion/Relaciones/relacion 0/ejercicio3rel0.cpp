/* María Peinado Toledo
Programa: salario neto de un trabajador
*/

#include <iostream>
using namespace std;

//Inicio del programa principal

int main()
{
    int antiguedad;
    float sueldobase, salarioneto, salariobruto;

    cout << "Programa para calcular el salario neto de un trabajador." << endl;
    cout << "Introduzca el sueldo base del trabajador: ";
    cin >> sueldobase;

    cout << "Introduzca el numero de años del trabajador en la empresa: ";
    cin >> antiguedad;

    salariobruto = sueldobase + ((60*(antiguedad/5))+(6*(antiguedad - 5*(antiguedad/5))));
    salarioneto = (salariobruto*75)/100;

    cout << "El salario neto total es de " <<salarioneto<< " euros." << endl;
    return 0;
}
