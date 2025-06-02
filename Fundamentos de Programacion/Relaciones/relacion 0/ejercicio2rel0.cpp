/* María Peinado Toledo
Programa: diferencia entre dos instantes de tiempos
*/

#include <iostream>
using namespace std;

//Inicio del programa principal

int main()
{
    int horas1, minutos1, horas2, minutos2, diferenciah, diferenciamin;

    cout << "Programa para calcular la diferencia entre dos instantes de tiempo." << endl;
    cout << "Introduzca el primer instante: ";
    cin >> horas1 >> minutos1;

    cout << "Introduzca el segundo instante: ";
    cin >> horas2 >> minutos2;

    diferenciah = (((horas2*3600)+(minutos2*60))-((horas1*3600)+(minutos1*60)))/3600;
    diferenciamin = ((((horas2*3600)+(minutos2*60))-((horas1*3600)+(minutos1*60)))/60)-(60*diferenciah);

    cout << "La diferencia entre ambos instantes es de: " << diferenciah << " h y " << diferenciamin << " min." <<endl;
    return 0;
}
