//Examen 2. Ejercicio 4

#include <iostream>
#include <string>
#include <array>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST> TArray;

struct TPalabras{
    TArray palabras;
    int nPal;
};

void aCero(TPalabras& p){
    for(int i=0;i<MAX_PAL_DIST;i++){
        p.palabras[i]="";
    }
    p.nPal=0;
}
int sumaASCII(const string& palabra){
    int suma=0;
    for(int i=0;i<palabra.size();i++){
        suma=suma+int(palabra[i]);
    }
    return suma;
}

bool esta (const TPalabras& p,const string& palabra){
    int cont=0;
    for(int i=0;i<p.nPal;i++){
        if(palabra==p.palabras[i]){
            cont++;
        }
    }
    return cont!=0;
}

void leerDatos(TPalabras& p,string& primera){
    string palabra;
    int suma1,sumap,i=0;
    cout<<"Introduzca un texto (FIN para terminar): "<<endl;
    cin>>primera;

    suma1=sumaASCII(primera);
    p.nPal=0;

    cin>>palabra;
    while(palabra!="FIN"&&p.nPal<MAX_PAL_DIST){
        sumap=sumaASCII(palabra);
        if(sumap<suma1&&!esta(p,palabra)){
            p.palabras[i]=palabra;
            i++;
            p.nPal++;
        }
        cin>>palabra;
    }
}


int posMayorAlf(TPalabras& p,int pos){
    int posicion,tam,j=0;
    string menor,comparar;
    menor=p.palabras[pos];
    bool ya=false;

    for(int i=pos;i<p.nPal;i++){
        comparar=p.palabras[i];
        if(comparar.size()<menor.size()){
            tam=comparar.size();
        }else{
            tam=menor.size();
        }

        while(j<tam&&!ya){
            if(comparar[j]<menor[j]){
                menor=comparar;
                posicion=i;
                ya=true;
            }else if(comparar[j]==menor[j]){
                j++;
            }else if(comparar[j]>menor[j]){
                ya=true;
            }
        }
        ya=false;
    }

    return posicion;
}

void ordenar(TPalabras& p,string primera){
    string anterior;
    int pos;
    cout<<"Antes de ordenar: "<<endl;
    for(int k=0;k<p.nPal;k++){
        cout<<p.palabras[k]<<" ";
    }
    cout<<endl;
    for(int i=0;i<p.nPal;i++){
        anterior=p.palabras[i];
        pos=posMayorAlf(p,i);
        p.palabras[i]=p.palabras[pos];
        p.palabras[pos]=anterior;
    }
    cout<<"Las palabras que son menores que "<<primera<<" son: "<<endl;
    for(int j=0;j<p.nPal;j++){
        cout<<p.palabras[j]<<" ";
    }
}

int main(){
    TPalabras p;
    string primera;
    aCero(p);
    leerDatos(p,primera);
    ordenar(p,primera);
    return 0;
}
//CREO QUE VOY A IR ESTA TARDE AL CINE Y LUEGO VOY A IR A CENAR MAS TARDE FIN


