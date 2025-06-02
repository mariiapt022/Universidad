//María Peinado Toledo
//Relación 3. Ejercicio 10. 07/12/2020

#include<iostream>
#include<array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> Tlista;


void leerDatos(Tlista&v, int& rep, int& num){

    cout<<"Cuantos numeros desea introducir (maximo 10): ";
    cin>>num;

    cout<<"Introduzca "<<num<<" numeros: ";
    for(int i=0;i<num;i++){
        cin>>v[i];
    }

    cout<<"Introduzca el numero de repeticiones para realizar la criba: ";
    cin>>rep;
}

int numeroVeces(const Tlista& lista1, int num,int elem){
    int cont=0;
    for(int i=0; i<num;i++){
        if(lista1[i]==elem){
            cont++;
        }
    }
    return cont;
}
bool estaEn(const Tlista& lista1, int num,int elem){
    bool encontrado=false;
    int i=0;
    while (i<num && encontrado==false){
        if (lista1[i]==elem){
            encontrado=true;
        }else{
            i++;
        }
    }
    return encontrado;
}
void criba(const Tlista& lista1, int x, Tlista& lista2, int num, int &contelementos)
{
    contelementos=0;
    for(int i=0; i<num;i++){
        if((!estaEn(lista2,contelementos,lista1[i]) && (numeroVeces(lista1,num,lista1[i])==x))){
            lista2[contelementos]=lista1[i];
            contelementos++;
            }
    }

}

void mostrar(const Tlista&v2, int n)
{
    for(int i=0;i<n;i++){
        cout<<v2[i]<<" ";
    }
}

int main()
{
    Tlista v1, v2;
    int x, num, n;
    leerDatos(v1,x,num);
    criba(v1,x,v2, num, n);
    mostrar(v2,n);

    return 0;

}



























