//prueba ej2 practica 6 maria peinado

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
    cout<<"Cuantas estaturas va a introducir (maximo "<<MAX<<"): ";
    cin>>v.num;

    cout<<"Introduzca las "<<v.num<<" estaturas: ";
    for(int i=0;i<v.num;i++){
        cin>>v.alturas[i];
    }
}

float calcularMedia(const TEstaturas& v){

    float total, media;
    for(int i=0;i<v.num;i++){
        total=total+v.alturas[i];
    }

    media=total/v.num;

    cout<<"La media es: "<<media<<endl;
    return media;

}


int encimaMedia(const TEstaturas& v, float media){

    int encimaMedia=0;

    for(int i=0;i<v.num;i++){
        if(v.alturas[i]>media){
        encimaMedia++;
        }
    }

    cout<<"Numero de alumnxs mas altxs q la media: "<<encimaMedia<<endl;


}

int debajoMedia(const TEstaturas& v, float media){

    int debajoMedia=0;

    for(int i=0;i<v.num;i++){
        if(v.alturas[i]<media){
        debajoMedia++;
        }
    }

    cout<<"Numero de alumnxs mas bajxs q la media: "<<debajoMedia<<endl;


}


int main(){

    int mas,menos;
    float media;

    TEstaturas v;
    leerDatos(v);
    media=calcularMedia(v);
    menos=debajoMedia(v,media);
    mas=encimaMedia(v,media);

    return 0;

}




