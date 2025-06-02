//María Peinado Toledo
//Práctica 6. Ejercicio 6A (Ejercicio 10 de la Tercera relación). 14/12/2020

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array<int,MAX>TArray;

struct TLista {
    int x;
    TArray lista1,lista2;
};

void Rellenar (TLista& v1) {
    for (int i=0;i<MAX;i++) {
        v1.lista2[i]=0;
    }
}

void criba (TLista& v1) {
    cout << "El contenido de lista1 es: ";
    for (int i=0;i<MAX;i++) {
       cin >> v1.lista1[i];
    }
    do {
        cout << "El valor de x es: ";
        cin >> v1.x;
    } while (v1.x<=0);
}

void Secuencia (TLista& v1) {
     int k;
     for (int i=0;i<MAX;i++) {
         k=v1.lista1[i];
         for (int j=0;j<MAX;j++) {
            if (v1.lista1[j]==k) {
                v1.lista2[i]++;
            }
        }
       for (int g=i;g<MAX;g++) {
              if ((v1.lista1[i]==v1.lista1[g])&&(i!=g)) {
                v1.lista2[i]=0;
              }
       }
     }
}

void Salida (TLista& v1) {
    cout << "El contenido de lista2 sera: ";
      for (int i=0;i<MAX;i++) {
        if (v1.lista2[i]==v1.x) {
            cout << v1.lista1[i] << " ";
        }
      }
}

int main()
{
    TLista v1;
    Rellenar (v1);
    criba (v1);
    Secuencia (v1);
    Salida (v1);

    return 0;
}
