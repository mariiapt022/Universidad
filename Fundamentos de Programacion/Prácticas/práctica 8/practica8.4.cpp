//María Peinado Toledo
//Práctica 8. Ejercicio 4. 25/01/2021
#include <iostream>
#include <string>
using namespace std;

bool esta(string& pal,char letra){
    int i=0;
    while(i<pal.size()&&letra!=pal[i]){
        i++;
    }

    return i<pal.size();
}

void producto(string& pal1,string& pal2){
    //Intersección de conjuntos
    string resultado="";

    for(int i=0;i<pal1.size();i++){
        if(esta(pal2,pal1[i])&&!esta(resultado,pal1[i])){
            resultado+=pal1[i];
        }
    }

    cout<<"Resultado: "<<resultado;
}

void resta(string& pal1,string& pal2){
    //Diferencia de conjuntos
    string resultado="";

    for(int i=0;i<pal1.size();i++){
        if(!esta(pal2,pal1[i])&&!esta(resultado,pal1[i])){
            resultado+=pal1[i];

        }
    }
    cout<<"Resultado: "<<resultado;
}

void suma(string& pal1,string& pal2){
    //Unión de conjuntos
    char letra='a';
    string resultado="";

    while(letra<='z'){
        if(esta(pal1,letra)||esta(pal2,letra)){
            resultado+=letra;

        }
        letra++;
    }

    cout<<"Resultado: "<<resultado;
}

int main(){
    string operando1,operando2,operacion;

    do{
        cout<<"Operacion: ";
        cin>>operacion;
    }while(operacion!="+"&&operacion!="*"&&operacion!="-");

    while(operacion!="&"){
        cout<<"Operando 1: ";
        cin>>operando1;
        cout<<"Operando 2: ";
        cin>>operando2;

        if(operacion=="+"){
            suma(operando1,operando2);
        }else if(operacion=="*"){
            producto(operando1,operando2);
        }else if(operacion=="-"){
            resta(operando1,operando2);
        }

        cout<<endl;
        do{
            cout<<"Operacion: ";
            cin>>operacion;
        }while(operacion!="+"&&operacion!="*"&&operacion!="-");

        if(operacion=="&"){
            cout<<"FIN";
        }
    }

    return 0;
}
