package com.company.Lesson22;

public class Lesson22 extends Object{
    public static void main(String[] args) {
        int i = 2;
        String s = new String [] {"A", "B", "C"}[i];
    }

    //инкапсуляция (сокрытие данных), наследование, полиморфизм

    //=инкапсуляция= - мы создаём методы для доступа к private-переменной
    private String name;

    public StringBuilder getName(){
        StringBuilder sb = new StringBuilder(this.name); //мы возвращаем не сам объект (ссылку на него), а копию
        //если это mutable тип данных, то лучше возвращать его копию
        return sb;
    }

    public void setName(String newName) { //какие-нибудь проверки
        this.name = newName;
    }
    //если boolean - isParam/setParam

    // =наследование=
    //у дочернего класса может быть только один родитель
    //родительский класс более общий -- выносим туда общие элементы
    //если мы не пишем extends, компилятор добавляет Object

    //отношение is-a "Mouse extends Animal - Mouse is Animal"
    //отношение has-a "в House объявлена переменная типа Window - House has Window"

    //private не наследуются, можно работать через public методы
    //default наследуется, если в том же пакете
    //protected могут быть видны только путём наследования
}

class Test extends Lesson22 {
    Test(){
        super(); //вызов конструктора родительского класса. может быть только на первой строке
        //обращается к конструктору с такими же аргументами по умолчанию. или мы можем указать конкретные аргументы в super
        //если мы super не пишем, то автоматом прописывается super без параметров
        //super и this не могут находиться в теле конструктора

        //в суперклассе должен быть конструктор без параметров, если не пишем super
        //private конструкторы и классы не видны как обычно
    }
}