package com.level2.Lesson9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson9 {
    public static void main(String[] args) {
        String s = "aaba";
        Pattern p1 = Pattern.compile("\\ba?");
        // \A - начало string
        // \Z - конец string
        // \b - граница слова или числа - то есть нет с этой стороны ни цифр, ни букв
        // \B - граница НЕ слова и НЕ числа
        Matcher mather = p1.matcher(s);

        while (mather.find()){
            System.out.println(mather.start() + mather.group());
        }
        //matches проверяет на совпадение, split делит по regex, replaceAll заменяет

        System.out.printf("%s %030f", "privet", 3.1415d); //%030f -- добивать нулями впереди до 30 символов
        //%[flags][width][.precision]
        // флаги:
        // - выравнивание по левому краю
        // 0 добавление нулей
        // . разделитель разрядов
    }
}
