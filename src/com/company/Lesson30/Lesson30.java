package com.company.Lesson30;

public class Lesson30 {
    public static void main(String[] args) {
        // <Type> - дженерики - для типобезопасности и переиспользования кода
        //можно писать <Object>, но будут ошибки в рантайме

        Info <String> info1 = new Info<>("sdsdsdsd");
        System.out.println(info1);

        Info <Integer> info2 = new Info<>(12);
        System.out.println(info2);

        Integer i = info2.getValue();
    }
}

//parametrized class
class Info <T> { //можно использовать несколько типов <T, E>. Это type placeholder
    private T value;

    public Info(T value){
        this.value = value;
    }

    public String toString() {
        return "{{" + value + "}}";
    }

    public T getValue(){
        return value;
    }

    //parametrized method. хорош когда нужно использовать один и тот же метод для разных типов данных
    public <E> E hello(E e){
        return e;
    }

    //информацию о generics знает только компилятор, jvm видит как raw type (без типов)
    //для jvm все массивы из object, которые потом кастятся

    //в method overloading существует проблема -- что если один класс с разными типами дженериков передавать, то у них стирается сигнатура
    //ошибка "have the same erasure" -- type erasure
    //но при этом нельзя перезаписать методы используя разные типы дженериков, хотя эти
}