package com.company.Lesson18;

import java.util.Arrays;

public class Lesson18 {
    public static void main(String[] args) {
        int []array1 = {0,3,1}; //длина массива всегда постоянна
        //есть array с примитивными и ссылочными значениями

        double [][]array3; //declaration ссылается на null. нельзя массивам сразу задавать размер
        array3 = new double[1][1]; //allocation. объявляем длину
        int length = array3.length;

        //initialization -- статическая и динамическая
        array3[0][0] = 1.0; //статическая
        //динамическая -- когда через for задаём

        int b [], c;
        int [] d, e [][]; //e это трёхмерный массив, потому что [] сначала относится и к e тоже

        Arrays.sort(array1);
        System.out.println(Arrays.binarySearch(array1, 3)); //массив должен быть отсортирован. Выдаёт либо существующий индекс или  который нужен (-(insertion point) - 1).

        //у Stringbuilder есть метод insert, в который нужно передавать массив

        //метод equals не перезаписан



    }
}
