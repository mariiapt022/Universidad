//Control 2. Ejercicio 10

#include <iostream>
#include <array>
using namespace std;
const int TAM1=50;
const int TAM2=50;
typedef array <int,TAM1>TNumeros;
typedef array <int,TAM2>TPermutacion;


void aCero(TNumeros& num,TPermutacion& per){
    for(int i=0;i<TAM1;i++){
        num[i]=0;
        per[i]=0;
    }
}

void leerDatos(TNumeros& num, TPermutacion& per, int& tamnum, int&tamper){
    cout<<"Introduzca el tamaño del array de los numeros: ";
    cin>>tamnum;

    cout<<"Introduzca "<<tamnum<<" numero naturales: ";
    for(int i=0;i<tamnum;i++){
        cin>>num[i];
    }

    cout<<"Introduzca el tamaño del array de los numeros a permutar: ";
    cin>>tamper;

    cout<<"Introduzca "<<tamper<<" numero naturales: ";
    for(int i=0;i<tamper;i++){
        cin>>per[i];
    }

}

int numOcurrencias(const TNumeros& num, const TPermutacion& per, int tamper, int tamnum){
    bool ocurrencia=false;
    int contnumocurrencia=0;
    int contOcurrencia=0;
    int cont=1;

    for(int i=0;i<tamnum;i++){
        //int j=i;j<tamper+i;j++
        //int k=0;k<tamper;k++
        for(int j=i;j<tamper+i;j++){
            for(int k=0;k<tamper;k++){
                if(per[k]==num[j]&&cont!=0){
                   contnumocurrencia++;
                   cont=0;
                }
            }
            cont=1;
            if(contnumocurrencia==tamper){
                contOcurrencia++;
                cout<<"SI hay ocurrencia"<<endl;
            }else{
                cout<<"NO hay ocurrencia"<<endl;
            }
        }
        contnumocurrencia=0;
    }

    return contOcurrencia;
}


int main(){
    TNumeros num;
    TPermutacion per;

    int tamper, tamnum,contOcurrencias;

    aCero(num,per);
    leerDatos(num,per,tamnum,tamper);
    contOcurrencias=numOcurrencias(num,per,tamper,tamnum);

    cout<<contOcurrencias<<endl;

    return 0;
}


//Prueba 1 2 3 4 2 3 5 6 7
//per   2 3
