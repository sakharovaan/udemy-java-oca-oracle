package com.level2.Lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson6 {
    public static void main(String[] args) { //stream -- последовательность элементов, поддерживающая параллельную и последовательную обработку
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b0");

        // из потока со значениями мы получили поток длин
        List<Integer> l2 = list.stream().map(elem -> elem.length()).collect(Collectors.toList()); //методы stream не меняют сами исходные элементы
        //есть Collectors.toSet (если treeset то отсортирует). Мы можем например так из Set сделать List
        System.out.println(l2);


        System.out.println(list.stream().filter(elem -> elem.length() == 1).collect(Collectors.toList())); // filter фильтрует по true/false

        list.stream().forEach(System.out::println);

        Stream<String> ms = Stream.of("a", "b", "c");
        ms.filter(String::isEmpty); //один раз только можно его использовать

        System.out.println(list.stream().reduce((acc, elem) -> {
            return acc += elem;
        }).get()); //возвращает ab0 -- один аккумулятор используется для всех элементов
        //Optional - контейнер для возвращаемого аккумулятора, может быть null

        Optional<String> o = list.stream().reduce((acc, elem) -> {return acc += elem;}); //безопасный метод
        if(o.isPresent()){
            System.out.println(o.get());
        }

        //первым параметром мы задаём начальное значение, это меняет синтаксис (нет Optional, потому что в любом случае не null)
        String s = list.stream().reduce("baba", (acc, elem) -> {return acc += elem;});
        System.out.println(s);


        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().sorted((x, y) -> x.length() - y.length()).collect(Collectors.toList())); // если наши классы, то нужно компаратор


        //method chaining
        //sorted ещё
        //source -> промежуточные методы (lazy) -> терминальные матоды (eager)
        //у lazy на входе и выходе stream, они не будут исполнены пока не будет исполнен терминальный метод (forEach, например)
        //терминальные возвращают либо void, либо что-то отличное от stream
        //redice, forEach, collect -- териминальные; map, filter, sorted -- промежуточные
        Integer a = list.stream().map(e -> e.length()).filter(length -> length > 2).reduce(0, (acc, elem) -> {return acc += elem;});
        System.out.println(a);

        //distict -- промежуточный -- уникальные элементы
        //count -- terminal -- количество элементов
        //peek -- intermediate метод, позволяет отладить пайплайн стримов
        System.out.println(list.stream().peek(System.out::println).distinct().count());


        //flatMap -- позволяет объединять вложенные стуктуры как один поток, объединяем их потоки
        list.stream().flatMap(e -> e.lines()).forEach(e-> System.out.println(e));


        //collect -- groupingBy/collectioningBy
        //группирует элементы потока по заданным ключам, возвращает hasmap (key=[array])
        //paritionBy -- принимает boolean и разделяет на true и false (ключи это boolean)
        //Map<Boolean, List<String>> mao
        System.out.println(list.stream().collect(Collectors.groupingBy(e->e.substring(1))));

        //findFirst -- terminal -- первый элемент stream
        //возвращает Optional
        list.stream().findFirst().get();

        //min и max -- terminal -- нужно обязательно указывать компаратор
        list.stream().min((x, y) -> x.length()-y.length()).get();

        //limit -- intermediate -- ограничивает число элементов в стриме, возвращает стрим
        list.stream().limit(20);

        Stream<String> s2 = list.stream();
        System.out.println(s2.limit(1).collect(Collectors.toList()));
        //System.out.println(s2.limit(1).collect(Collectors.toList())); -- к сожалению не работает

        //skip -- intermediate -- если limit берёт первые n элементов, то skip будет пропускать первые n элементов
        list.stream().skip(20);

        //mapToInt -- intermediate -- возвращает после себя стрим из Integer
        //есть mapToDouble и тп
        //boxed -- конвертирует int в Integer
        //average -- возвращает Optional<double>
        //getAsDouble для average, getAsInt - для min/max
        list.stream().mapToInt(e->e.length()).average().getAsDouble();


        //по умолчанию поток последовательный (sequential), параллельный -- многоядерный
        //в параллельных потоках части задания выполняются на разных ядрах и объединяются
        //java делает это сама, нам не нужно свои потоки плодить
        //не подходит для операций, где важна последовательность, и для небольших заданий
        list.parallelStream().mapToInt(e->e.length()).average().getAsDouble();
        //неправильно работает когда есть reduce с аккумулятором
        //параллельные стримы лучше использовать когда нужно ускорить уже имеющиеся процессы
    }
}
