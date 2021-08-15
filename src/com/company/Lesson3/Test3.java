package com.company.Lesson3;

public class Test3 {
    public static void main(String[] args) {
        int a=1,y=2;
        // унарный оператор -- работает с одной переменной ++ --
        // в выражении z=x - ++y перед y ++ увеличит значение y до вычитания, после -- после вычитания
        boolean f = !true;
        // bitwise - & | не меняет логику, но выполняет все выражения (не лениво)
        // bitwise может работать с числами в отличие от обычных (побитовые опрации)
        // ^ - exclusive or, когда только одна операнда true

        a++; //питон так не умеет
        System.out.println(a);
    }
}
