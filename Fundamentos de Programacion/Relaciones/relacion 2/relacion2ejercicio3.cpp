//María Peinado Toledo
//Relación 2. Ejercicio 3. 18/11/2020

#include <iostream>
using namespace std;

void leerDatos (int& N, int& i){
    do{
        cout << "Introduzca un numero entero N: ";
        cin>>N;
    }while(N<=0);

    do{
        cout << "Introduzca la posicion: ";
        cin>>i;
    }while(i<=0);
}

int digito(int N, int i){

    for(int iter=1; iter<i; iter++){
        N=N/10;
    }
    return N%10;
}

void imprimirDatos (int res){
    if(res>0){
        cout << "Resultado: "<<res<<endl;
    }else{
        cout << "Resultado: -1."<<endl;
    }
}

int main(){
    int N, i, num;

    leerDatos(N,i);

    num=digito(N,i);

    imprimirDatos(num);

    return 0;
}
