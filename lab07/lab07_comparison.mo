model lab07_comparison

constant Real N=2300 "объем аудитории";
constant Real alpha_1=0.01 "значение коэффициента aplha_1";
constant Real alpha_2=0.01 "значение коэффициента aplha_2";

Real n "число людей знающих о товаре в случае рекламы";
Real k "число людей знающих о товаре в случае сарафанного радио";

initial equation
n=20 "количество людей, знающий о товаре в момент времени t=0";
k=20 "количество людей, знающий о товаре в момент времени t=0";

equation
der(n)=alpha_1*(N-n);
der(k)=alpha_2*k*(N-k);

end lab07_comparison;
