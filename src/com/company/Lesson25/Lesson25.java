package com.company.Lesson25;

public class Lesson25 {
    //полиморфизм - способность объекта принимать множества форм
    //объект полиморфный -- если у него больше одной связи is-a
    //способность метода вести себя по-разному в зависимости от того, объект какого класса вызывает метод
    //перезаписанные методы часто называют полиморфными

    public static void main(String[] args) {
        //instanceof ~ type(obj) is cls
        //ищет по сабклассам и интерфейсам

        //сasting - переменная одного типа как переменная другого типа

    }
}
class L3 extends Lesson25 {

}

class L2 extends Lesson25 {
    public int a=5;

    public static void main(String[] args) {
        //Implicit casting/ widening casting. - from a narrower range data type to a wider range data type. - Upcasting
        Lesson25 b = new L2();

        //Explicit type casting - Downcasting - если хотим чтобы переменная суперкласса имела доступ к методам потомка
        L2 l = (L2) b;
        int c = ((L2) b).a;
        //если не проверять instanceof, и закастовать через downcasting то между чем нет отношений, то выскочит exception

        //таким образом можем сравнивать объекты разных классов
        //в массивах тоже можно

        Lesson25 [] d = new L2[1];
        L2 [] n = (L2[]) d;

        //если хотим вызвать метод из "дедушки", нужно сделать кастинг в него
        //даже если мы делаем кастинг, Java будет вызывать в рантайме методы из класса, который был до кастинга

        //для примитивных типов данных - widening (из меньшего типа в больший)
        //narrowing - сужение - чтобы без кастинга - int в byte,short,char; если int константа; если int влезает
        //double->int отрубает дробную часть
        //если прибавить 1 к максимальному значению int, оно будет отрицательным (циклически)

        //Numeric promotion - int+long=long. автоматом в дробный. ++byte != int
    }
}