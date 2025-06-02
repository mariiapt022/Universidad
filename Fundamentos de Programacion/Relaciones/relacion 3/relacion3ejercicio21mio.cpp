//Ejercicio 21 de nuevo

#include <iostream>
#include <string>
using namespace std;

bool estaContenida(char c,const string& s){
    bool si=false,para=false;
    int i=0;
    while((i<s.size())&&!para){
        if(c==s[i]){
            si=true;
            para=true;
        }
        i++;
    }
    return si;
}

int main(){
    string pal,primera;
    cout<<"Introduzca un texto terminado con la palabra FIN: "<<endl;
    cin>>primera;

    cout<<"Las palabras cuya inicial esta en la primera palabra del texto son: ";
    cin>>pal;
    while(pal!="FIN"){
        if(estaContenida(pal[0],primera)){
            cout<<pal<<" ";
        }
        cin>>pal;
    }

    return 0;

}

//Prueba ESTE AUNQUE SENCILLO ES UN BUEN EJEMPLO FIN
