package com.company.Lesson17;

public class Lesson17 {
    public static void main(String[] args) {
        //StringBuilder -- mutable, то есть его можно изменять
        //во избежание заполнения памяти

        StringBuilder a = new StringBuilder("Hello"); //5 + 16 мест
        StringBuilder b = new StringBuilder(50); //изначально 16 мест, но можно растягивать
        //если нужно расширять место, то создаётся новый массив и копируются
        //CharSequence -- это интерфейс для создания классов со свойствами строки

        a.length();
        a.charAt(0);
        a.substring(0, 5); // возвращает String!
        a.subSequence(0, 5); //отрывок последовательности символов -- на выходе CharSequence
        a.append('a'); //дополняет имеющийся String Builder (in-place)
        a.insert(1, 'a'); //добавляет что-то на позицию
        a.delete(0, 1); //удаляет часть из sb
        a.deleteCharAt(5);
        a.reverse(); //тоже меняет sb
        a.replace(0, 1, "a");
        System.out.println(a.capacity()); //21
        //equals не перезаписан в этом классе (работает как ==, сравнивает по ссылке, а не содержимому)


        //StringBuffer -- похож по свойствам, используется в многопоточных приложениях

    }

    @Override
    public String toString() {
        return super.toString(); //визуализация объекта
    }
}
