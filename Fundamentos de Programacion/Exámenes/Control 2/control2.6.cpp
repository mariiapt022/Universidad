//Control 2. Ejercicio 6

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TVector;

struct TArray{
    TVector datos;
    int num;
};

void aCero(TArray& v){
    for(int i=0;i<MAX;i++){
        v.datos[i]=0;
    }
}

void leerDatos(TArray& v){
    cout<<"Introduzca el tamaño del array: ";
    cin>>v.num;

    cout<<"Introduzca "<<v.num<<" numeros enteros: ";
    for(int i=0;i<v.num;i++){
        cin>>v.datos[i];
    }
}

bool esUnico(const TArray& v, int menor){
    int cont=0;
    bool si=false;

    for(int i=0;i<v.num;i++){
        if(v.datos[i]==menor){
            cont++;
        }
    }

    if(cont>1){
        si=false;
    }else{
        si=true;
    }

    return si;
}

void menorEstricto(TArray& v){

    int menor=v.datos[0];

    for(int i=0;i<v.num;i++){
        if(v.datos[i]<menor){
            menor=v.datos[i];
        }
    }

    if(esUnico(v,menor)){
        cout<<"El menor estricto del array es: "<<menor<<".";
    }else{
        cout<<"El array no tiene menor estricto.";
    }

}

int main(){
    TArray v;

    aCero(v);
    leerDatos(v);
    menorEstricto(v);

    return 0;
}












