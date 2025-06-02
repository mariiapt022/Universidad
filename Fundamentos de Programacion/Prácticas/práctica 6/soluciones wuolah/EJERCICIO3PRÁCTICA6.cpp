/* Ejercicio 3 de la Práctica 6 de Laboratorio
   autor: Jesús Escudero Moreno
*/

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array<int,MAX>TDigitos;

void Secuencia1 (TDigitos& v1) {
    for (int i=0;i<MAX;i++) {
        v1[i]=0;
    }
}

void Leerdatos (TDigitos& v1,int num) {
    cout << "Introduzca una secuencia de digitos (negativo termina): " << endl;
    do {
        cin >> num;
         for(int i=0; i<MAX; i++){
        if (num == i){
        v1[i]++;
        }
         }
    } while (num >= 0);
    cout << "La frecuencia de cada digito es: " << endl;
    cout << "0: " << v1[0] << endl;
    cout << "1: " << v1[1] << endl;
    cout << "2: " << v1[2] << endl;
    cout << "3: " << v1[3] << endl;
    cout << "4: " << v1[4] << endl;
    cout << "5: " << v1[5] << endl;
    cout << "6: " << v1[6] << endl;
    cout << "7: " << v1[7] << endl;
    cout << "8: " << v1[8] << endl;
    cout << "9: " << v1[9] << endl;

}


int main()
{
    TDigitos v1;
    int num;
    Secuencia1 (v1);
    Leerdatos (v1,num);

    return 0;
}
