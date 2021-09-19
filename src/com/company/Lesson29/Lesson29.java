package com.company.Lesson29;

import java.util.ArrayList;

public class Lesson29 {
    public static void test(String a, FunctioanalIntf<String> b){ //теперь нам везде нужно указывать тип, который подставляется вместо T
        System.out.println(b.run(a));
    }

    public static void main(String[] args) {
        FunctioanalIntf<String> b = (String a) -> {return a.toUpperCase();};

        test("hello", b);
        test("hello", a -> a.toUpperCase());

        ArrayList<String> a = new ArrayList<>();
        a.add("a"); a.add("b");
        a.removeIf(x -> x.equals("a"));
        System.out.println(a);
    }
}

interface FunctioanalIntf<T>{ // T меняется на тип данных автоматически, это дженерик
    //Мы сохраняем лямбду в интерфейсе с одним методом, и когда вызываем сохранённую лямбду, вызываем этот метод
    //"Функциональный интерфейс"
    String run(T t);

    //может быть сколько угодно default/static методов
}

//Lambda expressions can be stored in variables if the variable's type is an interface which has only one method.
// The lambda expression should have the same number of parameters and the same return type as that method.
// Java has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) used by lists.


//Есть интерфейс Predicate - принимает T на вход и возвращает boolean через метод test
