//Mar�a Peinado Toledo
//Relaci�n 2. Ejercicio 1. 18/11/2020

/*
1. Dadas las siguientes declaraciones de variables en la funci�n main de un determinado
programa:
    int a,b,c;
    bool fin;
Si disponemos de los siguientes subprogramas (se muestra sus cabeceras):
    bool uno(int x, int y)
    void dos(int& x, int y)
    int tres(int x)
�Cu�les de las siguientes llamadas desde la funci�n main a lo subprogramas son v�lidas?
�Cu�les son incorrectas y por qu�?

a) if (uno(a,b)) { b) dos(a,b+3) c) fin = uno(c,5)
d) fin = dos(c,5) e) dos(a,tres(a)) f) dos(tres(b),c)
g) if tres(a) { h) b = tres(dos(a,5)) i) dos(4,c)

*/

//SOLUCI�N

/*
a)BIEN
b)BIEN
c)BIEN
d)MAL
e)BIEN
f)MAL
g)MAL
h)MAL
i)MAL
*/
