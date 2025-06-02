//Control 2. Ejercicio 2

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TVector;

struct TArray{
    TVector datos;
    int num;
};


void aCero(TArray& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
}

void leerDatos(TArray& v){
    cout<<"Introduzca el tamaño del array: ";
    cin>>v.num;

    cout<<"Introduzca "<<v.num<<" numeros enteros: ";
    for(int i=0;i<v.num;i++){
        cin>>v.datos[i];
    }
}

bool esPrimo(int num){
    int divisor=2;
    while((divisor<num)&&(num%divisor!=0)){
        divisor++;
    }
    return (divisor>=num);
}

int mayorPrimo (const TArray& v){

  int mayor,hayprimo=0;

  for(int i=0;i<v.num;i++){
    if(esPrimo(v.datos[i])&&v.datos[i]!=0&&v.datos[i]!=1){
        hayprimo++;
        if(v.datos[i]>mayor){
            mayor=v.datos[i];
        }
    }
  }

  if(hayprimo==0){
      mayor=0;
  }

  return mayor;

}

int main(){
    TArray v;
    int mayor;

    aCero(v);
    leerDatos(v);

    mayor=mayorPrimo(v);

    if(mayor==0){
        cout<<"En el array no hay ningún primo."<<endl;
    }else{
        cout<<"El mayor primo del array es: "<<mayor<<"."<<endl;
    }

    return 0;

}


/*Prueba:
6 4 12 0 8 9 46 15 21 12

8 22 3 6 2 7 56 11 5 9

*/



















