#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_ALUMNOS=20;
const int N_EVALUACIONES=3;
typedef array<double,N_EVALUACIONES>TNotas;
struct TDatos {
    string nom;
    TNotas nota;
};
typedef array<TDatos,MAX_ALUMNOS>TAlumno;
struct TAlumnos {
    int num;
    TAlumno al;
};
typedef array<string,N_EVALUACIONES+1>TFilaa;
typedef array<TFilaa,MAX_ALUMNOS>TMatriz;

void Leerdatos (TAlumnos& a) {
    do {
        cout << "Introduce el numero de alumnos: ";
         cin >> a.num;
    } while (a.num>MAX_ALUMNOS);
    for (int i=0;i<a.num;i++){
        cout << "Introduce el nombre y " << N_EVALUACIONES << " notas: ";
        cin >> a.al[i].nom;
        for (int j=0;j<N_EVALUACIONES;j++){
            cin >> a.al[i].nota[j];
        }
    }
}

double MEDIA(const TAlumnos& a, int k){
    double med;
    double total=0;
       for (int i=0;i<N_EVALUACIONES;i++){
        total+=a.al[i].nota[k];
       }
       med=total/N_EVALUACIONES;
       return med;
}

void Media(const TAlumnos& a, TNotas& b){
    for (int i=0;i<N_EVALUACIONES;i++){
        b[i]=MEDIA(a,i);
    }
}

void Secuencia (const TAlumnos& a, const TNotas& b, TMatriz& m){
    for (int i=0;i<a.num;i++){
        for (int j=0;j<N_EVALUACIONES+1;j++){
                if (j==0){
                   m[i][j]=a.al[i].nom;
                } else {
                    if (a.al[i].nota[j-1]>=b[j-1]){
                        m[i][j]="Aprobado";
                    } else {
                        m[i][j]="Suspenso";
                    }
                }
           }
    }
     cout << "Alumno       Nota-1       Nota-2       Nota-3 " << endl << "--------------------------------------------------- " << endl;
    for (int i=0;i<a.num;i++) {
        for (int j=0;j<N_EVALUACIONES+1;j++){
            cout << m[i][j] << "       ";
        }
        cout << endl;
    }
}


int main()
{
    TAlumnos a;
    TNotas b;
    TMatriz m;
    Leerdatos(a);
    Media(a,b);
    Secuencia(a,b,m);

    return 0;
}
