//María Peinado Toledo
//Práctica 2. Ejercicio 8. 21/10/2020

#include <iostream>
using namespace std;

int main()
{
    int codigo,provincia,numeroOperacion,digitoControl;
    cout<<"Introduzca su codigo numerico: ";
    cin>>codigo;

    provincia= codigo/1000;
    numeroOperacion= codigo/10-provincia*100;
    digitoControl= codigo-(provincia*1000+numeroOperacion*10);

    if(codigo>999 && numeroOperacion%provincia==digitoControl){
        cout<<"Provincia "<<provincia<<endl;
        cout<<"Numero de Operacion "<<numeroOperacion<<endl;
        cout<<"Digito de Control "<<digitoControl<<endl;
    }else if(codigo<=999){
        cout<<"CODIGO INVALIDO (no tiene 4 digitos)";
    }else{
        cout<<"CODIGO INVALIDO (digito de control erroneo)";
    }
    return 0;
}
