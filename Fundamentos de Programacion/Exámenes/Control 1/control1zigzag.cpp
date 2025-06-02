#include <iostream>
using namespace std;

int main()
{
    int N;
    bool mal=false,positivo=false,negativo=false,primer=true;


    cout<<"Introduzca una secuencia de numeros terminada en 0: ";
    cin>>N;


    while((N!=0)&&(!mal)){

        if(primer){
            primer=false;
            if(N>0){
                negativo=true;
            }else{
                positivo=true;
            }
        }else{
            if((N>0)&&positivo){
                positivo=false;
                negativo=true;
            }else if((N<0)&&negativo){
                negativo=false;
                positivo=true;
            }else{
                mal=true;
            }
        }

        cin>>N;

    }

    if(!mal){
        cout<<"SI";
    }else{
        cout<<"NO";
    }

    return 0;




}
