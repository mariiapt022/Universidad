//Examen 3. Ejercicio 1

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array<int,MAX>TVector;

struct TNumeros{
    TVector datos;
    int num;
};

void aCero(TNumeros& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
    v.num=0;
}

void leerDatos(TNumeros& v){
    int valor,i=0;

    cout<<"Introduzca una secuencia de enteros positivos acabada en 0: ";
    cin>>valor;
    while(valor!=0){
        v.datos[i]=valor;
        v.num++;
        i++;
        cin>>valor;
    }
}

bool esPerfecto(int num){
    int suma=0;
    for(int i=1;i<num;i++){
        if(num%i==0){
            suma=suma+i;
        }
    }

    return suma==num;
}

void mayorPerfecto(TNumeros& v){
    int mp=0;
    for(int i=0;i<v.num;i++){
        if(esPerfecto(v.datos[i])&&v.datos[i]>mp){
            mp=v.datos[i];
        }
    }
    if(mp==0){
        cout<<"No hay ningun numero perfecto en la secuencia.";
    }else{
        cout<<"El mayor numero perfecto de la secuencia es: "<<mp;
    }
}

int main(){
    TNumeros v;
    aCero(v);
    leerDatos(v);
    mayorPerfecto(v);
    return 0;
}

/*Prueba
2 12 6 15 28 42 9 0
1 2 15 8 25 36 9 0
*/









