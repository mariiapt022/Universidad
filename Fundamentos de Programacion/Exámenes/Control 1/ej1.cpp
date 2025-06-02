#include <iostream>
using namespace std;

int main()
{
    int num, may=0, cont=0;

    cout << "Introduzca una secuencia de enteros positivos acabada en 0: ";
    cin>>num;

    while(num!=0)
    {
        cont=0;
        for(int i=2; i<=num; i++)
        {
            if(num%i==0)
            {
                cont++;
            }
        }

        if(cont==1)
        {
            if(num>may)
            {
                may=num;
            }
        }

        cin>>num;
    }

    if(may==0)
    {
        cout <<"No hay ningun primo en la secuencia."<<endl;
    }
    else
    {
        cout << "El mayor primo de la secuencia es: "<<may<<endl;
    }

    return 0;
}
