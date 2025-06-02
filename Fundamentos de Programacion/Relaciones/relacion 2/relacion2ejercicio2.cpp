//Mar�a Peinado Toledo
//Relaci�n 2. Ejercicio 2. 18/11/2020

#include <iostream>
using namespace std;

int leerDatos(){
    int valor;

    do{
        cout<<"Introduzca la altura de la piramide: ";
        cin>>valor;
    }while(valor<=0);

    return valor;
}

//Tambi�n se podr�a hacer as�:
/*
void leerDatos(int& valor){
    do{
        cout<<"Introduzca la altura de la piramide: ";
        cin>>valor;
    }while(valor<=0)
}
*/

void dibujaBlancos(int num){
    for(int i=1; i<=num; i++){
        cout<<" ";
    }
}

void dibujaAsteriscos(int num){
    for(int i=1; i<=num; i++){
        cout<<"* ";
    }
}

int main()
{
    int n;
    n=leerDatos();

    for(int fila=1; fila<=n; fila++){
        dibujaBlancos(n-fila);
        dibujaAsteriscos(fila);
        cout<<endl;
    }
    return 0;
}
