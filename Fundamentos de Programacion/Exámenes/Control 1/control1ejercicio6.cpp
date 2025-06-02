#include <iostream>
using namespace std;

int main()
{
    int N,contador=0, cubo=0, impar=-1;

    do{
        cout<<"Introduzca un numero >0: ";
        cin>>N;
    }while(N<=0);

    cout<<"Los "<<N<<" primer cubos son: "<<endl;

    for(int i=1; i<=N; i++){
        contador=1;
        cubo=0;

        cout<<i<<" al cubo = ";

        for(int j=impar+2; contador<=i; j=j+2){
            contador++;
            cubo=cubo+j;
            impar=j;
        }

        cout<<cubo<<endl;
    }

    return 0;
}
