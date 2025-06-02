//Control 2. Ejercicio 25

#include <iostream>
#include <array>
using namespace std;
const int MAX=20;
typedef array <int,MAX>TVector;

struct TArray{
    TVector datos;
    int num;
};

void aCero(TArray& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
    v.num=0;
}

void leerDatos(TArray& v){
    char letra;
    int distancia,i=0;

    cout<<"Introduzca una secuencia de letras mayusculas ('.' para terminar): ";
    cin.get(letra);
    while(letra!='.'){
        v.datos[i]=letra;
        i++;
        v.num++;
        cin.get(letra);
    }
}

int apariciones(TArray& v, int letra){
    int cont=0;
    for(int i=0;i<v.num;i++){
        if(v.datos[i]==letra){
            cont++;
        }
    }

    return cont;
}

void calcularDistancia(TArray& v){
    int dist=0,mayordist=0,siguiente,ap;

    for(int i=0;i<v.num;i++){
        siguiente=i+1;
        ap=apariciones(v,v.datos[i]);
        if(ap>1&&v.datos[i]!=0){
            while(ap>1){
                while(v.datos[siguiente]!=v.datos[i]){
                    dist++;
                    siguiente++;
                }
                if(dist>mayordist){
                    mayordist=dist;
                }
                dist=0;
                ap--;
                siguiente++;
            }
            cout<<"Distancia entre: "<<char(v.datos[i])<<": "<<mayordist<<"."<<endl;
            mayordist=0;
            dist=0;
        }
        v.datos[i]=0;

    }

}

int main(){
    TArray v;
    aCero(v);
    leerDatos(v);
    calcularDistancia(v);
    return 0;
}



//Prueba ABEADDGLAKE.







