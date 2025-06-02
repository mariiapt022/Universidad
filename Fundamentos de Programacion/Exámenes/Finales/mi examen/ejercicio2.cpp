//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A3/A4 PC1108
//Examen Febrero. Ejercicio 2. 05/02/2021

#include <iostream>
using namespace std;

void leerDatos(int& num){
    do{
        cout<<"Introduzca un numero de al menos 5 digitos: ";
        cin>>num;
    }while(num<=9999);
}

void esEscalera(int num,bool& escalera,bool& escaleraPerfecta){
    int dig=1,resto,cociente=1,anterior,divisor=10;
    bool primero=false;

    anterior=num%10;

    while(dig!=0&&escalera){
        resto=num%divisor;
        dig=resto/cociente;
        if(dig>anterior){
            escalera=false;
            escaleraPerfecta=false;
        }else if(primero&&dig!=anterior-1){
            escaleraPerfecta=false;
        }
        anterior=dig;
        cociente=cociente*10;
        divisor=divisor*10;
        primero=true;
    }
}


int main(){
    int num;
    bool esc=true;
    bool escPerf=true;
    leerDatos(num);
    esEscalera(num,esc,escPerf);

    if(escPerf){
        cout<<"El numero es una escalera perfecta.";
    }else if(esc){
        cout<<"El numero esta en escalera";
    }else{
        cout<<"El numero NO esta en escalera.";
    }

    return 0;
}


