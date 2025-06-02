//Control 2. Ejercicio 11

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TVector;

struct TArray{
    TVector datos;
    int num;
};

void aCero (TArray& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
}

void leerDatos(TArray& v){
    do{
    cout<<"Introduzca la cantidad de la lista (<10): ";
    cin>>v.num;
    }while(v.num<0||v.num>10);

    cout<<"Introduzca "<<v.num<<" numeros naturales: ";
    for(int i=0;i<v.num;i++){
        cin>>v.datos[i];
    }
}

bool esPrimo(int num){
    int divisor=2;
    while((divisor<num)&&(num%divisor!=0)){
        divisor++;
    }
    return (divisor >=num);
}

void encontrarPrimo (TArray& v, int& primo, int& pos){
    int cont=0;

    for(int i=0;i<v.num;i++){
        if(esPrimo(v.datos[i])&&cont==0){
            primo=v.datos[i];
            cont=1;
            pos=i;
        }
    }
}

void nuevoArray(TArray& v, int pos){
    for(int i=0;i<v.num;i++){
        if(i!=pos){
            cout<<v.datos[i]<<" ";
        }
    }
}

int main(){
    TArray v;
    int primo=0,pos=-1;

    aCero(v);
    leerDatos(v);
    encontrarPrimo(v,primo,pos);

    if(primo!=0){
        cout<<"El primer primo es el "<<primo<<" y esta en la posicion "<<pos<<endl;
        cout<<"La lista tras la eliminacion es: ";
        nuevoArray(v,primo);
    }

    return 0;
}

//Prueba 4 9 14 12 4 8 3 6 5 10










