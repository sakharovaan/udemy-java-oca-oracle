package com.company.Lesson29b;

import java.util.List;
import java.util.function.Predicate;

public class Lesson29b2 {
    public static void main(String[] args) {
        List <String> list = List.of("a", "c", "d");
        list.forEach(a -> System.out.println(a));

        Predicate<Integer> p = element -> element % 3 == 0;
        //array.removeIf(p)
        //array.sort((x,y) -> x.compareTo(y)) -- таким образом можно отсортировать коллекцию

    }
}
