//María Peinado Toledo
//Práctica 3. Ejercicio 3. 28/10/2020

#include <iostream>
using namespace std;
int main()
{
    const int FILA=8;

    for(int i=1;i<=FILA;i++){
        for(int j=1;j<=FILA;j++){
            if((i+j)%2==0){
                cout<<"B";
            }else{
                cout<<"N";
            }
        }
        cout<<endl;
    }
    return 0;
}
