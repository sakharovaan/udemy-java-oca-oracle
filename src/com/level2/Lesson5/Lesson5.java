package com.level2.Lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


class Abba{
    public static ArrayList<String> createThree(Supplier<String> stringSupp){
        ArrayList<String> ar = new ArrayList<>();
        for (int i=0; i<3;i++){
            ar.add(stringSupp.get());
        }
        return ar;
    }

    public static void changeStr(String str, Consumer<String> strCons){
        strCons.accept(str);
    }

    public static int wtfStr(String s, Function<String, Integer> f){
        return f.apply(s);
    }

    public static void main(String[] args) {
        ArrayList<String> als = createThree(() -> "Hello!"); // Supplier возвращает что-то
        System.out.println(als);
        changeStr(als.get(0), str -> als.set(0, str.toLowerCase())); //Consumer применяет функцию для элемента
        System.out.println(als);

        als.forEach(s -> System.out.println(s));

        als.forEach(s -> System.out.println(wtfStr(s, a -> a.length()))); //function принимает параметр одного типа, а возвращает другого

    }
}

public class Lesson5 {
    public static void main(String[] args) {
        String a = "test";
        String b = "shmest";

        ArrayList<String> str = new ArrayList<>();
        str.add(a);
        str.add(b);

        final String bb = "dsd";

        str.forEach(new Consumer<String>() { //объявляем анонимный класс
            //это фукциональный интерфейс -- с одним абстрактным методом, мы не можем использовать не функциональные интерфейсы
            @Override
            public void accept(String s) {
                System.out.println(s + bb); //можем использовать переменные извне, если мы их не меняем (effectively final) или константы (final)
            }
        });

        str.forEach((String s) -> { //лямбда-выражение
            System.out.println(s);
        });

        str.forEach(s -> { //покороче, но только без типа и с одним параметром
            System.out.println(s);
        });

        str.forEach(System.out::println); //idea говорит мне что можно заменить на method reference

        Collections.sort(str, (s1, s2) -> s1.length() - s2.length());  //вместо объявления отдельного компаратора

        str.removeIf(String::isEmpty);
        str.removeIf(elem -> elem.length() < 5);

        Predicate<String> p1 = s -> s.length() <5; //можно заранее предикат объявить
        str.removeIf(p1.negate()); // negate - это отрицание p1
    }
}
