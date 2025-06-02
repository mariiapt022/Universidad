//Ejercicio 5. Práctica 7

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array<int,MAX>TVector;
typedef array<bool,MAX>TBool;

void Rellenar (TBool& a) {
    for (int i:a) {
        a[i]=true;
    }
}

void Leerdatos (TVector& v1) {
    cout << "Introduzca una sucesion de " << MAX << " numeros naturales: ";
    for (int i=0;i<MAX;i++) {
        cin >> v1[i];
        if (v1[i]<=0) {
            cout << "ERROR: Numero no natural";
        }
    }
}

int CONT(TVector& v1,int x) {
    int cont=0;
    for (int j=0;j<MAX;j++) {
        if (x==v1[j]) {
            cont++;
        }
    }
    return cont;
}

int MAYOR (const TVector& v1, TBool& a) {
    int x=v1[0];
    for (int i=0;i<MAX;i++) {
        if ((v1[i]>x)&&(a[i]==true)) {
            x=v1[i];
            //cout << x  << "   " << i+1 << endl << endl << endl;
        }
    }
    return x;
}

void Secuencia1 (TVector& v1, TBool& a) {
    int k=0;
    while (k<MAX) {
     int cont;
     int x=MAYOR(v1,a);
     for (int i=0;i<MAX;i++) {
        if ((x==v1[i])&&(a[i]==false)) {
            cont=CONT(v1,x);
        }
     }
     cout << x;
     for (int i=0;i<MAX;i++) {
        if (x==v1[i]) {
            a[i]=false;
        }
     }
     if (cont>1) {
     cout << " aparece " << cont << " veces, en posiciones ";
     } else {
         cout << " se repite " << cont << " vez, en posicion ";
     }
     for (int i=0;i<MAX;i++) {
        if (x==v1[i]) {
            cout << i+1 << " ";
        }
     }
     cout << ".";
     cout << endl;
     k+=cont;
}
}



int main()
{
    TVector v1;
    TBool a;
    Rellenar (a);
    Leerdatos(v1);
    Secuencia1(v1,a);

    return 0;
}
