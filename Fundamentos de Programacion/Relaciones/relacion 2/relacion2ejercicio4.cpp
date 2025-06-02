//María Peinado Toledo
//Relación 2. Ejercicio 4. 21/11/2020

#include <iostream>
using namespace std;

int leerDatos(){
    int num;

    do{
        cout<<"Introduzca un numero natural mayor que 0: ";
        cin>>num;
    }while(num<=0);

    return num;
}

int numInv(int num){
    int numInv=0;

    for(int i=num; i>0;i=i/10){
        numInv=(numInv*10)+(i%10);
    }

    return numInv;
}


int digitos(int num){
    int dig=0;

    for(int i=num; i>0;i=i/10){
        dig++;
    }

    return dig;
}

void sumaDigitos(int n1, int n2, int& suma){
    suma=n1+n2;
}

void imprimirDatos(int n1,int n2,int res){
    cout<<n1<<" + "<<n2<<" = "<<res<<endl;
}

int main(){
    int numero, numeroInv, suma, digit;

    numero=leerDatos();
    numeroInv=numInv(numero);
    digit=digitos(numero);

    if(digit&2!=0){
        while((numero%10)!=(numeroInv%10)){
            sumaDigitos(numero%10,numeroInv%10,suma);
            imprimirDatos(numeroInv%10,numero%10,suma);
            numero=numero/10;
            numeroInv=numeroInv/10;
        }

        cout<<numero%10<<endl;
    }else{
        for(int iter=0;iter<digit/2;iter++){
            sumaDigitos(numero%10,numeroInv%10,suma);
            imprimirDatos(numeroInv%10,numero%10,suma);
            numero=numero/10;
            numeroInv=numeroInv/10;
        }
    }

    return 0;
}

