program Power(x,y);

// A simple WHILE program to compute the power of 'x^y'
// using a 'while' loop

x := 2;
y := 3;
z := x;
while 2 <= y do begin
    x := x*z;
    y := y - 1
end