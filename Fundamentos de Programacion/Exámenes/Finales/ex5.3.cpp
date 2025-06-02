//Examen 5. Ejercicio 3
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TPalabras;

bool esta(const TPalabras& v,const string palabra,const int tam){
    int i=0;
    while(i<tam&&v[i]!=palabra){
        i++;
    }
    return i<tam;
}

bool cumpleSufijo(const string sufijo,const string palabra){
    int cont=0,tope;

    tope=palabra.size()-sufijo.size();

    for(int i=sufijo.size();i>0;i--){
        for(int j=palabra.size();j>tope;j--){
            if(sufijo[i]==palabra[j]){
                cont++;
            }
        }
    }

    return cont==sufijo.size();
}

void mostrar(TPalabras& v,int tam){
    for(int i=0;i<tam;i++){
        cout<<v[i]<<" ";
    }
}


int main(){
    TPalabras v;
    string sufijo,palabra;
    int tam=0;
    cout<<"Introduzca el sufijo: ";
    cin>>sufijo;

    cout<<"Introduzca el texto (FIN para terminar): ";
    cin>>palabra;
    while(palabra!="FIN"){
        if(cumpleSufijo(sufijo,palabra)&&!esta(v,palabra,tam)){
            v[tam]=palabra;
            tam++;
        }
        cin>>palabra;
    }

    mostrar(v,tam);

    return 0;
}

//CREO QUE IREMOS A LA DIRECCION QUE NOS DIERON Y TAMBIEN IREMOS A COMER TODOS AUNQUE PIENSO QUE TODOS NO PODREMOS LLEGAR FIN









