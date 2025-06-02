//María Peinado Toledo
//Relación 3. Ejercicio 23. 18/01/2021

#include <iostream>
using namespace std;
const int MAX_PAL_DIST=20;
const int MAX_REP=10;
typedef int TPosiciones[MAX_REP];

struct TPalabra{
    string palabra;
    TPosiciones posiciones;
    int nposic;
};

typedef TPalabra TColeccion[MAX_PAL_DIST];

struct TDatos{
    TColeccion palabras;
    int npal;
};

int buscar(const TDatos& datos,const string& pal){
    int i=0;
    while((i<datos.npal)&&(datos.palabras[i].palabra!=pal)){
        i++;
    }
    return i;
}

void almacenar(TDatos& datos,const string& pal,int pos){
    int ind=buscar(datos,pal);
    if(ind>=datos.npal){
        datos.palabras[datos.npal].palabra=pal;
        datos.palabras[datos.npal].posiciones[0]=pos;
        datos.palabras[datos.npal].nposic=1;
        datos.npal++;
    }else{
        datos.palabras[ind].posiciones[datos.palabras[ind].nposic]=pos;
        datos.palabras[ind].nposic++;
    }
}

void escribir(const TDatos& datos){
    for(int i=0;i<datos.npal;i++){
        cout<<datos.palabras[i].palabra;
        for(int j=0;j<datos.palabras[i].nposic;j++){
            cout<<" "<<datos.palabras[i].posiciones[j]<<" ";
        }
        cout<<endl;
    }
}

int main(){
    string palabra;
    int pos;
    TDatos datos;
    datos.npal=0;
    cout<<"Introduzca texto (FIN para terminar): "<<endl;
    cin>>palabra;
    pos=1;
    while(palabra!="FIN"){
        almacenar(datos,palabra,pos);
        cin>>palabra;
        pos++;
    }
    escribir(datos);
    return 0;
}

//PRUEBA CREO QUE IREMOS A MI CASA PRIMERO Y QUE DESPUES IREMOS A LA CASA QUE QUIERAS FIN























