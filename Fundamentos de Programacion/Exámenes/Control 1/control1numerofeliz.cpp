#include <iostream>
using namespace std;

int main()
{
    int N, Nfinal, suma=0,div,dig,copia;

    cout<<"Introduzca su numero: ";
    cin>>N;

    if(N<10){
        Nfinal=N*N;
    }else{
        Nfinal=N;
    }

    copia=Nfinal;
    suma=copia;

    do{
        copia=suma;
        suma=0;

        do{
            dig=copia%10;
            div=copia/10;
            suma=suma+(dig*dig);
            copia=div;
        }while(div!=0);

    }while(suma>9);


    if(suma==1){
        cout<<"es feliz.";
    }else{
        cout<<"No es feliz";
    }

    return 0;

}
