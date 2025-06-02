reset;
var x1>=0;
var x2>=0;
var x3>=0;
var x4>=0;
var x5>=0;

minimize z: 2*x1^2 + x2^2 + 3*x4^2 + x5^2;
s.t. c1: -x1 + 2*x2 + x3 + x5 >= 2;
s.t. c2: 3*x1 -x3 + 2*x4 >=1;
s.t. c3: x1 + x2 -x3 + 2*x4 - 3*x5 <= 2;