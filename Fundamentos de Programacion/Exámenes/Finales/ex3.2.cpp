//Examen 3. Ejercicio 2.

#include <iostream>
#include <array>
using namespace std;
const int N=4;
typedef array <int,N> TFilas;
typedef array <TFilas,N>TMatriz;

void aCero(TMatriz& mat){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            mat[i][j]=0;
        }
    }
}

void leerDatos(TMatriz& mat,int& fil, int& col){
    cout<<"Introduzca una matriz "<<N<<"x"<<N<<": "<<endl;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>mat[i][j];
        }
    }
    do{
    cout<<"Introduzca los indices de la fila y la columna: ";
    cin>>fil>>col;
    }while(fil>N||col>N);

}

void nuevaMatriz(TMatriz& mat,int fil,int col){

    cout<<"La nueva matriz "<<N-1<<"x"<<N-1<<" es: "<<endl;

    for(int i=0;i<N;i++){
        if(i!=fil){
           for(int j=0;j<N;j++){
                if(j!=col){
                   cout<<mat[i][j]<<" ";
                }
            }
           cout<<endl;
        }
    }


}

int main(){
    TMatriz mat;
    int fil,col;
    aCero(mat);
    leerDatos(mat,fil,col);
    nuevaMatriz(mat,fil,col);
    return 0;
}

/* Prueba
4 -8 32 15
12 9 -5 -8
-4 7 41 65
6 45 -8 92
*/









