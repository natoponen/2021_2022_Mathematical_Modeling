model lab07_case2

constant Real alpha_1=0.0000305 "значение коэффициента aplha_1";
constant Real alpha_2=0.24 "значение коэффициента aplha_2";
constant Real N=2300 "объем аудитории";

Real n "число людей знающих о товаре";

initial equation
n=20 "количество людей, знающий о товаре в момент времени t=0";

equation
der(n)=(alpha_1+alpha_2*n)*(N-n);

end lab07_case2;
