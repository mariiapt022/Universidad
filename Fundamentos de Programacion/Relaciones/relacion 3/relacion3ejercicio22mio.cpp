//Ejercicio 22 de nuevo

#include <iostream>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef string TPalabras[MAX_PAL_DIST];

struct TDatos{
    TPalabras pal;
    int nPal;
};

bool contiene(const string& pal,const string& patron){
    int i,tope;
    bool encontrado=false;
    if(pal.size()>=patron.size()){
        tope=pal.size()-patron.size();
        i=0;
        while((i<=tope)&&!encontrado){
            if(pal[i]==patron[0]){
                if(pal.substr(i,patron.size())==patron){
                    encontrado=true;
                }else{
                    encontrado=false;
                }

            }
            i++;
        }
    }

    return encontrado;
}

bool esta(const string& pal,const TDatos& datos){
    int i=0;
    while((i<datos.nPal)&&(pal!=datos.pal[i])){
        i++;
    }
    return i<datos.nPal;
}

void escribir(const string& patron,const TDatos& datos){
    cout<<"Las palabras que contienen "<<patron<<" son: "<<endl;
    for(int i=0;i<datos.nPal;i++){
        cout<<datos.pal[i]<<" ";
    }
}

int main(){
    TDatos datos;
    string pal,patron;
    cout<<"Introduzca el patron: ";
    cin>>patron;
    cout<<"Introduzca una secuencia de palabras terminadas en FIN: "<<endl;
    datos.nPal=0;
    cin>>pal;
    while(pal!="FIN"){
        if(contiene(pal,patron)&&!esta(pal,datos)){
            datos.pal[datos.nPal]=pal;
            datos.nPal++;
        }
        cin>>pal;
    }
    escribir(patron,datos);
    return 0;
}

//CREO QUE IREMOS A LA DIRECCION QUE NOS DIERON AUNQUE PIENSO QUE DICHA DIRECCION NO ES CORRECTA FIN


















