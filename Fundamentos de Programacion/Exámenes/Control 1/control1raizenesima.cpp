#include <iostream>
using namespace std;

int main()
{
    int num,n, producto=1, contador=0;

    cout<<"Introduzca el numero: ";
    cin>>num;

    cout<<"Introduzca el valor de n: ";
    cin>>n;


    for(int i=2; num>producto; i++){
        contador++;
        producto=1;

        for(int j=0; j<n; j++){
            producto=producto*i;
        }

    }

    cout<<"La raiz enesima de "<<num<<" es "<<contador<<".";

    return 0;
}
