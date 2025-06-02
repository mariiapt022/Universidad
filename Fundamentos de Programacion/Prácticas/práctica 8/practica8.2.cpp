//María Peinado Toledo
//Práctica 8. Ejercicio 2. 25/01/2021
#include <iostream>
#include <string>
using namespace std;

bool esAnagrama(const string& palabra,string& primera){
    bool cumple=true,ya=false;
    int i=0,j=0;
    string aux;
    aux=palabra;

    if(palabra.size()!=primera.size()){
        cumple=false;
    }

    while(i<int(primera.size())&&cumple){
        while(j<int(palabra.size())&&!ya){
            if(primera[i]==aux[j]){
                ya=true;
                cumple=true;
                aux[j]=' ';
            }else{
                cumple=false;
            }
            j++;
        }
        ya=false;
        i++;
        j=0;
    }

    return cumple;
}

int main(){
    string palabra,primera;
    int cont=0;
    cout<<"Introduzca un texto terminado en FIN: "<<endl;
    cin>>primera;

    cin>>palabra;
    while(palabra!="FIN"){
        if(esAnagrama(palabra,primera)){
            cont++;
        }
        cin>>palabra;
    }

    cout<<"El numero de palabras anagramas de la primera es: "<<cont;
    return 0;
}

//VACA NO ES CAVA NI TAMPOCO VACV PERO CASI AACV FIN
