model lab04_2
  
  constant Real w=sqrt(3);
  constant Real g=3.5;
  
  Real x;
  Real y;
  
initial equation
  x=1;
  y=1.2;

equation
  der(x)=y;
  der(y)=-2*g*y-w*w*x;

end lab04_2;
