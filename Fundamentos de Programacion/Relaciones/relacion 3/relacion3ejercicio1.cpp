//María Peinado Toledo
//Relación 3. Ejercicio 1. 03/12/2020

/*
const int MAX = 10;
typedef array<int, MAX> TArray;
TArray a;
int x, k;

a=6,3,9,7,1,8,10,2,4,5
*/

/*
x = 0;
for (int i = 0; i < MAX; i++) {
 x += a[i];
}

Solución: 6+3+9+7+1+8+10+2+3+4+5=58
*/

/*
x = a[0];
for (int i = 1; i < MAX; i++) {
 if (x < a[i]) {
 x = a[i];
 }
}

Solución: 10
*/

/*
k = 0;
for (int i = 1; i < MAX; i++) {
 if (a[k] < a[i]) {
 k = i;
 }
}
x = a[k];

Solución: 10
*/
