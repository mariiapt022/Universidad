//María Peinado Toledo
//Práctica 4. Ejercicio 5. 26/11/2020

#include <iostream>
using namespace std;

int leerAltura(int& h){

    do{
        cout<<"Introduzca un numero (N>0): ";
        cin>>h;
    }while(h<=0);

    return h;

}

void escribirBlanco(int num){
    for(int i=0;i<num;i++){
        cout<<" ";
    }
}

void escribirNumeros(int num){
    int contador=0,copia=num;
    while(contador<num){
        if(copia>=10){
            copia%=10;
        }
        cout<<copia;
        copia++;
        contador++;
    }
    copia=copia-2;
    contador=0;
    while(contador<num-1){
        if(copia<=-1){
            copia+=10;
        }
        cout<<copia;
        copia--;
        contador++;
    }
}

int main(){
    int h;
    h=leerAltura(h);

    for(int fila=1;fila<=h;fila++){
    escribirBlanco(h-fila);
    escribirNumeros(fila);
    cout<<endl;
    }
    return 0;
}
