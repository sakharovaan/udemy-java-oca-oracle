package com.level2.Lesson10;

// enum по сути это именованные перечисления, для которых нам не нужно придумывать значения

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

enum Hellow {
    a, b, c, d
}

enum Bui { //дочерний класс java.lang.Enum, переводится в обычный класс внутренне
    //можем сравнивать только через == одинаковые
    //valueOf, values
    a("ab"),
    b("a");

    private String wtf;
    private Bui(String w){ //конструктор мы сами вызвать не можем, их может быть несколько
        this.wtf = w; // мы можем так задавать какие-то дополнительные свойства и потом их получать
    }
}

public class Lesson10 {
    public int a=5;
    static Hellow h;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        h = Hellow.d;

        Bui m = Bui.valueOf("a"); //создаём с помощью текста


        Scanner sc = new Scanner(System.in); // когда нам нужно прочитать число с консоли
        Scanner sc2 = new Scanner("babababa"); // передаём строку, которую нужно сканировать, напрямую
        sc2.useDelimiter("/|"); //использовать свой метод для разбивания строк вместо переноса строки
        int i = sc.nextInt(); //получаем int
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
        sc2.close();


        //reflection -- исследование данных о программе во время её выполнения. Позволяет исследовать информацию о полях, методах, конструкторах
        //нужен объект класса Class
        //nest -- классы, которые могут видеть поля private друг друга (в одном модуле) -- nestmates. Обычно объявляется главным верхний класс (nest host), остальные включены в него
        Class em = Class.forName("com.level2.Lesson10.Lesson10");
        Class em2 = Lesson10.class;
        //Class em3 = sc.getClass();

        Field f = em.getField("a"); //getFields возвращает все поля класса (в массиве); getDeclaredFields -- даже private
        f.setAccessible(true); //если нам говорят что у нас private поле, это можно обойти
        //f.set(cla, 6); задавать таким образом значения
        Method meth = em.getMethod("pk"); //поскольку могут быть разные перегрузки, если у нас есть параметры, их нужно передавать параметрами после имени
        //meth.invoke(this); таким образом например мы можем записать несколько методов в словарь и вызывать их по имени, например из файла
        if (Modifier.isPublic(meth.getModifiers())){
            System.out.println(f.getType());
        }
        System.out.println(em2.getConstructor());
    }

    @MyAnnotation(OS = "msms")
    public void pk(){

    }
}
//аннотации передают определённую информацию
//@Override -- компилятор ругается, если ошибки в переопределении метода -- мы говорим ему что мы хотим именно переопределить
//@Deprecated -- будет перечёркиваться -- комментировать почему устаревший и что вместо него
//можно аннотировать класс/интерфейс/enum, поле и метод класса, параметры метода или конструктора

@Target({ElementType.METHOD, ElementType.FIELD}) // к какому объекту может быть применима
@Retention(RetentionPolicy.SOURCE) // source видна в коде, но отбрасывается компилятором и нет в байт-коде; class -- видна в байт-коде, отбрасывается jvm; runtime -- видна во время выполнения
@interface MyAnnotation{ //это аннотация
    String OS(); //если элементы есть, мы обязаны их указывать
    int baba() default 5; //можем указывать значения по умолчанию
    // не можем использовать ссылочные типы данных кроме String
    //если у нас RetentionPolicy.SOURCE/RetentionPolicy.CLASS, то мы не сможем использовать рефлексию
}
//getAnnotation -- получаем аннотацию через рефлексию класса, её можно кастить в объект аннотации и из полей доставать значения