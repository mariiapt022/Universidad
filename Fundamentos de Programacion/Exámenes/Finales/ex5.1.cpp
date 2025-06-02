//Examen 5. Ejercicio 1

#include <iostream>
#include <array>
using namespace std;
const int MAX=9;
typedef array <int,MAX>TLista;


void leerDatos(TLista& v,int& x){
    cout<<"Introduzca "<<MAX<<" numeros enteros: ";
    for(int i=0;i<MAX;i++){
        cin>>v[i];
    }
    cout<<"Introduzca el valor de x: ";
    cin>>x;
}

bool esta(TLista& v,int num){
    int i=0;
    while(i<MAX&&v[i]!=num){
        i++;
    }
    return i<MAX;
}

int repeticiones(const TLista& v,const int num){
    int cont=0;
    for(int i=0;i<MAX;i++){
        if(v[i]==num){
            cont++;
        }
    }
    return cont;
}

void criba(TLista& v1,TLista& v2,int x,int& j){
    int rep;
    j=0;

    for(int i=0;i<MAX;i++){
       rep=repeticiones(v1,v1[i]);
       if(rep==x&&!esta(v2,v1[i])){
            v2[j]=v1[i];
            j++;
       }
    }
}

void mostrar(TLista& v2,int j){
    cout<<"El contenido de lista2 sera: ";
    for(int i=0;i<j;i++){
        cout<<v2[i]<<" ";
    }
}

int main(){
    TLista lista1,lista2;
    int x,j;
    leerDatos(lista1,x);
    criba(lista1,lista2,x,j);
    mostrar(lista2,j);
    return 0;
}














