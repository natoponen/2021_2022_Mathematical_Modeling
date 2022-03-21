model lab07_case1

constant Real alpha_1=0.205 "значение коэффициента aplha_1";
constant Real alpha_2=0.000023 "значение коэффициента aplha_2";
constant Real N=2300 "объем аудитории";

Real n "число людей знающих о товаре";

initial equation
n=20 "количество людей, знающий о товаре в момент времени t=0";

equation
der(n)=(alpha_1+alpha_2*n)*(N-n);

end lab07_case1;
