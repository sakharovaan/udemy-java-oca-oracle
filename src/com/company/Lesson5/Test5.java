package com.company.Lesson5;

public class Test5 {
    String foobar;
    int barfoo;

    Test5(String foo){ //конструктор
        //имя конструктора всегда совпадает с именем класса
        //конструктор Default если не объявляем -- Test6(){} -- создаётся компилятором
        //конструктор User defined мы сами определяем
        foobar = foo;
    }

    Test5(int bar){ //другой конструктор
        barfoo = bar;
    } //может не быть параметров, но есть тело -- например логирование
    //дефолтный конструктор != конструктор без параметров
    //у конструктора нет return

    int summa(int a, int b, int c) { //можно ли задавать неопределённое количество параметров?
        return a+b+c;
    }
}

class Test6 {
    Test5 trstfoofof;

    public static void main(String[] args) {
        Test5 t = new Test5("bar");
        Test5 t2 = new Test5(5);
        System.out.println(t.summa(1,2,3)); // в функции - параметры, при вызове - аргументы
    }
    //стек - потому что сначала должен завершить работу метод который вызывался последним по цепочке вызовов
}