//Examen 11. Ejercicio 2.
#include <iostream>
#include <array>
using namespace std;
const int TAM=10;
typedef array <int,TAM>TVector;
struct TLista{
    TVector datos;
    int num;
};

bool esta(const TLista& lista,const int x){
    int i=0;
    while(i<lista.num&&lista.datos[i]!=x){
        i++;
    }
    return i<lista.num;
}

void leerDatos(TLista& lista1,TLista& lista2,TLista& lista3){
    int num;
    lista1.num=0;
    lista2.num=0;
    lista3.num=0;

    cout<<"Introduzca Lista 1: ";
    cin>>num;
    while(num!=0&&lista1.num<TAM){
        if(!esta(lista1,num)){
            lista1.datos[lista1.num]=num;
            lista1.num++;
        }
        cin>>num;
    }

    cout<<"Introduzca Lista 2: ";
    cin>>num;
    while(num!=0&&lista2.num<TAM){
        if(!esta(lista2,num)){
            lista2.datos[lista2.num]=num;
            lista2.num++;
        }
        cin>>num;
    }

    cout<<"Introduzca Lista 3: ";
    cin>>num;
    while(num!=0&&lista3.num<TAM){
        if(!esta(lista3,num)){
            lista3.datos[lista3.num]=num;
            lista3.num++;
        }
        cin>>num;
    }

}

void escribir(TLista& lista,int numLista){
    cout<<"Lista "<<numLista<<": ";
    for(int i=0;i<lista.num;i++){
        cout<<lista.datos[i]<<" ";
    }
    cout<<endl;
}

void trios(TLista& lista1,TLista& lista2,TLista& lista3){
    int num1,num2,num3;
    cout<<"Los trios de numeros son: "<<endl;
    for(int i=0;i<lista1.num;i++){
        num1=lista1.datos[i];
        for(int j=0;j<lista2.num;j++){
            num2=lista2.datos[j];
            for(int k=0;k<lista3.num;k++){
                num3=lista3.datos[k];
                if(num1+num2==num3){
                    cout<<num1<<" "<<num2<<" "<<num3<<endl;
                }
            }
        }
    }
}

int main(){
    TLista lista1,lista2,lista3;
    leerDatos(lista1,lista2,lista3);
    escribir(lista1,1);
    escribir(lista2,2);
    escribir(lista3,3);
    trios(lista1,lista2,lista3);
    return 0;
}
