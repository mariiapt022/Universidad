#include <iostream>
using namespace std;

int main()
{
    int num, k=0,numk, potencia=1, dig,suma=0,Nfinal;

    cout<<"Introduzca el numero: ";
    cin>>num;

    numk=num;
    num=Nfinal;

    while(numk>0){
        numk=numk/10;
        k++;
    }

    for(int i=num; i<0; i=i/10){
        dig=i%10;
        potencia=1;
            for(int j=0; j<k; j++){
                potencia=dig*potencia;
            }
        suma=suma+potencia;
    }

    if(suma==Nfinal){
        cout<<"EL numero SI es narcisista.";
    }else{
        cout<<"EL numero No es narcisista.";
    }






}
