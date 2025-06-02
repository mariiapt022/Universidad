//María Peinado Toledo
/*Programa: Diseña un algoritmo que lea de teclado tres caracteres dígitos, obtenga el número natural que
representan y lo muestre por pantalla. Podemos suponer que los datos de entrada son correctos.*/

#include <iostream>
using namespace std;

int main ()

{
    char n1, n2, n3;
    int nfinal;

    cout <<"Programa para formar un número de tres dígitos:" << endl;
    cout <<"Introduzca sus tres números";

    cin >>n1>>n2>>n3;

    nfinal= (int(n1)-48)*100 + (int(n2)-48)*10 + (int(n3)-48);

    //48 es el primer puesto de los números

    cout << "El número de tres cifras es " << nfinal <<endl;

    return 0;
}
