//María Peinado Toledo
//Práctica 7. Ejercicio 3. 13/01/2021

#include <iostream>
#include <array>
using namespace std;
const int N=5;
const int P=(N*N)+1;
typedef array <int,N>TFila;
typedef array <TFila,N>TMatriz;
typedef array <bool,P>TPrueba;

void aCero(TMatriz& mat,TPrueba& pr){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            mat[i][j]=0;
        }
    }
    for(int k=0;k<P;k++){
        pr[k]=true;
    }
}
void leerDatos(TMatriz& mat){
    cout<<"Introduzca por filas una matriz "<<N<<"x"<<N<<": "<<endl;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<N;co++){
            cin>>mat[fi][co];
        }
    }

}

bool numeros(TMatriz& mat,TPrueba& pr){
    int cont=0,valor;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<N;co++){
            valor=mat[fi][co];
            if(valor>=1&&valor<=N*N&&pr[valor]==true){
                cont++;
            }
            pr[valor]=false;
        }
    }
    return cont==P-1;

}

int sumaFila(const TMatriz& mat,int numFila){
    int suma=0;
    for(int co=0;co<N;co++){
        suma=suma+mat[numFila][co];
    }
    return suma;
}
int sumaColumna(const TMatriz& mat,int numColumna){
    int suma=0;
    for(int fi=0;fi<N;fi++){
        suma=suma+mat[fi][numColumna];
    }
    return suma;
}
int sumaDiagonal1(const TMatriz& mat){
    int suma=0;
    for(int fi=0;fi<N;fi++){
        for(int co=0;co<N;co++){
            if(fi==co){
                suma=suma+mat[fi][co];
            }
        }
    }
    return suma;
}
int sumaDiagonal2(const TMatriz& mat){
    int suma=0;
    for(int fi=N;fi>=0;fi--){
        for(int co=0;co<N;co++){
            if(fi==co){
                suma=suma+mat[fi][co];
            }
        }
    }
    return suma;
}

bool esMagica(TMatriz& mat){
    bool magia=true;
    int i=0,j=0,copiaFi,copiaCo,sumaDi1,sumaDi2;
    copiaFi=sumaFila(mat,0);
    copiaCo=sumaColumna(mat,0);
    sumaDi1=sumaDiagonal1(mat);
    sumaDi2=sumaDiagonal2(mat);
    if(sumaDi1!=sumaDi2){
        magia=false;
    }
    while(magia&&i<N&&j<N){
        if(copiaFi!=sumaFila(mat,i)){
            magia=false;
        }else{
            copiaFi=sumaFila(mat,i);
        }
        if(copiaCo!=sumaColumna(mat,j)){
            magia=false;
        }else{
            copiaCo=sumaColumna(mat,j);
        }
        if(copiaFi!=copiaCo){
            magia=false;
        }else if(copiaFi!=sumaDi1){
            magia=false;
        }
        i++;
        j++;
    }


    return magia;
}

int main(){
    TMatriz mat;
    TPrueba pr;
    bool no;
    aCero(mat,pr);
    leerDatos(mat);
    no=numeros(mat,pr);
    if(no&&esMagica(mat)){
        cout<<"La matriz SI es magica.";
    }else{
        cout<<"La matriz NO es magica.";
    }

    return 0;

}

/*Prueba
15 8 1 24 17
16 14 7 5 23
22 20 13 6 4
3 21 19 12 10
9 2 25 18 11
*/


