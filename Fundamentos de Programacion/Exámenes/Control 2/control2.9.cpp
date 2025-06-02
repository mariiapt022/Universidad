//Control 2. Ejercicio 9

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TLista;

void aCero(TLista& v1,TLista& v2){
    for(int i=0;i<MAX;i++){
        v1[i]=0;
        v2[i]=0;
    }
}

void leerDatos(TLista& v, int& num, int& x){
    cout<<"Introduzca el tamaño de la lista: ";
    cin>>num;

    cout<<"Introduzca "<<num<<" numeros enteros: ";
    for(int i=0;i<num;i++){
        cin>>v[i];
    }

    cout<<"Introduzca el valor de x: ";
    cin>>x;
}

int numeroVeces(const TLista& lista1,int num, int elem){
    int cont=0;

    for(int i=0;i<num;i++){
        if(lista1[i]==elem){
            cont++;
        }
    }

    return cont;
}

bool estaEnLista2(const TLista& lista1,int pos,int elem){
    bool encontrado=false;
    int cont=1;

    for(int i=0;i<pos;i++){
        if(cont!=0&&lista1[i]==elem){
            encontrado=true;
            cont=0;
        }
    }

    return encontrado;
}

/*
void criba(const TLista& lista1,TLista& lista2, int num,int x,int& contLista2){
    contLista2=0;

    for(int i=0;i<num;i++){
        if((!estaEnLista2(lista2,contLista2,lista1[i])&&(numeroVeces(lista1,num,lista1[i])==x))){
            lista2[contLista2]=lista1[i];
            contLista2++;
        }
    }
}
*/

void criba(const TLista& lista1, int x, TLista& lista2, int num, int &contelementos)
{
    contelementos=0;
    for(int i=0; i<num;i++){
        if((!estaEnLista2(lista2,contelementos,lista1[i]) && (numeroVeces(lista1,num,lista1[i])==x))){
            lista2[contelementos]=lista1[i];
            contelementos++;
            }
    }

}

void mostrar(TLista& lista2,int num2){
    for(int i=0;i<num2;i++){
        cout<<lista2[i]<<" ";
    }
}

int main(){
    TLista lista1,lista2;
    int num,x,num2;

    aCero(lista1,lista2);
    leerDatos(lista1,num,x);
    criba(lista1,x,lista2,num,num2);
    mostrar(lista2,num2);

    return 0;
}


//Prueba 1 3 4 3 1 3 0 -6 4















