package com.company.Lesson27;
import java.io.*;

public class Lesson27 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        File f = new File("a.txt"); // не проверяет наличие файла

        // класс Throwable - класс который может быть выброшен при исключении
        // сабклассы Throwable - Exception и Error. Сабкласс Exception - RuntimeException
        // между Exception/RuntimeException/Error большая разница
        // компилятор не в состоянии заранее предсказать возникновение RuntimeException, обычно виноват программист -- unchecked exception
        // можно не обрабатывать эти исключения, в отличие от обычных


        try {
            FileInputStream fs = new FileInputStream(f); //существующий файл
            FileOutputStream fo = new FileOutputStream(f);
        } catch (java.io.IOException e){ //IOException - суперкласс FileNotFoundException
            System.out.println(e.getMessage());
            e.printStackTrace();//catch-блоки не ловят исключение в других блоков своего уровня
        } finally {
            System.out.println("mif");
        }

        //test();
        tesvt(); //можно не проверять RuntimeException
    }

    static void test() throws FileNotFoundException { //если мы пишем throws, эти исключения обязательно должны быть проверены
        //это checked exceptions, мы обозначаем что эти проблемы за пределами контроля нашей программы -- внешние источники (сеть, бд...)
        //но мы можем объявить что метод, в котором мы это вызываем, тоже делает throws -- передать по цепочке

        throw new FileNotFoundException(); // если мы делаем throw, то нам нужно объявить что мы делаем throws
    }

    static void tesvt() throws RuntimeException {
        //рантаймэкспепшены не надо ловить, потому что они свидетельствуют об ошибках в коде
    }

    //Error -- серьёзные ошибки, которые не могут быть контролированы программой - переполнение стека (большая глубина рекурсии)
    //Error объявлять и обрабатывать не надо -- мы не знаем где и когда они возникнут
    //Могут быть объявлены и некоторые могут быть обработаны -- но это считается глупой затеей

    //в обработчике нужно всё равно писать return statement
    //если return есть и в catch, и в finally, то будет возвращаться значение из finally (если возвращается не переменная)
    //если return примитивных типов, то изменение этой переменной в finally уже ни на что не влияет (создаётся копия)
    //если ссылочные типы, то делается return ссылки

    //
}
//IllegalArguementException -- часто для валидации
//IllegalStateException -- когда объект в неправильном состоянии для этой операции

//статические переменные можно инциализировать с помощью статических методов

//недопустимо в перезаписанных методах использовать новые checked исключения (компилятор не может понять), но можно новые runtime
//если перезаписываем методы, то нужно делать try-catch родительских методов
//конструктор тоже выбрасывает exception, и его нужно ловить; мы можем добавлять свои exception в конструкторы, если они покрывают exception суперкласса

//нельзя ловить checked exceptions, которые функция не throws
