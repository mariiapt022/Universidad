//Control 2. Ejercicio 21

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX>TVector;

struct TArray{
    TVector datos;
    int num;
};

void aCero(TArray& val,TArray& ind){
    for(int i=0;i<MAX;i++){
        val.datos[i]=0;
        ind.datos[i]=0;
    }
    val.num=0;
    ind.num=0;
}

void leerDatos(TArray& val,TArray& ind){

    cout<<"Introduzca la cantidad de numeros a introducir: ";
    cin>>val.num;
    ind.num=val.num;

    cout<<"Introduzca "<<val.num<<" numeros enteros: ";
    for(int i=0;i<val.num;i++){
        cin>>val.datos[i];
    }

}

int buscarMayor(TArray& val){
    int mayor=val.datos[0];
    for(int i=0;i<val.num;i++){
        if(val.datos[i]>mayor){
            mayor=val.datos[i];
        }
    }

    return mayor;
}
int buscarMenor(TArray& val){
    int menor=val.datos[0];
    int pos=0;

    for(int i=0;i<val.num;i++){
        if(val.datos[i]<menor){
            menor=val.datos[i];
            pos=i;
        }
    }

    return pos;
}

void crearArrayInd(TArray& val,TArray& ind, int mayor){
    int pos;

    for(int i=0;i<ind.num;i++){
        pos=buscarMenor(val);
        val.datos[pos]=mayor+1;
        ind.datos[i]=pos;
    }

    cout<<"Array IND: ";
    for(int j=0;j<ind.num;j++){
        cout<<ind.datos[j]<<" ";
    }

}

int main(){
    TArray val,ind;
    int mayor;

    aCero(val,ind);
    leerDatos(val,ind);
    mayor=buscarMayor(val);
    crearArrayInd(val,ind,mayor);

    return 0;

}










