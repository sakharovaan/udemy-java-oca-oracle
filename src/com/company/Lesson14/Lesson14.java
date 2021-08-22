package com.company.Lesson14;

public class Lesson14 {
    public static void main(String[] args) {
        //можем объявить int заранее и поменять i=5 в начале
        OUTER: for (int i =0, j=6; i<10; i++, System.out.println(i)) { // OUTER это лейбл для for
            System.out.println(i);
            //break; останавливает цикл
            //continue;
            continue OUTER;
        }
        int i = 5;
        //если condition изначально false, то в тело цикла не заходим
        //переменная i видна только в теле цикла
        //update statement -- действия, которые будут выполняться после действия цикла

        for (;;) ; //бесконечный цикл без смысловой нагрузки
    }
    //java не позволяет писать unreachable statement (for when false)
    //но позволяет писать if(false)
}
