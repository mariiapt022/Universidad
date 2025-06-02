//Examen 3. Ejercicio 3

#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX=10;

struct TPersona{
    string nombre;
    int gastos=0;
    int resul;
};

typedef array<TPersona,MAX>TPersonas;

struct TDatos{
    TPersonas persona;
    int npers=0;
};

bool esta(TDatos& v,string& nombre){
    int i=0;
    while(i<v.npers&&v.persona[i].nombre!=nombre){
        i++;
    }
    return i<v.npers;
}

int buscarInd(const TDatos& v,string& nombre){
    int ind=0;
    while(ind<v.npers&&v.persona[ind].nombre!=nombre){
        ind++;
    }
    return ind;
}

void leerDatos(TDatos& v,int& resultado){
    string nombre;
    int ind,dinero;
    v.npers=0;

    cout<<"Introduzca nombres, resultados y cantidades apostadas (FIN para terminar): "<<endl;
    cout<<"Nombre: ";
    cin>>nombre;
    while(nombre!="FIN"&&v.npers<MAX){
        if(!esta(v,nombre)){
            v.persona[v.npers].nombre=nombre;
            cout<<"Resultado: ";
            cin>>v.persona[v.npers].resul;
            cout<<"Cantidad: ";
            cin>>v.persona[v.npers].gastos;
            v.npers++;
        }else{
            ind=buscarInd(v,nombre);
            cout<<"Resultado: ";
            cin>>v.persona[ind].resul;
            cout<<"Cantidad: ";
            cin>>dinero;
            v.persona[ind].gastos=v.persona[ind].gastos+dinero;
        }

        cout<<"Nombre: ";
        cin>>nombre;

    }

    cout<<"Introduzca el resultado final de la apuesta: ";
    cin>>resultado;
}

int totalApostado(const TDatos& v){
    int suma=0;
    for(int i=0;i<v.npers;i++){
        suma=suma+v.persona[i].gastos;
    }
    return suma;
}

int totalGanador(const TDatos& v,int resultado){
    int suma=0;
    for(int i=0;i<v.npers;i++){
        if(v.persona[i].resul==resultado){
            suma=suma+v.persona[i].gastos;
        }
    }
    return suma;
}

int calcularRatio(const TDatos& v,int ta,int tg){
    int radio=ta/tg;
    return radio;
}

void calcularResultados(TDatos& v, int resultado){
    int ta,tg,dinero,rt;
    for(int i=0;i<v.npers;i++){
        cout<<v.persona[i].nombre<<" "<<v.persona[i].resul<<" "<<v.persona[i].gastos;
        cout<<endl;
    }

    ta=totalApostado(v);
    tg=totalGanador(v,resultado);
    rt=calcularRatio(v,ta,tg);
    cout<<"Total apostado: "<<ta<<endl;
    cout<<"Total ganador: "<<tg<<endl;


    for(int j=0;j<v.npers;j++){
        cout<<v.persona[j].nombre<<" "<<v.persona[j].resul<<" "<<v.persona[j].gastos<<"->";
        if(v.persona[j].resul==resultado){
            dinero=v.persona[j].gastos*rt;
            cout<<dinero;
        }else{
            cout<<"0";
        }
        cout<<endl;
    }

}

int main(){
    TDatos v;
    int resultado;
    leerDatos(v,resultado);
    cout<<endl;
    calcularResultados(v,resultado);
    return 0;
}




















