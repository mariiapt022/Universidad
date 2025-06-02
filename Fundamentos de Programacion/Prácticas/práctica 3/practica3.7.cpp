//María Peinado Toledo
//Práctica 3. Ejercicio 7. 29/10/2020

#include <iostream>
using namespace std;
int main()
{
    char operador;
    int operando1, operando2;
    float resultado;

    do{

        cout<<"Introduzca la operacion: ";
        cin>>operador;

        if(operador=='&'){
                cout<<"FIN DEL PROGRAMA."<<endl;
            }else if ((operador!='+')&&(operador!='-')&&(operador!='*')&&(operador!='/')){
                cout<<"ERROR."<<endl;
                throw "Operacion no existente";
            }else{

        cout<<"Introduzca el primer operando: ";
        cin>>operando1;
        cout<<"Introduzca el segundo operando: ";
        cin>>operando2;

        switch(operador){
            case '+':
            resultado= operando1+operando2;
            cout<<"El resultado es: "<<resultado<<endl;
            break;

            case '-':
            resultado= operando1-operando2;
            cout<<"El resultado es: "<<resultado<<endl;
            break;

            case '*':
            resultado=operando1*operando2;
            cout<<"El resultado es: "<<resultado<<endl;
            break;

            case '/':
            if (operando2==0){
                    throw "Divisor 0";
            }else{
                resultado=operando1/operando2;
                cout<<"El resultado es: "<<resultado<<endl;
            }
            break;

            default:
                if(operador=='&'){
                    cout<<"FIN DEL PROGRAMA."<<endl;
                }
        }
                }

    }while(operador!='&');

    return 0;
}


