/* Ejercicio 4 de la Práctica 6 de Laboratorio
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
     num = -1;
     do {
     v1[num]++;
      cin >> num;
      } while(num >= 0);
}

int Saber_Mayor (const TDigitos& v1) {
    int mayor = v1[0];
    for (int i=1;i<MAX;i++) {
        if (v1[i]> mayor) {
            mayor = v1[i];
        }
    }
    return mayor;
}

void Secuencia2 (TDigitos& v1, int mayor) {
    int x=mayor;
    for(int i=0;i<mayor;i++){
       for(int j=0;j<MAX;j++){
          if(v1[j] == x){
           cout << "*  ";
            v1[j] = v1[j]-1;
            } else {
            cout << "   ";
            }
         }
         x = Saber_Mayor(v1);
      cout << endl;
    }
      cout << "0  1  2  3  4  5  6  7  8  9";
}


int main()
{
    TDigitos v1;
    int num,mayor;
    Secuencia1 (v1);
    Leerdatos (v1,num);
    mayor=Saber_Mayor (v1);
    Secuencia2 (v1,mayor);

    return 0;
}
