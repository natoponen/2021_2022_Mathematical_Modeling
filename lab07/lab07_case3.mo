model lab07_case3

constant Real N=2300 "объем аудитории";

Real n "число людей знающих о товаре";
Real alpha_1 "значение коэффициента aplha_1";
Real alpha_2 "значение коэффициента aplha_2";

initial equation
n=20 "количество людей, знающий о товаре в момент времени t=0";
alpha_1=0 "начальное значение коэффициента alpha_1";
alpha_2=0.03 "начальное значение коэффициента alpha_2";

equation
alpha_1=abs(0.05*sin(time));
alpha_2=abs(0.03*cos(4*time));
der(n)=(alpha_1+alpha_2*n)*(N-n);

end lab07_case3;
