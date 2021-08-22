package com.company.Lesson12;

//flow control -- последовательность исполнения
//selection -- мы отбрасываем часть кода которая не нужна при таких условиях

public class Lesson12 {
    public static void main(String[] args) {
        double a = Math.random() * 40;
        if (a > 20) System.out.println("hello");
        else if (a < 20) System.out.println("bye");

        Lesson12 l1 = new Lesson12();
        Lesson12 l2 = new Lesson12();
        boolean b = l1 == l2; //всегда false, потому что если мы сравниваем референсы то сравниваем адреса

        String z = new String("abc");
        String y = new String("abs");

        boolean c = z.equals(y); //значения строк нужно не через == сравнивать

        if (a>20){
            int d = 50; //виден только внутри if
        }

        String x = a>20 ? "hyyy" : "muuu";

        switch ((int) a) {
            case 20: break; // если нет break, то срабатывают все стейтменты включая default
            case 10*3: break;
            default: break; // может быть в люобм месте
            //в case требуется константное выражение, если используются переменные то нужно с final и задавать их сразу
        }
    }

    @Override
    public boolean equals(Object obj) { //equals - мы в классе сами определяем
        return super.equals(obj);
    }
}
