model lab06_case1

constant Real alfa=0.01;
constant Real beta=0.02;
constant Integer N=5000;

Real S;
Real I;
Real R;

initial equation
I=30;
R=1;
S=4969;

equation
der(S)=-alfa*S;
der(I)=alfa*S-beta*I;
der(R)=beta*I;

end lab06_case1;
