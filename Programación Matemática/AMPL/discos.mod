param N:=10;

var x{1..N};
var y{1..N};
var R>=0;

maximize radio: R;
s.t. constr1x {i in 1..N}: R<=x[i];
s.t. constr1y {i in 1..N}: R<=y[i];
s.t. constr2x {i in 1..N}: x[i]<=1-R;
s.t. constr2y {i in 1..N}: y[i]<=1-R;
s.t. noIntersect {i in 1..N,j in 1..N: j>i}:
	(x[i]-x[j])^2 + (y[i]-y[j])^2 >= (2*R)^2;
