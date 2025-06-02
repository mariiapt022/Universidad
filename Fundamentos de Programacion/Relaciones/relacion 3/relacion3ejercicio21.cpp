//María Peinado Toledo
//Relación 3. Ejercicio 21. 18/01/2021

#include <iostream>
#include <string>
using namespace std;

bool estaContenida(char c,const string s){
    int i=0;
    while((i<s.size())&&(c!=s[i])){
        i++;
    }
    return i<s.size();
}

int main(){
    string primera,pal;
    cout<<"Introduzca un texto terminado con la palabra FIN: "<<endl;
    cin>>primera;

    cout<<"Las palabras cuya inicial esta en el primera palabra del texto son: "<<endl;
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
