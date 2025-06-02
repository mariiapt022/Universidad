//Examen 6. Ejercicio 2
#include <iostream>
#include <array>
using namespace std;
const int TAM1=11;
const int TAM2=4;
typedef array <int,TAM1>TNumeros;
typedef array <int,TAM2>TPermutacion;

void leerDatos(TNumeros& n,TPermutacion& p){
    cout<<"Introduzca "<<TAM2<<" numeros naturales (permutacion): ";
    for(int i=0;i<TAM2;i++){
        cin>>p[i];
    }
    cout<<"Introduzca "<<TAM1<<" numeros naturales (numeros): ";
    for(int j=0;j<TAM1;j++){
        cin>>n[j];
    }
}

int frecuenciaN(const TNumeros& n,const int num,int pos){
    int cont=0;
    for(int i=pos;i<TAM2+pos;i++){
        if(n[i]==num){
            cont++;
        }
    }
    return cont;
}

int frecuenciaP(const TPermutacion& p,const int num){
    int cont=0;
    for(int i=0;i<TAM2;i++){
        if(p[i]==num){
            cont++;
        }
    }
    return cont;
}

bool cumplePermutacion(const TNumeros& n,const TPermutacion& p,const int pos){
    int frecp,frecn,i=pos;
    bool cumple=true;
    while(i<TAM2+pos&&cumple){
        frecp=frecuenciaP(p,n[i]);
        frecn=frecuenciaN(n,n[i],pos);
        if(frecn!=frecp){
            cumple=false;
        }
        i++;
    }
    return cumple;
}

int numOcurrencias(const TNumeros& n,const TPermutacion& p){
    int cont=0;
    for(int i=0;i<TAM1;i++){
        if(cumplePermutacion(n,p,i)){
            cont++;
        }
    }
    return cont;

}

int main(){
    TNumeros n;
    TPermutacion p;
    int ocurrencias;

    leerDatos(n,p);
    ocurrencias=numOcurrencias(n,p);
    cout<<"La cantidad de ocurrencias es de: "<<ocurrencias<<".";
    return 0;
}


















