//Examen 12. Ejercicio 1.
#include <iostream>
#include <array>
using namespace std;
const int MAX=5;
const int MAX_REP=4;
typedef int TPosiciones[MAX_REP];
struct TNumero{
    int num;
    TPosiciones pos;
    int ocupa=0;
};
typedef TNumero TSecuencia[MAX];
struct TNumeros{
    TSecuencia numeros;
    int tam;
};

bool esta(const TNumeros& v,const int num){
    int i=0;
    while(i<v.tam&&v.numeros[i].num!=num){
        i++;
    }
    return i<v.tam;
}

int buscarInd(const TNumeros& v,const int num){
    int pos=0;
    for(int i=0;i<v.tam;i++){
        if(v.numeros[i].num==num){
            pos=i;
        }
    }
    return pos;
}

int buscarMenor(TNumeros& v){
    int menor=v.numeros[0].num;
    for(int i=0;i<v.tam;i++){
        if(v.numeros[i].num<menor){
            menor=v.numeros[i].num;
        }
    }
    return menor;
}

void leerDatos(TNumeros& v,int& M){
    int n,ind,cont=0,menor,numdist=0;

    do{
        cout<<"Introduzca el valor de M: ";
        cin>>M;
    }while(M<0||M>MAX);

    v.tam=0;

    cout<<"Introduzca una secuencia de numeros acabadas en 0: "<<endl;
    cin>>n;
    while(n!=0){
        if(numdist<MAX){
            if(!esta(v,n)){
                v.numeros[v.tam].num=n;
                v.numeros[v.tam].ocupa=1;
                v.numeros[v.tam].pos[1]=cont;
                v.tam++;
                numdist++;
            }else{
                ind=buscarInd(v,n);
                v.numeros[ind].ocupa++;
                v.numeros[ind].pos[v.numeros[ind].ocupa]=cont;
            }
        }else{
            if(!esta(v,n)){
                menor=buscarMenor(v);
                if(n>menor){
                    ind=buscarInd(v,menor);
                    v.numeros[ind].ocupa=1;
                    v.numeros[ind].num=n;
                    v.numeros[ind].pos[1]=cont;
                }
            }else{
                ind=buscarInd(v,n);
                v.numeros[ind].ocupa++;
                v.numeros[ind].pos[v.numeros[ind].ocupa]=cont;
            }
        }

        cont++;
        cin>>n;
    }
}

void mostrar(TNumeros& v){
    for(int i=0;i<v.tam;i++){
        cout<<v.numeros[i].num<<": ";
        for(int j=1;j<=v.numeros[i].ocupa;j++){
            cout<<v.numeros[i].pos[j]+1<<" ";
        }
        cout<<endl;
    }
}


int main(){
    TNumeros v;
    int M;
    leerDatos(v,M);
    cout<<"Los "<<M<<" numeros mayores son: "<<endl;

    mostrar(v);

    return 0;
}

//2 3 4 7 28 4 5 1 1 1 9 7 4 4 28 2 1 3 3 6 0
//2 3 3 7 28 7 5 1 1 1 9 7 4 4 28 2 1 3 3 6 0
