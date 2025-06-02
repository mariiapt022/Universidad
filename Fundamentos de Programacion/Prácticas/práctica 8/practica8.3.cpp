//María Peinado Toledo
//Práctica 8. Ejercicio 3. 25/01/2021
#include <iostream>
#include <string>
#include <array>
using namespace std;
const int MAX_ALUMNOS=20;
const int N_EVALUACIONES=3;

typedef array <double,N_EVALUACIONES>TNotas;
struct TAlumno{
    string nombre;
    TNotas nota;
};
typedef array <TAlumno,MAX_ALUMNOS>TAlumnos;
struct TClase{
    TAlumnos alum;
    int num;
    TNotas nmed;
};

void leerDatos(TClase& v){
    do{
    cout<<"Introduzca el numero de alumnos: ";
    cin>>v.num;
    }while(v.num>MAX_ALUMNOS||v.num<1);

    for(int i=0;i<v.num;i++){
        cout<<"Introduzca el nombre y "<<N_EVALUACIONES<<" evaluaciones: ";
        cin>>v.alum[i].nombre;
        for(int j=0;j<N_EVALUACIONES;j++){
            cin>>v.alum[i].nota[j];
        }
    }
}

void calcularMedia(TClase& v){
    double media;
    double total=0;
    for(int i=0;i<N_EVALUACIONES;i++){
        for(int j=0;j<v.num;j++){
           total=total+v.alum[j].nota[i];
        }
        media=total/v.num;
        v.nmed[i]=media;
        total=0;
    }
}

int main(){
    TClase v;

    leerDatos(v);
    calcularMedia(v);
    for(int i=0;i<v.num;i++){
        cout<<v.alum[i].nombre<<": ";
        for(int j=0;j<N_EVALUACIONES;j++){
            if(v.alum[i].nota[j]>=v.nmed[j]){
                cout<<"Aprobado, ";
            }else{
                cout<<"Suspenso, ";
            }
        }
        cout<<endl;
    }

    return 0;
}

