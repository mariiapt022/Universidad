 #include <iostream>
 using namespace std;
 const double PTS_EUR = 166.368;
 int main ()

{
    double euros, pts;
    cout << "Introduzca la cantidad en pesetas:";
    cin>>pts;
    euros=pts/PTS_EUR;
    cout<<pts<<" pesetas equivalen a "<<euros<<"euros"<<endl;

}
