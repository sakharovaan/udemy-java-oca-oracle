package com.company.Lesson10;
import com.company.Lesson5.Test5;
import com.*;

//если в импорте одинаковые имена, то нужно использовать полные имена
//всегда неявно импортируются пакеты из Java.lang.*

//static import -- мы импортируем статичную переменную или метод, которые можем использовать напрямую
//через static import мы можем импортировать все статичные элементы класса

/*
multiline комментарий
 */

/**
 * javadoc комментарий -- сохранение документации о классе в формате html из комментов
 */

public class Lesson10 {
    Test5 t5 = new Test5("a");

    public double test(String a) {
        //если мы передаём примитивный тип данных в функцию, то передаётся значение переменной, то есть изначальная переменная не меняется
        //когда в параметр подставляются референс типа, то передаётся копия ссылки. ссылки изначальные не меняются
        //объекты которые передаются одни и те же

        return 2.6;
    }
}
