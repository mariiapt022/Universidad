/* Ejercicio 2 de la Práctica 6 de Laboratorio
   autor: Jesús Escudero Moreno
*/

   #include <iostream>
   #include <array>
   using namespace std;
   const int MAX=50;
   typedef array<int,MAX>TArray;
   struct TEstaturas {
       int num;
       TArray alturas;
};


void Leer (TEstaturas& v1) {
    do {
        cout << "Cuantas estaturas va a introducir (maximo 50): ";
        cin >> v1.num;
    } while (v1.num > MAX);
    cout << "Introduzca las " << v1.num << " estaturas: ";
    for (int i=0;i<v1.num;i++) {
        cin >> v1.alturas[i];
    }
}

float Media (const TEstaturas& v1) {
    float total,x;
    for (int i=0;i<v1.num;i++) {
        total+=v1.alturas[i];
    }
    x=total/v1.num;
    cout << "La media es: " << x << endl;
    return x;
}

int MAS (const TEstaturas& v1,float med) {
    int x=0;
    cout << "Numero de alumnos mas altos que la media: ";
    for (int i=0;i<v1.num;i++) {
        if (v1.alturas[i]>med) {
            x++;
        }
    }
    cout << x << endl;
}

int MENOS (const TEstaturas& v1,float med) {
    int x=0;
    cout << "Numero de alumnos mas bajos que la media: ";
    for (int i=0;i<v1.num;i++) {
        if (v1.alturas[i]<med) {
            x++;
        }
    }
    cout << x << endl;
}


int main()
{
    TEstaturas v1;
    int mas,menos;
    float med;
    Leer (v1);
    med=Media(v1);
    mas=MAS(v1,med);
    menos=MENOS(v1,med);

    return 0;
}
