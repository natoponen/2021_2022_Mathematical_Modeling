model lab05

constant Real a=0.58"значение коеффициента a";
constant Real b=0.048"значение коеффициента b";
constant Real c=0.38"значение коеффициента c";
constant Real d=0.028"значение коеффициента d";

Real x"переменная с количеством хищников";
Real y"переменная с количеством жертв";

initial equation
x=7"начальное количество хищников";
y=15"начальное количество жертв"; 

equation
der(x)=a*x-b*x*y"первое уравнение системы";
der(y)=-c*y+d*x*y"второе уравнение системы";

end lab05;
