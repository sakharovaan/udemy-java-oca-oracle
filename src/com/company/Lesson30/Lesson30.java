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
class Info <T> { //можно использовать несколько типов <T, E>. Это type placeholder. E - элемент, K - ключи, V - value
    private T value; //T - подстановка типа. не может быть статичной

    public Info(T value){
        this.value = value;
    }

    public String toString() {
        return "{{" + value + "}}";
    }

    public T getValue(){
        return value;
    } //возвращает значение с тем типом который сейчас есть в классе

    //parametrized method. хорош когда нужно использовать один и тот же метод для разных типов данных
    // функциональность метода должна быть доступна для широкого типа данных
    // <E> E - return type E
    public <E> E hello(E e){
        return e;
    } //если мы передадим на вход этому методу ArrayList<E>, то компилятор будет проверять методы в типе E

    public T world (T val){return val;} // если шаблон типа был объявлен на уровне класса, мы можем не писать его на уровне метода

    //информацию о generics знает только компилятор, jvm видит как raw type (без типов)
    //для jvm все массивы из object, которые потом кастятся -- это и есть стирание типов

    //в method overloading существует проблема -- что если один класс с разными типами дженериков передавать, то у них стирается сигнатура
    //ошибка "have the same erasure" -- type erasure
    //но при этом нельзя перезаписать методы используя разные типы дженериков, хотя эти методы и используют одну сигнатуру на уровне jvm
    //потому что в сабклассе могут из-за этого возникать проблемы с неожиданным поведением
}