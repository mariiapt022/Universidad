//Mar�a Peinado Toledo
/*Programa: Dise�a un algoritmo que lea de teclado tres caracteres d�gitos, obtenga el n�mero natural que
representan y lo muestre por pantalla. Podemos suponer que los datos de entrada son correctos.*/

#include <iostream>
using namespace std;

int main ()

{
    char n1, n2, n3;
    int nfinal;

    cout <<"Programa para formar un n�mero de tres d�gitos:" << endl;
    cout <<"Introduzca sus tres n�meros";

    cin >>n1>>n2>>n3;

    nfinal= (int(n1)-48)*100 + (int(n2)-48)*10 + (int(n3)-48);

    //48 es el primer puesto de los n�meros

    cout << "El n�mero de tres cifras es " << nfinal <<endl;

    return 0;
}
