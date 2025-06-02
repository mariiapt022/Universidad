//Examen 6. Ejercicio 1.
#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef int TFila[MAX];
typedef TFila TArrayBid[MAX];
struct TMatriz{
    TArrayBid datos;
    int nFil,nCol;
};

void leerDatos(TMatriz& a,TMatriz& b){
    cout<<"MATRIZ A: "<<endl;
    cout<<"Introduzca la dimension: ";
    cin>>a.nFil>>a.nCol;
    cout<<"Introduzca la matriz A: "<<endl;
    for(int i=0;i<a.nFil;i++){
        for(int j=0;j<a.nCol;j++){
            cin>>a.datos[i][j];
        }
    }

    cout<<"MATRIZ B: "<<endl;
    cout<<"Introduzca la dimension: ";
    cin>>b.nFil>>b.nCol;
    cout<<"Introduzca la matriz B: "<<endl;
    for(int k=0;k<b.nFil;k++){
        for(int z=0;z<b.nCol;z++){
            cin>>b.datos[k][z];
        }
    }
}


int suma(TMatriz& a,TMatriz& b,int fila,int columna){
    int suma=0;

    for(int i=0;i<a.nCol;i++){
        suma= suma + (a.datos[fila][i]*b.datos[i][columna]);
    }

    return suma;

}

void multiplicar(TMatriz& a,TMatriz& b,TMatriz& c){

    c.nFil=a.nFil;
    c.nCol=b.nCol;

    for(int i=0;i<c.nFil;i++){
        for(int j=0;j<c.nCol;j++){
            c.datos[i][j]=suma(a,b,i,j);
        }
    }

}

void mostrar(TMatriz& c){
    cout<<"MATRIZ C: "<<endl;

    for(int i=0;i<c.nFil;i++){
        for(int j=0;j<c.nCol;j++){
            cout<<c.datos[i][j]<<" ";
        }
        cout<<endl;
    }
}

int main(){
    TMatriz a,b,c;

    leerDatos(a,b);

    if(a.nFil==b.nCol){
        multiplicar(a,b,c);
        mostrar(c);
    }else{
        cout<<"No se pueden multiplicar.";
    }



    return 0;
}


/*

2 0 1
3 0 0
5 1 1


*/

