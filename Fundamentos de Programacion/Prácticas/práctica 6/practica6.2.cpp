//María Peinado Toledo
//Práctica 6. Ejercicio 2. 09/12/2020

#include <iostream>
#include <array>
using namespace std;
const int MAX=50;
typedef array <int,MAX> TArray;

struct TEstaturas{
    int num;
    TArray alturas;
};

void leerDatos(TEstaturas& v){

    do{
    cout<<"Cuantas estaturas va a introducir (maximo 50): ";
    cin>>v.num;
    }while(v.num<=0||v.num>50);

    cout<<"Introduzca las "<<v.num<<" estaturas: ";
    for(int i=0;i<v.num;i++){
        cin>>v.alturas[i];
    }

}

float calcularMedia(const TEstaturas& v){
    float total=0, media;

    for(int i=0;i<v.num;i++){
        total=total+v.alturas[i];
    }

    media=total/v.num;
    cout<<"La media es: "<<media<<endl;

    return media;

}


int encimaMedia(const TEstaturas& v,float media){
    int encimaMedia=0;

    for(int i=0;i<v.num;i++){
        if(v.alturas[i]>media){
            encimaMedia++;
        }
    }

    cout<<"El numero de alumnxs mas altxs que la media: "<<encimaMedia<<endl;

    return encimaMedia;

}

int debajoMedia(const TEstaturas& v,float media){
    int debajoMedia=0;

    for(int i=0;i<v.num;i++){
        if(v.alturas[i]<media){
            debajoMedia++;
        }
    }

    cout<<"El numero de alumnxs mas bajxs que la media: "<<debajoMedia<<endl;

    return debajoMedia;
}

int main(){

    float media;

    TEstaturas v;

    leerDatos(v);
    media=calcularMedia(v);
    encimaMedia(v,media);
    debajoMedia(v,media);

    int a=5,b;
    cout<<int(&a)<<endl;
    cout<<int(&b)<<endl;

    return 0;

}



