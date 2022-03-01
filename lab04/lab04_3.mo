model lab04_3
  
  constant Real w=sqrt(2);
  constant Real g=2.5;
  
  Real x;
  Real y;
  Real f;
  
initial equation
  x=1;
  y=1.2;
  f=0;

equation
  f=2*sin(6*time);
  der(x)=y;
  der(y)=-2*g*y-w*w*x+f;

end lab04_3;
