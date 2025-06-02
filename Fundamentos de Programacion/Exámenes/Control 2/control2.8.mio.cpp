//Control 2. Ejercicio 8 mio

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TVector;

struct TLista{
    TVector datos;
    int num;
};

void aCero(TLista& l1,TLista& l2,TLista& l3){
    for(int i=0;i<MAX;i++){
        l1.datos[i]=0;
        l2.datos[i]=0;
        l3.datos[i]=0;
    }
    l1.num=0;
    l2.num=0;
    l3.num=0;
}

bool estaEnLista(TLista& lista, int num){
    bool encontrado=false;

    for(int i=0;i<lista.num;i++){
        if(lista.datos[i]==num){
            encontrado=true;
        }
    }

    return encontrado;
}

void leerDatos(TLista& lista, int numLista){
    int valor,j=0;

    cout<<"Introduzca la lista "<<numLista<<": ";
    cin>>valor;
    while(valor!=0&&lista.num<10){
        if(!estaEnLista(lista,valor)){
            lista.datos[j]=valor;
            j++;
            lista.num++;
        }
        cin>>valor;
    }

}

void imprimir(TLista& lista, int numLista){
    for(int i=0;i<lista.num;i++){
        cout<<lista.datos[i]<<" ";
    }
    cout<<endl;
}

void trios(TLista& l1,TLista& l2,TLista& l3){

    int valor1,valor2,valor3;

    for(int i=0;i<l1.num;i++){
            valor1=l1.datos[i];
        for(int j=0;j<l2.num;j++){
            valor2=l2.datos[j];
            for(int k=0;k<l3.num;k++){
                valor3=l3.datos[k];
                if(valor1+valor2==valor3){
                    cout<<valor1<<" "<<valor2<<" "<<valor3<<endl;
                }
            }
        }
    }

}

int main(){
    TLista l1,l2,l3;

    aCero(l1,l2,l3);
    leerDatos(l1,1);
    leerDatos(l2,2);
    leerDatos(l3,3);

    cout<<"Lista 1:";
    imprimir(l1,1);
    cout<<endl;

    cout<<"Lista 2:";
    imprimir(l2,2);
    cout<<endl;

    cout<<"Lista 3:";
    cout<<endl;

    imprimir(l3,3);

    cout<<"Los trios de numeros son: ";
    cout<<endl;
    trios(l1,l2,l3);

    return 0;

}

//Prueba 2 4 3 5 8 6 13 9 1 38 7 14 0







