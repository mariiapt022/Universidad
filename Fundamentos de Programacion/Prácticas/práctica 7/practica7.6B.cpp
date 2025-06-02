//María Peinado Toledo
//Práctica 7. Ejercicio 6B.(19 tercera rel) 13/01/2021

#include <iostream>
#include <array>
using namespace std;
const int FILAS = 5;
const int COLUMNAS = 5;
typedef array<int, COLUMNAS> TFilaSup;
typedef array<TFilaSup, FILAS> Superficie;
typedef array<char, COLUMNAS> TFilaLav;
typedef array<TFilaLav, FILAS> Lava;

void Iniciar (Lava& lava, int fil, int col) {
     for (int i = 0; i < FILAS; i++) {
       for (int j = 0; j < COLUMNAS; j++) {
       lava[i][j]=' ';
       }
      }
      lava[fil][col]='*';
}

void flujoDeLava(const Superficie& sup, int fil, int col, Lava& lava){
    int altura=sup[fil][col];
   // cout << endl << altura << endl;
     for (int i=0;i<FILAS;i++) {
        for (int j=0;j<COLUMNAS;j++) {
            if ((lava[i][j]!='*')&&(((col==j)&&((fil==i+1)||(i==fil+1)))||((fil==i)&&((col==j+1)||(j==col+1))))&&(sup[i][j]<altura)) {
                lava[i][j]='*';
                fil=i;
                col=j;
                flujoDeLava(sup,fil,col,lava);
            }
        }
      }
}

int main()
{
   Superficie sup;
   Lava lava;
   int fil,col;
   cout << "Introduzca superficie (matriz de naturales " << FILAS << "x" << COLUMNAS << "):\n";
   for (int i = 0; i < FILAS; i++) {
      for (int j = 0; j < COLUMNAS; j++) {
      cin >> sup[i][j];
      }
     }
     cout << "Introduzca punto de crater (fila y columna):\n";
     cin >> fil >> col;
     Iniciar(lava,fil,col);
     flujoDeLava(sup,fil,col,lava);
     cout << "El recorrido de la lava es:\n";
     for (int i = 0; i < FILAS; i++) {
       for (int j = 0; j < COLUMNAS; j++) {
       cout << lava[i][j];
       }
       cout << endl;
      }
      return 0;
}
