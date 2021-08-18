package com.company.Lesson9;

public class Lesson9 {
    final int CONST = 2;
    //нельзя написать static int a = this.b
    // не можем создать переменные с одинаковым названием

    public static void main(String[] args) {
        int a = 10; //1.область видимости для локальной переменной -- метод. у локального переменного нет дефолтного значения
        //2.область видимости параметра почти как у переменной, но может быть немного больше
        //3.instance переменные принадлежат объекту (nonstatic)
        //4.static переменные принадлежат всему классу

        //если у параметра такое же имя, как и у поля класса, то нужно обращаться через this

        //идентификаторы с [a-zA-Z$_], любой символ валюты, цифры везде кроме начала
        int $uck$ = 5;
        boolean True = true; //case-sensitive
        int String = 5; //String не зарезервированное слово

        Lesson9 tf; //создали ссылку без создания объекта
        Lesson9 tf2 = null; //мы обнулили ссылку, нет связи с объектом, он прекращает существование
        // мы можем поменять связь на другую
        //когда scope завершается, объекты перестают существовать
        String b = "sd"; //единственный класс который вызывается без конструктора
        //мы не можем управлять gc, им управляет jvm -- будут пригодны для удаления, но не факт, что удалены


    }
}
