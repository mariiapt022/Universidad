//Examen 13. Ejercicio 2
#include <iostream>
#include <array>
using namespace std;
const int M=7;
const int N=12;
typedef array <char,N>TFilas;
typedef array <TFilas,M>TMatriz;

void leerDatos(TMatriz& m){
    cout<<"Introduzca una Matriz "<<M<<"x"<<N<<": "<<endl;
    for(int i=0;i<M;i++){
        for(int j=0;j<N;j++){
            cin.get(m[i][j]);
        }
    }
}

int primeraCol(TMatriz& m){
    int col1,i=0,j=0;
    bool ya=false;
    while(!ya&&i<N){
        while(j<M&&!ya){
            if(m[j][i]=='*'){
                col1=i;
                ya=true;
            }
            j++;
        }
        j=0;
        i++;
    }

    return col1;
}

int ultimaCol(TMatriz& m){
    int col2,i=N,j=0;
    bool ya=false;
    while(!ya&&i>0){
        while(j<M&&!ya){
            if(m[j][i]=='*'){
                col2=i;
                ya=true;
            }
            j++;
        }
        j=0;
        i--;
    }

    return col2;
}

int calcularDiametro(TMatriz& m){
    int col1,col2,diametro;
    col1=primeraCol(m);
    col2=ultimaCol(m);

    diametro=col2-col1-2;
    return diametro;
}

int main(){
    TMatriz m;
    int diam;
    leerDatos(m);
    diam=calcularDiametro(m);
    cout<<"El diametro es: "<<diam;
    return 0;
}

/*
CIRCUNFERENCIA 1:

  **
 *  *
*    *
*    *
 *  *
  **

*/
