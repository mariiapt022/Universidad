//Examen 4. Ejercicio 1
#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_PAL_DIST=20;
typedef array <string,MAX_PAL_DIST>TPalabras;
struct TDatos{
    TPalabras palabra;
    int tam;
};

void borrar(string& palabra,int pos){
    string uno,dos;
    for(int i=0;i<pos;i++){
        uno=uno+palabra[i];
    }
    for(int i=palabra.size();i>pos;i--){
        dos=dos+palabra[i];
    }
    palabra=uno+dos;
}

bool cumpleFantasma(const string primera,const string palabra){
    bool cumple=true,ya=false;
    char letra1,letra2;
    int pos,j=0;

    for(int i=0;i<primera.size();i++){
        if(primera[i]!='A'&&primera[i]!='E'&&primera[i]!='I'&&primera[i]!='O'&&primera[i]!='U'&&cumple){
                while(cumple&&!ya&&j<palabra.size()){
                    if(palabra[j]!='A'&&palabra[j]!='E'&&palabra[j]!='I'&&palabra[j]!='O'&&palabra[j]!='U'){
                        if(primera[i]==palabra[j]){
                            cumple=true;
                            ya=true;
                            pos=j;
                        }else{
                            cumple=false;
                        }
                    }
                    j++;
                }
                j=pos+1;
                ya=false;


        }

    }

    return cumple;

}

bool esta(const TDatos& v,const string palabra){
    int i=0;
    while((i<v.tam)&&(v.palabra[i]!=palabra)){
        i++;
    }
    return i<v.tam;
}

void mostrar(TDatos& v,string primera){
    cout<<"El numero de palabras asociadas por vocales fantasmas con el patron "<<primera<<": "<<endl;
    for(int i=0;i<v.tam;i++){
        cout<<"Palabra n."<<i+1<<": "<<v.palabra[i];
        cout<<endl;
    }
}

int main(){
    TDatos v;
    string primera,palabra;

    cout<<"Introduzca un texto acabado en FIN: "<<endl;
    cin>>primera;
    v.tam=0;
    cin>>palabra;
    while(palabra!="FIN"&&v.tam<MAX_PAL_DIST){
        if(!esta(v,palabra)&&cumpleFantasma(primera,palabra)){
            v.palabra[v.tam]=palabra;
            v.tam++;
        }
        cin>>palabra;
    }

    mostrar(v,primera);

    return 0;
}

//PERLA PARLE CALA APERL APRENDER LEPRA PAERL PRALE FIN














