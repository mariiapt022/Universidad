reset;
set IND:=1..3;
var x {IND}, >=0;  


minimize z: 3*x[1]+2*x[2]+x[3];
s.t. c1: 2*x[1]+x[2]+x[3]<=4;
s.t. c2: x[1]-2*x[2]+x[3]<=6;
s.t. c3: x[1]+2*x[2]+2*x[3]=5;

