model lab04
  
  constant Real w=sqrt(3.5);
  
  Real x;
  Real y;
  
initial equation
  x=1;
  y=1.2;

equation
  der(x)=y;
  der(y)=-w*w*x;

end lab04;
