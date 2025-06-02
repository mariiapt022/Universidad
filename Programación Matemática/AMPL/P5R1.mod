var x11>=0;
var x12>=0;
var x13>=0;
var x14>=0;
var x21>=0;
var x22>=0;
var x23>=0;
var x24>=0;
var y1 binary;
var y2 binary;
var z1 binary;


minimize z: 6*x11+3*x12+2*x13+9*x14+15*x21+23*x22+12*x23+19*x24+
50*y1+75*y2+90*z1;
s.t. c1: x11+x12+x13+x14<=300*y1+200*z1;
s.t. c2: x21+x22+x23+x24<=400*y2;
s.t. c3: x11+x21=100;
s.t. c4: x12+x22=150;
s.t. c5: x13+x23=75;
s.t. c6: x14+x24=125;
s.t. c7: z1<=y1;

