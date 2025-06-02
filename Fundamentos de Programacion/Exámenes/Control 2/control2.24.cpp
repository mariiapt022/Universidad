//Control 2. Ejercicio 24

#include <iostream>
#include <array>
using namespace std;
const int MAX=10;
typedef array <int,MAX> TNumeros;

//ESTA HECHO SIN ORDENAR

struct Vector{
    TNumeros numeros;
    int tam;
};

void aCero(Vector& v){
    for(int i=0;i<MAX;i++){
        v.numeros[0]=0;
    }
    v.tam=0;
}

void leerDatos(Vector& v){
    int valor,i=0;

    cout<<"Introduzca una secuencia de numeros enteros(0 termina): ";
    cin>>valor;
    while(valor!=0){
        v.numeros[i]=valor;
        i++;
        v.tam++;
        cin>>valor;
    }

}

bool estaOrdenado(Vector& v){
    bool ordenado;
    int anterior=v.numeros[0];
    int para=0;

    for(int i=0;i<v.tam;i++){
        if(v.numeros[i]>=anterior&&para==0){
            ordenado=true;
        }else{
            ordenado=false;
            para=1;
        }
        anterior=v.numeros[i];
    }
    return ordenado;
}

void borrar(Vector& v,int x, int& pos){
    pos=-1;
    for(int i=0;i<v.tam;i++){
        if(v.numeros[i]==x){
            pos=i;
        }
    }

    if(pos==-1){
        cout<<"El elemento a borrar no pertenece al vector.";
    }else{
        cout<<"El vector despues de borrar el entero: ";
        for(int j=0;j<v.tam;j++){
            if(j!=pos){
                cout<<v.numeros[j]<<" ";
            }
        }
    }
}

void insertar(Vector& v, int x, int pos){
    int ya=-1;
    for(int i=0;i<v.tam;i++){
        if(v.numeros[i]==x){
            ya=0;
        }
    }

    if(ya==0){
        cout<<"El elemento a insertar ya pertenece al vector.";
    }else{
        cout<<"El vector despues de añadir el entero: ";
        if(v.tam<MAX){
            for(int j=0;j<v.tam;j++){
                if(j!=pos){
                    cout<<v.numeros[j]<<" ";
                }
            }
            cout<<x;
        }else{
            cout<<"No hay espacio para añadirlo.";
        }
    }

}

void borrarOrdenado(Vector& v,int x){
    int pos=-1;
    int copia,siguiente,cont;
    for(int i=0;i<v.tam;i++){
        if(v.numeros[i]==x){
            pos=i;
        }
    }

    if(pos==-1){
        cout<<"El elemento a eliminar no pertenece al array.";
    }else{
        cont=pos;
        while(cont<v.tam){
            siguiente=cont+1;
            v.numeros[cont]=v.numeros[siguiente];
            cont++;
        }
        v.tam=v.tam-1;
        cout<<"El vector despues de borrar el elemento: ";
        for(int j=0;j<v.tam;j++){
            cout<<v.numeros[j]<<" ";
        }
    }
}

void insertarOrdenado(Vector& v,int x){

    int pos=0,anterior;

    for(int i=0;i<v.tam;i++){
        if(v.numeros[i]<x){
            pos++;
        }
    }

    v.tam=v.tam+1;
    v.numeros[v.tam-1]=0;

    for(int j=v.tam-1;j>=pos;j--){
        anterior=j-1;
        v.numeros[j]=v.numeros[anterior];
    }
    v.numeros[pos]=x;
    cout<<"El vector despues de insertar el elemento: ";
    for(int k=0;k<v.tam;k++){
        cout<<v.numeros[k]<<" ";
    }

}



int main(){
    Vector v;
    int quita,anade,pos;
    bool ordenado;
    aCero(v);
    leerDatos(v);
    ordenado=estaOrdenado(v);
    cout<<"Introduzca un numero entero a borrar del vector: ";
    cin>>quita;
    cout<<"Introduzca un numero entero a insertar en el vector: ";
    cin>>anade;

    if(!ordenado){
        borrar(v,quita,pos);
        cout<<endl;
        insertar(v,anade,pos);
    }else{
        borrarOrdenado(v,quita);
        cout<<endl;
        insertarOrdenado(v,anade);
    }


    return 0;
}


//Prueba 2 -4 32 45 6 7 0
//Prueba 3 5 6 14 23 0






