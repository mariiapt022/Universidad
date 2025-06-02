//Control 2. Ejercicio 20

#include<iostream>
#include<array>
using namespace std;
const int DIAS=31;
typedef array <int,DIAS> TVector;


void aCero(TVector& v){
    for(int i=0;i<DIAS;i++){
        v[i]=0;
    }
}

void frecuencia(TVector& v){
    int dia;
    cin>>dia;
    while(dia!=0){
        for(int i=1;i<=31;i++){
            if(i==dia){
                v[i]++;
            }
        }
        cin>>dia;
    }
}


int main(){
    TVector v;
    aCero(v);
    int alumnos,cont;
    cout<<"Introduzca el numero de alumnos: ";
    cin>>alumnos;

    for(int i=1;i<=alumnos;i++){
        cout<<"Introduzca dias alumno "<<i<<": ";
        frecuencia(v);
    }

    for(int k=0;k<DIAS;k++){
        if(v[k]==alumnos){
            cont++;
        }
    }

    if(cont==0){
        cout<<"No hay dias comunes.";
    }else{
        cout<<"Los dias comunes son: ";

        for(int j=0;j<DIAS;j++){
            if(v[j]==alumnos){
                cout<<j<<" ";
            }
        }

    }


    return 0;
}

//Prueba 3 5 7 15 20 0










