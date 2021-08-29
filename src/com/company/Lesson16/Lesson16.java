package com.company.Lesson16;

public class Lesson16 {
    public static void main(String[] args) {
        // String pool -- кэш строк, новые объекты не создаются. Можно это обойти new String("Hello")
        // String s1 == String s2 только если они ссылаются на один объект в памяти
        // String immutable - он не меняется (immutable). Он хранит значение в private/final массива чаров.
        // Ни один из методов String не меняет индивидуальные элекменты массива
        String a = "hello";

        System.out.println(a.length());
        System.out.println(a.charAt(1)); // char на конкретном индексе (с нуля)
        System.out.println(a.indexOf('t')); //на каком индексе находится символ или строка
        System.out.println(a.startsWith("t"));
        System.out.println(a.endsWith("t"));
        System.out.println(a.substring(0, 2));
        System.out.println(a.trim()); //если ничего не поменялось, возвращает тот же объект (== возвращает true)
        System.out.println(a.strip()); //улучшенная версия trim, распознаёт табы итп
        System.out.println(a.stripLeading());
        System.out.println(a.toLowerCase());
        System.out.println(a.toUpperCase());
        System.out.println(a.contains("2"));
        System.out.println(a.replace('l', 'd')); // когда меняем char, возвращает тот же объект если меняем одинаковые вещи
        System.out.println(a.equalsIgnoreCase("ahaha"));
        System.out.println(a.isBlank()); //true если только пробелы
        System.out.println(a.isEmpty()); //true если ""

        a.trim().toUpperCase();

        System.out.println(5 + 6 + a); //11hello
        System.out.println(5 + a + 6); //5hello6

        // по умолчанию == и equals это одно и то же по умолчанию
        // в классе String метод equals перезаписан, он проверяет содержимое строк
    }
}
