//Examen 13. Ejercicio 4.
#include <iostream>
#include <array>
using namespace std;
const int F=5;
const int C=7;
typedef array <char,C>TFilas;
typedef array <TFilas,F>SalaCine;

void inicializar(SalaCine& sc){
    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            sc[i][j]='o';
        }
    }
}

void leerDatos(SalaCine& sc){
    cout<<"Introduzca la sala de cine: "<<endl;
    for(int i=0;i<F;i++){
        for(int j=0;j<C;j++){
            cin>>sc[i][j];
        }
    }
}

void mostrar(const SalaCine& sc){
    cout<<"   ";
    for(int i=0;i<C;i++){
        cout<<i<<" ";
    }
    cout<<endl;
    for(int j=-2;j<C;j++){
        cout<<"_ ";
    }
    cout<<endl;
    for(int k=0;k<F;k++){
        cout<<k<<": ";
        for(int z=0;z<C;z++){
            cout<<sc[k][z]<<" ";
        }
        cout<<endl;
    }
}

void comprar_tickets_consecutivo(SalaCine& sc,int fila_1,int fila_2,int n,bool& ok,int& fila_sel,int& col_sel){
    int cont=0,i=0,j=0,f1=fila_1,f2=fila_2,pos=0;
    bool encontrado=false;

    while(i<C&&!encontrado){
        while(sc[fila_1][i]=='o'){
            cont++;
            i++;
        }
        col_sel=pos;
        if(cont>=n){
            encontrado=true;
            fila_sel=f1;
        }else{
            cont=0;
        }
        i++;
        pos=i;
    }
    cont=0;
    while(j<C&&!encontrado){
        while(sc[fila_2][j]=='o'){
            cont++;
            j++;
        }
        col_sel=pos;
        if(cont>=n){
            encontrado=true;
            fila_sel=f2;
        }else{
            cont=0;
        }
        j++;
        pos=j;
    }
    if(!encontrado){
        ok=false;
    }else{
        ok=true;
    }
}

void rellenarSitios(SalaCine& sc,int fila,int columna,int n){
    for(int i=columna;i<columna+n;i++){
        sc[fila][i]='x';
    }
}

void cancelar_ticket(SalaCine& sc,int fila,int columna,bool& ok){
    if(sc[fila][columna]=='x'){
        sc[fila][columna]='o';
        ok=true;
    }else{
        ok=false;
    }
}

int main(){
    SalaCine sc;
    bool ok;
    int fila_sel,col_sel,fila_1,fila_2,n,fila,columna;

    inicializar(sc);
    leerDatos(sc);
    mostrar(sc);
    cout<<"Introduce las filas: ";
    cin>>fila_1>>fila_2;
    cout<<"Introduzca la cantidad de sitios: ";
    cin>>n;
    comprar_tickets_consecutivo(sc,fila_1,fila_2,n,ok,fila_sel,col_sel);
    cout<<"Se ha encontrado un asiento en "<<fila_sel<<","<<col_sel;
    cout<<endl;
    rellenarSitios(sc,fila_sel,col_sel,n);
    mostrar(sc);

    cout<<"Introduzca un asiento para cancelar ticket: ";
    cin>>fila>>columna;
    cancelar_ticket(sc,fila,columna,ok);
    if(ok){
        cout<<"Se ha cancelado su ticket.";
    }else{
        cout<<"No se ha podido cancelar su ticket.";
    }
    cout<<endl;
    mostrar(sc);
    return 0;
}

/*
x x o o x o o
o o o o o o o
o x o o o x o
x x x x o o o
o o o o o o o
*/
