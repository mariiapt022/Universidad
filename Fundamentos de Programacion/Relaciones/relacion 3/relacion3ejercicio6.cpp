//María Peinado Toledo
//Relación 3. Ejercicio6. 07/12/2020

#include<iostream>
#include<array>
using namespace std;
const int MAX=27;
typedef array<int,MAX> Tvector;

void iniciarVector(Tvector& v){
    for(int i=0;i<MAX;i++){
        v[i]=0;
    }
}

void actualizarVector(Tvector& v, char texto){
    if(texto>='A'&&texto<='Z'){
        int i=texto-'A';
        v[i]++;
    }
}

void leerDatos(Tvector& v){
    char letra;
    cout<<"Introduce una letra mayuscula (un punto para finalizar): ";
    cin>>letra;
    while(letra !='.'){
        actualizarVector(v, letra);
        cin>>letra;
    }
}

void imprimirDatos(const Tvector& v){
    char letra='A';
    for(int i=0; i<MAX; i++){
        if (v[i]!=0){
            cout<<letra<<": "<<v[i]<<endl;
        }
        letra++;
    }
}

int main(){
    Tvector vcont;
    iniciarVector(vcont);
    leerDatos(vcont);
    imprimirDatos(vcont);

    return 0;
}













