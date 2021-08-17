package com.company.Lesson7;
// package - папка, java-класс - файл
//класс хранится в пакете, пакет -- в родительском пакете
//цели пакета -- защита доступа и чтобы можно было использовать одинаковые имена в разных пакетах (неймспейсы) и чтобы связанные классы были в одном месте
//внутри пакета мы видим классы из всех файлов этого пакета
//мы можем обратиться к другому пакету через Package.Class, но тогда конструктор/метод должен быть public
//внутри пакета не может быть двух классов с одним именем
//всегда должен указывать полное имя от верхнего пакета
//не указывать в имени файла пакет -- плохо, потому что мы не сможем обратиться из другого пакета
//без package -- попадает в дефолтный пакет

public class Lesson7 {
    public int foo; // видны отовсюду, в том числе из другого пакета
    private int bar; //даже классы в этом пакете не видят
    protected int zoo; //похож на default, виден внутри пакета + виден для потомков (детей) этого класса в любом пакете
    // если не пишется access modifier - default access modifier -- виден только внутри пакета

    public static void main(String[] args) {
        com.company.Lesson5.Test5 test = new com.company.Lesson5.Test5("aaa");
        // у класса есть только public и default, класс не может быть private
    }
}
