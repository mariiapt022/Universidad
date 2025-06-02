//María Peinado Toledo
//Relación 3. Ejercicio 13. 14/12/2020

#include<iostream>
#include<array>
using namespace std;
const int RANGO_MAY=26;
typedef array <int,RANGO_MAY> TPosiciones;
typedef array <int,RANGO_MAY> TDistancias;
typedef array <bool,RANGO_MAY> TRepeticiones;

struct TDatos{
    TPosiciones pos;
    TDistancias dis;
    TRepeticiones rep;
};

void inicializar(TDatos& datos){
    for(int i=0;i<RANGO_MAY;i++){
        datos.pos[i]=0;
        datos.dis[i]=0;
        datos.rep[i]= false;
    }
}

void escribir (const TDatos& datos){
    for(int i=0;i<RANGO_MAY;i++){
        if(datos.rep[i]){
            cout<<"Distancia entre "<<char(i+'A')<<" :"<<datos.dis[i]<<endl;
        }
    }
}

int main(){
    TDatos datos;
    char c;
    int pos, dis;

    inicializar(datos);

    cout<<"Introduzca secuencia de mayúsculas (punto para finalizar): ";
    cin.get(c);
    pos=1;
    while(c!='.'){
        if(('A'<=c)&&(c<='Z')){
            if(datos.pos[c-'A']==0){
                datos.pos[c-'A']=pos;
            }else{
                datos.rep[c-'A']=true;
                dis=pos-datos.pos[c-'A']-1;
                datos.pos[c-'A']=pos;
                if(dis>datos.dis[c-'A']){
                    datos.dis[c-'A']=dis;
                }
            }
        }
        cin.get(c);
        pos++;
    }

    escribir(datos);
    return 0;
}


















