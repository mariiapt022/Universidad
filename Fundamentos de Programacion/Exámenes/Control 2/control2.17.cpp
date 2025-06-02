//Control 2. Ejercicio 17

#include <iostream>
#include <array>
using namespace std;
const int MAX=50;
typedef array <int,MAX> TVector;

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

void leerDatos(TArray& v, int& num, int& base){
    cout<<"Introduzca un numero natural en base 10: ";
    cin>>num;

    do{
        cout<<"Introduzca la base a la q desea convertirlo: ";
        cin>>base;
    }while(base<2||base>10);
}

void conversion(TArray& v, int num, int base){
    int cociente,i=0,copia;
    copia=num;

    while(cociente!=0){
        cociente=copia/base;
        v.datos[i]=copia%base;
        copia=cociente;
        i++;
    }

    v.num=i;
    cout<<"0 ";
    for(int j=i-1;j>=0;j--){
        cout<<v.datos[j]<<" ";
    }

}

int main(){
    TArray v;
    int num,base;

    aCero(v);
    leerDatos(v,num,base);
    conversion(v,num,base);

    return 0;

}









