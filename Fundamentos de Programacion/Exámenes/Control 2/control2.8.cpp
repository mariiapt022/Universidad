//Control 2. Ejercicio 8

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TArray;

struct TLista{
    TArray valores;
    int numVal;
};

bool esta(int valor, const TLista& lista) {
    int i = 0;

    while (i < lista.numVal && valor != lista.valores[i]) {
        i++;
    }

    return i < lista.numVal;
}

void leer(TLista& lista, int numLista) {
    int valor;

    cout << "Introduzca Lista " << numLista << ": ";
    lista.numVal = 0;
    cin >> valor;
    while (valor != 0 && lista.numVal < MAX) {
        if (!esta(valor,lista)) {
            lista.valores[lista.numVal] = valor;
            lista.numVal++;
        }
        if (lista.numVal < MAX) {
            cin >> valor;
        }
    }
}

void escribir(const TLista& lista, unsigned numLista) {
    cout << "Lista " << numLista << ": ";
    for (unsigned i = 0; i < lista.numVal; i++) {
        cout << lista.valores[i] << " ";
    }
    cout << endl;
}

void mostrarTrios(const TLista& lista1, const TLista& lista2,
                  const TLista& lista3) {
    cout << "Los trios de numeros son:\n";

    for (unsigned i1 = 0; i1 < lista1.numVal; i1++) {
        for (unsigned i2 = 0; i2 < lista2.numVal; i2++) {
            if (esta(lista1.valores[i1]+lista2.valores[i2],
                     lista3)) {
                cout << lista1.valores[i1] << " "
                     << lista2.valores[i2] << " "
                     << lista1.valores[i1]+lista2.valores[i2]
                     << endl;
            }
        }
    }
}

int main() {
    TLista lista1, lista2, lista3;

    leer(lista1,1);
    leer(lista2,2);
    leer(lista3,3);

    escribir(lista1,1);
    escribir(lista2,2);
    escribir(lista3,3);

    mostrarTrios(lista1,lista2,lista3);

    return 0;
}
