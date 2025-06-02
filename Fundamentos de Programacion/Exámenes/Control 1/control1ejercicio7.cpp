#include <iostream>
using namespace std;

int main()
{
    int a, b, sumPar=0, sumImpar=0;

    do{
        cout<<"Introduzca el intervalo: ";
        cin>>a>>b;
    }while(a>b);

    for(int i=b; a<=i; i--){
        if(i%2==0){
            sumaPar=sumaPar+i;
        }else{
            sumaImpar=sumaImpar+i;
        }
    }

    cout<<"Suma de los numeros pares: "<<sumaPar<<endl;
    cout<<"Suma de los numeros impares: "<<sumaImpar<<endl;

    return 0;

}
