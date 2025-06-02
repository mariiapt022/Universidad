#include <iostream>
using namespace std;

int main()
{
    int N, numInverso=0;
    bool capicua= true;

    cout<<"Introduzca una secuencia de numeros terminada en -1: ";
    cin>>N;

    cout<<"Los numeros capicuas son: ";

    while(N!=-1){


        numInverso=0;

        for(int i=N; i>0; i=i/10){
            numInverso=(numInverso*10)+(i%10);
        }

        if(numInverso==N){
            cout<<N<<" ";
        }

        cin>>N;


    }


    return 0;
}
