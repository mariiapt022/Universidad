//María Peinado Toledo
//Relación 3. Ejercicio 8. 14/12/2020

#include<iostream>
#include<array>
using namespace std;
const int DIAS=31;
typedef array <int,DIAS> TFrec;

void inicializar (TFrec& frec){
    for(int i=0;i<DIAS;i++){
        frec[i]=0;
    }
}

void actualizar (TFrec& diasComunes){
    int dia;

    cin>>dia;
    while(dia!=0){
        if((1<=dia)&&(dia<=DIAS)){
            diasComunes[dia-1]++;
        }
        cin>>dia;
    }
}


int main(){
    TFrec diasComunes;
    int alumnos;

    inicializar(diasComunes);

    cout<<"¿Cuantos alumnos va a introducir?: ";
    cin>>alumnos;

    for(int i=0;i<alumnos;i++){
        cout<<"Introduzca los dias preferidos por el alumno "<<i+1<<" (introduzca un 0 para terminar): "<<endl;
        actualizar(diasComunes);
    }

    cout<<"Los dias comunes son: ";
    for(int i=0;i<DIAS;i++){
        if(diasComunes[i]==alumnos){
            cout<<i+1<<" ";
        }
    }

    return 0;

}
