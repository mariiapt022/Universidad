#include <iostream>
using namespace std;

int main()
{
    int contComas=0, contEsp=0, contText=0, secMax=0;
    bool comaEncontrada=true;
    char texto;

    cout<<"Introduzca el texto.";
    cin.get(texto);

    while(texto!='.'){

        if(texto==' '){
            contEsp++;
        }

        if(comaEncontrada){
            contComas++;
        }

        if(texto==','){
            if(contComas>secMax){
                secMax=contComas-1;
                contComas=0;
            }else{
                contComas=0;
            }
            comaEncontrada=true;
        }

        if((texto=='a')||(texto=='e')||(texto=='i')||(texto=='o')||(texto=='u')){
            texto=texto-('a'-'A');
        }

    cout<<texto;
    contText++;
    cin.get(texto);

    }
    cout<<endl;
    cout<<secMax<<endl;
    cout<<contEsp<<endl;
    cout<<contText<<endl;

    //Cada cuatro horas, mi hermano come tres huevos, un campero, cinco patatas y siete filetes.

}
