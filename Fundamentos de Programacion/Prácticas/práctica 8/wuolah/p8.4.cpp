#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX=100000;
typedef array<bool,MAX>TAparece;

void RESTA (const string& a, const string& b, string& res, TAparece& aa, TAparece& bb) {
    int maximo;
    if (a.size()>=b.size()) {
        maximo = a.size();
    } else {
        maximo = b.size();
    }
    for (int i=0;i<maximo;i++){
        for (int j=0;j<maximo;j++){
           if ((a[i]==b[j])&&(bb[j]==false)) {
             //   cout << b << " OBSERVAD EL BUGG " << b[j] << endl;
            aa[i]=true;
            bb[j]=true;
            i++;
            j=-1;
           }
        }
    }
    for (int k=0;k<maximo;k++){
        if (aa[k]==false){
            res+=a[k];
        }
    }
}

void PRODUCTO (const string& a, const string& b, string& res, TAparece& aa, TAparece& bb) {
    TAparece cc,dd,ee;
    for (int i=0;i<MAX;i++){
        cc[i]=false;
        dd[i]=true;
        ee[i]=true;
    }
    string res2;
    int maximo;
    if (a.size()>=b.size()) {
        maximo = a.size();
    } else {
        maximo = b.size();
    }
    for (int i=0;i<maximo;i++){
        for (int j=0;j<maximo;j++){
           if ((a[i]==b[j])&&(bb[j]==false)) {
                aa[i]=true;
                bb[j]=true;
                j=-1;
                i++;
           }
        }
    }
    for (int k=0;k<maximo;k++){
        if (aa[k]==true){
            res2+=a[k];
        }
    }
    int tam1=res2.size();
    for (int i=0;i<tam1;i++){                  // Para que el producto sea CONMUTATIVO
       for (int j=1;j<tam1;j++) {
            if (int(res2[i])<=int(res2[j])) {
                cc[i]=true;
            } else {
                cc[i]=false;
            }
       }
       if (cc[i]==true){
        res+=res2[i];
          }
        }                                                   // HASTA AQUI VA PERFECTO
      if (res.size()==res2.size()-1) {
        for (int k=0;k<tam1;k++) {
            for (int l=0;l<tam1-1;l++) {
                if ((res2[k]!=res[l])&&(dd[k]==true)&&(ee[l]==true)) {
            dd[k]=true;
            ee[l]=true;
            } else {
               dd[k]=false;
               ee[l]=false;
               k++;
               l=0;
           }
        }
        if (dd[k]==true) {
            res+=res2[k];
        }
      }
    }
}

void Secuencia (string& a, string& b, string& res, char op, TAparece& aa, TAparece& bb){
    cout << "Operando1 = ";
    cin >> a;
    cout << "Operando2 = ";
    cin >> b;
    if (op=='+') {
        res=a+b;
    } else if (op=='-') {
        RESTA(a,b,res,aa,bb);
    } else {
        PRODUCTO(a,b,res,aa,bb);
    }
    cout << "Resultado = " << res;
}

void Leerdatos (string& a, string& b, string& res, char& op, TAparece& aa, TAparece& bb){
    for (int i=0;i<MAX;i++){
        aa[i]=false;
        bb[i]=false;
    }
    do {
        cout << "Operacion = ";
        cin >> op;
    } while ((op!='+')&&(op!='-')&&(op!='*')&&(op!='&'));
    if (op!='&'){
        Secuencia(a,b,res,op,aa,bb);
    } else {
        cout << "FIN";
    }

}


int main()
{
    string a,b,res;
    char op;
    TAparece aa,bb;
    Leerdatos (a,b,res,op,aa,bb);

    return 0;
}
