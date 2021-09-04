package com.company.Lesson20;
import java.util.*;

public class Lesson20 {
    public static void main(String[] args) {
        //ArrayList это List
        //когда нужна структура, похожая на массив, но если нужно увеличивать-уменьшать длину
        //в основе arraylist лежит list
        //все классы -- наследники класса Object

        ArrayList list = new ArrayList();
        list.add("hi"); //return всегда boolean=true


        ArrayList <String> list2 = new ArrayList<String>(); //указываем конкретный тип, который будет содержать - для типобезопасности
        //нельзя в ArrayList добавлять примитивные типы, но можно обёртки на них
        //set, get, remove - по индексу или значению (bool удалился ли)
        //addAll - добавляет другой ArrayList
        //clear - очищает
        //indexOf - возвращает индекс первого обнаруженного элемента
        //size, contains -> bool
        //toString() - красивое, рекурсивно запрашивает вложенные toString
        //clone() - возвращает object (ArrayList<StringBuilder>)list1.clone() -- их переменные ссылаются на одни объекты
        //toArray - array на те же объекты = можно либо указать конструктор в аргументах (new String[5]), либо будет Object[]
        //asList(тип []) - List<тип>
        //removeAll(list) - удалить из первого листа все аргументы, которые находятся в листе в аргументе
        //retainAll(list) - сохранить только те элементы в первом, которые есть в аргументе
        //containsAll(list) - содержит ли все элементы второго
        //subList(int from, int to) - возвращает отрывок как List. List <String> sublist = arr.subList(1,4)
        //саблист это не отдельный List, это view -- например можно добавить в саблист элемент и он добавится в нужное место в ArrayList
        //но нам нужно менять только view, не arraylist - иначе будет ConcurrentModificationException
        //List.of(E ... elements) ->List<E> / List.copyOf(Collection <E> c) -> List <E>
        // List <String> list = List.of("1","2")

        //Collections.sort(ArrayList) -- inplace

        //Collections - List (индекс, в конец, дублирование), Set, Queue; Map
        //LinkedList - каждый элемент знает своего соседа -- чтобы вывести элемент нужно пробежаться по всем
        //Set - не содержит дубликатов и позиции - HashSet и TreeSet
        //Queue - Fifo; Deque - Lifo
        //Map - пара kv - HashMap и TreeMap

        Map<Integer, String> map = new HashMap<>();
        map.put(777, "test"); //строгое соответствие

        Iterator <String> it = list2.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }

        //Arrays.compare(list, list2); - лексикографическое сравнение, два массива одинакового типа -> >0 когда первый массив меньше второго. 0 когда одинаковые
        //префикс -- общая передняя часть двух массивов

        //Arrays.mismatch - -1 если одинаковые, иначе индекс элемента с первым расхождением
    }
}
