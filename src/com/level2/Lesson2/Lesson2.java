package com.level2.Lesson2;

import java.util.ArrayList;
import java.util.List;

public class Lesson2 {
    public static void main(String[] args) {
        //если мы не указываем тип в массиве ArrayList, то можем добавлять любой тип в него
        //но если мы не указываем тип, то это будет массив типа Object, и нам нужно будет кастить -- raw type
        //мы не сможем проверять на типы

        List<String> list = new ArrayList<>(); //<> - diamond символ, его всегда нужно ставить
        //дженерики позволяют создавать не дубликатный код

        List <X> list1 = new ArrayList<X>(); // ArrayList<Y> не будет работать, потому что совокупность ArrayList<Y> не является подтипом List <X>
        //если бы разрешалось, то мы бы могли в list с "чужим" классом добавлять потомков, которые наследовались бы от класса-родителя

        List<?> list3 = new ArrayList<String>(); //? - wildcard -- вместо ? может быть подставлен любой класс
        //list3.add("as"); -- мы не можем так добавить, потому что компилятор не знает какие у нас объекты в list3, он не может проверить
        //как правило мы не можем выхывать методы, которые изменяют объект, с вайлдкардом

        List<? extends Number> list4 = new ArrayList<Integer>(); //bounded wildcard
    }

    static void hello(List<? extends Number> list){} //можно передавать list с любыми элементами, если они наследуются от Number
    static void bye(List<? super Number> list){} //можно передавать любой суперкласс Number
}

class Pair<V1, V2>{
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirst(){
        return value1;
    }
}

class X{}
class Y extends X{}
class Z <T extends ArrayList>{} //это означает что вместо T мы можем подставить только сабкласс Number

interface I1 {}
interface I2 extends I1{}

class M <T extends ArrayList&I1&I2>{} // нельзя множественное наследнование, но можно несколько интерфейсов так задавать

