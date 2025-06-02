//Control 2. Ejercicio 19B

#include <iostream>
#include <array>
using namespace std;
const int MAX=20;
typedef array <int,MAX>Componentes;

struct Vector{
    Componentes datos;
    int tam;
};

void aCero(Vector& v1,Vector& v2){
    for(int i=0;i<MAX;i++){
        v1.datos[i]=0;
        v2.datos[i]=0;
    }
    v1.tam=0;
    v2.tam=0;
}

void leerDatos(Vector& v1,Vector& v2){
    char valor1, valor2;
    int i=0,j=0;

    cout<<"Introduzca el primer array (acabado en punto): ";
    cin.get(valor1);
    while(valor1!='.'&&i<MAX){
        if(valor1>='A'&&valor1<='Z'){
            v1.datos[i]=valor1;
            i++;
            v1.tam++;
        }
        cin.get(valor1);
    }

    cout<<"Introduzca el segundo array (acabado en punto): ";
    cin.get(valor2);
    while(valor2!='.'&&j<MAX){
        if(valor2>='A'&&valor2<='Z'){
            v2.datos[j]=valor2;
            j++;
            v2.tam++;
        }
        cin.get(valor2);
    }

}


bool comparar(Vector& v1, Vector& v2){
    bool sonIguales=false;
    int posigual=-1;
    int k=0,copia,para=1,mov,y2;

    for(int i=0;i<v2.tam;i++){
        if(v1.datos[0]==v2.datos[i]){
            posigual=i;
        }
    }

    copia=v2.tam;
    v2.tam=v2.tam+posigual;

    for(int z=0;z<posigual;z++){
        mov=z+copia;
        v2.datos[mov]=v2.datos[z];
        v2.datos[z]=0;
    }


    if(posigual==-1){
        sonIguales=false;
    }else{
        for(int y=0;y<v1.tam;y++){
            sonIguales=false;
            y2=y+posigual;
            if(v1.datos[y]==v2.datos[y2]&&para!=0){
                sonIguales=true;
            }else{
                para=0;
            }

        }

    }

    return sonIguales;

}

int main(){

    Vector v1,v2;
    bool iguales;

    aCero(v1,v2);
    leerDatos(v1,v2);
    iguales=comparar(v1,v2);
    if(iguales){
        cout<<"SI son iguales.";
    }else{
        cout<<"NO son iguales.";
    }

    return 0;

}


//Prueba A C D F E.




