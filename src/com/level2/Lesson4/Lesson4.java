package com.level2.Lesson4;

public class Lesson4 { //внешний класс
    B b; //он задаётся изнутри

    static private int baba = 10;
    //внешний класс может обращаться к private полям nested класса (static->static)
    //внутри класса можно создать интерфейс, внутри интерфейса -- классы и nested interface

    static public class A{
        //статичный nested class. может быть final (без потомков), abstract, наследоваться
        //может обращаться к static private элементам внешнего класса

        static int yetu = baba;
    }

    public class B{
        //static класс не привязан к outer class, а этот привязан
        //когда нам нужно тесно привязать один класс к другому
        //может содержать только non-static элементы
        //может обращаться к private элементам внешнего класса
        //могут быть ещё внутри этого класса inner-классы
    } //inner class

    void bnbnb(final int b){} //я даже забыл что аргументы могут быть final

    public static void main(String[] args) {
        final int abba = 10;

        class C{
            //локальный класс. мы моем в нём потом создавать объект этого класса и использовать его
            //мы вообще никак не увидим этот класс вне этого блока (конструктора или метода)
            //может обращаться к private элементам внешнего класса
            //если элементы блока final/effectively final, то этот класс может обращаться к ним
            public void main(String[] args) { //не может содержать static
                System.out.println(abba);
            }
        }
    }
    //ещё есть анонимные классы
    //внутренний класс имеет доступ даже к private переменным своего внешнего класса

    Lesson4(){
        this.b = this.new B(); //так объявляется объект внутреннего класса
    }
}

class GusiGusi{
    public static void main(String[] args) {
        Lesson4.A a = new Lesson4.A(); //мы не можем создавать класс из экземпляра класса Lesson4, только из Lesson4

        Lesson4 l4 = new Lesson4();
        Lesson4.B b = l4.new B(); //создаём экземпляр nested класса из экземпляра внешнего класса
        Lesson4.B b2 = new Lesson4().new B(); //господи боже, и даже так. но обычно отдельно создаётся объект внешнего класса

    }

    void test(){}
}

class Ahaha{
    public static void main(String[] args) {
        GusiGusi gagaga = new GusiGusi(){ //анонимный класс
            @Override
            void test(){}
        }; // создал класс, в котором перегрузил методы другого класса, так же можно интерфейсы имплементировать
        //можем так насоздавать классов с разными свойствами. зачем писать новый класс, если его можно создать на ходу?
        //если мы его используем один раз
        //можем обращаться к private элементам внешнего класса
        //lambda expressions -- краткая форма записи анонимных класса
        //нет анонимных интерфейсов

    }
}