package com.company.Lesson29b;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier; //поставляет объекты, когда его метод вызывается

public class Lesson29b {
    public static void main(String[] args) {
        var s = "sds"; // нам не нужно писать тип, компилятор сам переделывает код под старый формат -- type inference
        //можно использовать в for-each loop
        //нужно сразу задавать значение, нельзя использовать null
        //если делаем var в массиве, то нужно указывать тип массива

        var arr = new int []{1, 2};
        testSupplier(() -> "ahhh");
        testConsumer("ahaha", (x) -> System.out.println(x));
    }

    public static void testSupplier(Supplier<String> s){
        System.out.println(s.get()); //возвращает объект
    }

    public static void testConsumer(String a, Consumer<String> s){
        s.accept(a); //принимает объект
    }
}
