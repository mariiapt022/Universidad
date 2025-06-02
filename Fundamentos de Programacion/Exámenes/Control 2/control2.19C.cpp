//Control 2. Ejercicio 19C

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

void leerDatos(Vector& v1, Vector& v2){
    char valor1,valor2;
    int i=0,j=0;

    cout<<"Introduzca una secuencia de letras mayusculas: ";
    cin.get(valor1);
    while(valor1!='.'&&i<MAX){
        v1.datos[i]=valor1;
        v1.tam++;
        i++;
        cin.get(valor1);
    }

    cout<<"Introduzca una secuencia de letras mayusculas: ";
    cin.get(valor2);
    while(valor2!='.'&&j<MAX){
        v2.datos[j]=valor2;
        v2.tam++;
        j++;
        cin.get(valor2);
    }

}

void mezclar(Vector& v1, Vector& v2){

    char letra='A';

    while(letra<='Z'){
        for(int i=0;i<v1.tam;i++){
            if(v1.datos[i]==letra){
                cout<<letra;
            }
        }

        for(int j=0;j<v2.tam;j++){
            if(v2.datos[j]==letra){
                cout<<letra;
            }
        }
        letra++;
    }

}

int main(){
    Vector v1,v2;
    aCero(v1,v2);
    leerDatos(v1,v2);
    mezclar(v1,v2);
    return 0;

}

//Prueba ACHHQS.





