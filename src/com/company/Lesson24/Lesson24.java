package com.company.Lesson24;

abstract public class Lesson24 {
    public static void main(String[] args) {
        //базовый класс ничего не знает о том что эти методы должны делать
        //но он знает что эти методы должны быть
    }

    abstract void foo(); //не должен иметь тела

    //нельзя создать объект абстрактного класса
}

class Test extends Lesson24 { // он тоже должен быть абстрактным или перезаписывать все методы родителя
    // если абстрактный класс наследуется от абстрактного, то наследует все переменные
    // абстрактные переменные быть не могут
    // абстрактный класс не может быть final
    //не могут быть методы final abstract, private abstract, static abstract

    @Override
    void foo() {

    }
    //конечный класс абстрактного класса - конкретный класс
}
