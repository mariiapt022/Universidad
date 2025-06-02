//Control 2. Ejercicio 3

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TConjuntoA;
typedef array <int,MAX> TConjuntoB;
typedef array <int,MAX> TUnion;

struct TDatos{
    TConjuntoA conjA;
    TConjuntoB conjB;
    TUnion unionAB;
    int numA,numB;
};

void inicializar(TDatos& d){
    for(int i=0;i<MAX;i++){
        d.conjA[i]=0;
        d.conjB[i]=0;
    }
}


void leerDatos(TDatos& d){
    cout<<"Primer conjunto: "<<endl;
    cout<<"Introduzca el numero de elementos a leer (<=10): ";
    cin>>d.numA;
    cout<<"Introduzca "<<d.numA<<" numeros naturales diferentes: ";
    for(int i=0;i<d.numA;i++){
        cin>>d.conjA[i];
    }

    cout<<"Segundo conjunto: "<<endl;
    cout<<"Introduzca el numero de elementos a leer (<=10): ";
    cin>>d.numB;
    cout<<"Introduzca "<<d.numB<<" numeros naturales diferentes: ";
    for(int j=0;j<d.numB;j++){
        cin>>d.conjB[j];
    }
}

int encontrarMax(const TDatos& d){
    int maxA=d.conjA[0] , maxB=d.conjB[0], maximo;

    for(int i=0;i<d.numA;i++){
        if(d.conjA[i]>maxA){
            maxA=d.conjA[i];
        }
    }
    for(int j=0;j<d.numB;j++){
        if(d.conjB[j]>maxB){
            maxB=d.conjB[j];
        }
    }

    if(maxB>maxA){
        maximo=maxB;
    }else{
        maximo=maxB;
    }

    return maximo;
}

void interseccion(TDatos& d, int maximo){

    bool perteneceA=false,perteneceB=false;

    for(int i=0;i<=maximo;i++){

        for(int j=0;j<d.numA;j++){
            if(d.conjA[j]==i){
                perteneceA=true;
            }
        }

        for(int k=0;k<d.numB;k++){
            if(d.conjB[k]==i){
                perteneceB=true;
            }
        }

        if(perteneceA && perteneceB){
            cout<<i<<" ";

        }

        perteneceA=false;
        perteneceB=false;

    }
}


void unionn(TDatos& d, int maximo){

    bool perteneceA=false,perteneceB=false;
    int numAB=0;

    //Numeros distintos

    for(int i=0;i<=maximo;i++){

        for(int j=0;j<d.numA;j++){
            if(d.conjA[j]==i){
                perteneceA=true;
            }
        }

        for(int k=0;k<d.numB;k++){
            if(d.conjB[k]==i){
                perteneceB=true;
            }
        }

        if(perteneceA || perteneceB){
            numAB++;
            perteneceA=false;
            perteneceB=false;
        }

    }

    if(numAB>10){
        cout<<"La Union no se ha podido realizar.";
    }else{

        for(int i=0;i<=maximo;i++){

        for(int j=0;j<d.numA;j++){
            if(d.conjA[j]==i){
                perteneceA=true;
            }
        }

        for(int k=0;k<d.numB;k++){
            if(d.conjB[k]==i){
                perteneceB=true;
            }
        }

        if(perteneceA || perteneceB){
            cout<<i<<" ";
            perteneceA=false;
            perteneceB=false;
        }

        }

    }

}


int main(){
    TDatos d;
    int maximo;

    inicializar(d);
    leerDatos(d);
    maximo=encontrarMax(d);
    cout<<"Interseccion: "<<endl;
    interseccion(d,maximo);

    cout<<endl;

    cout<<"Union: "<<endl;
    unionn(d,maximo);



    return 0;

}













