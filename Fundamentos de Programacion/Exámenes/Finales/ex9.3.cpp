//Examen 9. Ejercicio 3
#include <iostream>
#include <array>
using namespace std;
const int TAM=9;
typedef array <int,TAM>TFilas;
typedef array <TFilas,TAM>TMatriz;
typedef array <int,TAM/3>TFilasR;
typedef array <TFilasR,TAM/3>TRegion;

void leerDatos(TMatriz& mat){
    cout<<"Introduzca una matriz "<<TAM<<"x"<<TAM<<": "<<endl;
    for(int i=0;i<TAM;i++){
        for(int j=0;j<TAM;j++){
            cin>>mat[i][j];
        }
    }
}

bool cumpleCasilla(const TMatriz& mat){
    bool cumple=true;
    int i=0,j=0;
    while(i<TAM&&cumple){
        while(j<TAM&&cumple){
            if(mat[i][j]<0||mat[i][j]>TAM){
                cumple=false;
            }
            j++;
        }
        i++;
        j=0;
    }
    return cumple;
}


int frecuenciaFi(const TMatriz& mat,const int fi,const int num){
    int cont=0;
    for(int i=0;i<TAM;i++){
        if(mat[fi][i]==num){
            cont++;
        }
    }
    return cont;
}
bool cumpleFila(const TMatriz& mat){
    bool cumple=true;
    int num=1,frec,fi=0;
    while(fi<TAM&&cumple){
        while(num<TAM&&cumple){
            frec=frecuenciaFi(mat,fi,num);
            if(frec>1){
                cumple=false;
            }
            num++;
        }
        num=1;
        fi++;
    }

    return cumple;
}

int frecuenciaCo(const TMatriz& mat,const int co,const int num){
    int cont=0;
    for(int i=0;i<TAM;i++){
        if(mat[i][co]==num){
            cont++;
        }
    }
    return cont;
}
bool cumpleColumna(const TMatriz& mat){
    bool cumple=true;
    int num=1,frec,co=0;
    while(co<TAM&&cumple){
        while(num<TAM&&cumple){
            frec=frecuenciaCo(mat,co,num);
            if(frec>1){
                cumple=false;
            }
            num++;
        }
        num=1;
        co++;
    }

    return cumple;
}

void construirRegion(const TMatriz& mat,TRegion& r,int num){
    int fi=0,co=0;

    if(num<3){
       for(int i=0;i<3;i++){
            for(int j=num*3;j<(num*3)+3;j++){
                r[fi][co]=mat[i][j];
                co++;
            }
            fi++;
            co=0;
        }
    }

    if(num>=3&&num<6){
        for(int i=3;i<6;i++){
            for(int j=(num-3)*3;j<(num-3)*3+3;j++){
                r[fi][co]=mat[i][j];
                co++;
            }
            fi++;
            co=0;
        }
    }

    if(num>=6){
        for(int i=6;i<TAM;i++){
            for(int j=(num-6)*3;j<(num-6)*3+3;j++){
                r[fi][co]=mat[i][j];
                co++;
            }
            fi++;
            co=0;
        }
    }

}

int frecuenciaR(const TRegion& r,const int num){
    int cont=0;
    for(int i=0;i<TAM/3;i++){
        for(int j=0;j<TAM/3;j++){
            if(r[i][j]==num){
                cont++;
            }
        }
    }
    return cont;
}
bool cumpleRegion(TRegion& r,TMatriz& mat){
    bool cumple=true;
    int num=1,frec,n=0;
    while(n<TAM){
        construirRegion(mat,r,n);
        while(num<TAM&&cumple){
            frec=frecuenciaR(r,num);
            if(frec>1){
                cumple=false;
            }
            num++;
        }
        num=1;
        n++;
    }

    return cumple;
}

int main(){
    TMatriz mat;
    TRegion r;
    bool casilla,fila,columna,region;

    leerDatos(mat);

    casilla=cumpleCasilla(mat);
    fila=cumpleFila(mat);
    columna=cumpleColumna(mat);
    region=cumpleRegion(r,mat);

    if(casilla&&fila&&columna&&region){
        cout<<"SI";
    }else{
        cout<<"NO";
    }

    return 0;

}


/*
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9
*/








