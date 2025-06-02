//Control 2. Ejercicio 13

#include <iostream>
#include <array>
using namespace std;
const int MAX=100;
typedef array <int,MAX> TArray;

struct TNumeros{
    TArray numeros;
    int tam;
};

void aCero(TNumeros& v){
    for(int i=0;i<MAX;i++){
        v.numeros[i]=0;
    }
    v.tam=0;
}
void leerDatos(TNumeros& v,int& M, int& MAX_REP){
    int i=0,valor;

    do{
        cout<<"Introduzca el valor de M: ";
        cin>>M;
    }while(M<0||M>MAX);

    cout<<"Introduzca el numero maximo de repeticiones de un numero: ";
    cin>>MAX_REP;

    cout<<"Introduzca una secuencia de numeros acabada en 0: ";
    cin>>valor;
    while(valor!=0){
        v.numeros[i]=valor;
        v.tam++;
        i++;
        cin>>valor;
    }

}

bool sePuede(TNumeros& v, int MAX_REP){
    int cont=0,valor;
    bool si=false;

    for(int i=0;i<v.tam;i++){
        valor=v.numeros[i];
        si=false;
        for(int j=0;j<v.tam;j++){
            if(valor==v.numeros[j]){
                cont++;
            }
            if(cont<=MAX_REP){
                    si=true;
            }
        }
        cont=0;
    }

    return si;

}

void mayores(TNumeros& v,int M){
    int mayor=v.numeros[0], cont=0;
    cout<<"Los "<<M<<" mayores y sus posiciones son: "<<endl;

    while(cont<M){
        for(int i=0;i<v.tam;i++){
            if(v.numeros[i]>mayor){
                mayor=v.numeros[i];
            }
        }

        cout<<mayor<<": ";

        for(int j=0;j<v.tam;j++){
            if(v.numeros[j]==mayor){
                cout<<j<<" ";
                v.numeros[j]=0;
            }
        }
        cout<<endl;
        mayor=v.numeros[0];
        cont++;
    }

}

int main(){
    TNumeros v;
    int M,MAX_REP;

    aCero(v);
    leerDatos(v,M,MAX_REP);
    if(sePuede(v,MAX_REP)){
        mayores(v,M);
    }else{
        cout<<"Hay numeros que se repiten mas de lo permitido.";
    }

    return 0;

}

//Prueba 2 3 4 7 28 4 5 1 1 1 9 7 4 4 28 2 1 3 3 6 0













