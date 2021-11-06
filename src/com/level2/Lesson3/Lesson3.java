package com.level2.Lesson3;

import java.util.*;

// в коллекции содержатся дженерики -- коллекция марок, коллекция значков
//Collections -- это класс с utility-методами, Collection -- интерфейс
public class Lesson3 {
    //List - упорядоченная последовательность элементов, позволяющая хранить дубликаты и null. Каждый элемент имеет индекс
    //ArrayList -- это массив, который может изменять свою длину

    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<>(); // не можем создавать с примитивными типами, int -> Integer
        ar.add(0, "test"); //нельзя добавить боль
        System.out.println(ar.get(0));
        ar.set(0, "fest");
        System.out.println(ar.get(0));
        ar.remove(0); // можно удалять посередине, можно удалять объект (сравнение через equals, то есть по умолчанию по адресу в памяти)
        //ar.addAll() -- добавление одного массива в другой
        //.indexOf(), .lastIndexOf(), .clear(), .size, .isEmpty()
        System.out.println(ar.contains("Psd"));

        StringBuilder sb1 = new StringBuilder("A");
        List<StringBuilder> ls = Arrays.asList(sb1, sb1); //связан с sb1
        System.out.println(ls);
        //ls.removeAll(); -- удалить все элементы, которые есть в аргументе в словаре, retainAll() -- наоборот
        //ls.subList(from, to) -- view (связан с исходным листом)

        //List.of(E...) -> List<E> // copyOf -- на выходе List, эти элементы невозможно изменить
        List<Integer> l1 = List.of(1, 2, 3); //по-быстрому без add. Этот list не поддерживает .add
        //нельзя в этих массивах использовать null

        //ИТЕРАТОРЫ
        Iterator<String> it = ar.iterator();
        while (it.hasNext()){
            System.out.println(it.next()); //выдаёт элемент
            it.remove(); //обязательно нужен сначала next
        }

        //LinkedList -- каждый элемент знает что идёт до и после него, есть ещё head и tail
        StringBuilder sb2 = new StringBuilder("B");
        LinkedList<StringBuilder> ll = new LinkedList<>();
        ll.add(sb1); ll.add(sb2);
        //doubly -- каждый элемент в обе стороны ссылки, singly -- когда в одну сторону
        //вставка -- просто изменение ссылок у двух соседних элементов
        //ll.descendingIterator();
        //ll.listIterator(ll.size()).previous(); //hasPrevious - с конца в начало
        //ll.pollLast(); ll.peekLast(); - получает последний элемент с удалением или без него
        //используем когда невелико количество операций получения, но велико количество добавления и удаления (особенно в начале)


        "".toCharArray(); //из строки в массив Char

        //Collections.binarySearch() -- бинарный поиск, -1 если не найден. Требует отсортированный массив
        //чтобы искать по нашим классам, они должны реализовывать интерфейс Comparator
        Collections.shuffle(ll);
        Collections.reverse(ll);

        //ArrayList очень быстро получает значения, потому что мы знаем размер каждого элемента
        //но ArrayList O(n) для получения, потому что до этого элемента нужно ещё дойти - не можем использовать формулу


        //VECTOR - не рекомендован, предназначен для многопоточности (synchronized). Блокировка другого пользователя. Много устаревших методов
        Vector<StringBuilder> v = new Vector<>();
        v.add(sb1); v.firstElement(); v.lastElement();


        //STACK - устаревший LIFO класс (стек функций)
        Stack<StringBuilder> s = new Stack<>();
        s.push(sb1);
        System.out.println(s.pop());


        //HASHMAP - пары - ключ/значение. Не запоминает порядок. Работает очень быстро
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "abc");
        System.out.println(m);
        //ключи должны быть уникальными, значения могут повторяться. ключи и значения могут быть null
        m.put(null, null);
        //если сделаем put с таким же ключом, то значение перезапишется по этому ключу
        m.putIfAbsent(1, "abc"); //не добавляет элемент, если такой ключ уже еть
        m.remove(1);
        m.containsKey(1); //containsValue
        m.keySet(); //возвращает множество (Set) ключей
        m.values(); //множество значений
        System.out.println(m.entrySet()); //пары ключ-значение
        //в основе HashMap массив, элементы которого -- LinkedList,которые заполняются элементами. Элементы -- ноды или entry
        //первое поле node -- хэш-код, второе поле -- ссылка на следующий элемент с этим же хэшкодом (linkedlist), если его нет -- то null
        //можно сказать, что мы разделяем linkedlist на несколько маленьких листов
        for (Map.Entry<Integer, String> e: m.entrySet()) {
            System.out.println(e.getKey() + e.getValue());
        }
        //параметры hasmap
        //initial capacity: начальный размер массива;
        //load factor - коэффициент, насколько массив должен быть заполнен, после чего его размер будет увеличен вдвое
        Map<Integer, String> m2 = new HashMap<>(16, 0.75f); //это значения по умолчанию.
        //после добавления 12 элементов массив будет рехэширован заново. экономия памяти/экономия времени
        //элемент массива с одним хэш-кодом -- бакет
        //чем лучше реализован метод hashCode, тем ближе время поиска к O(1), худшее - O(n)
        //после достижения определённого порога, значения начинают храниться в сбалансированных деревьях
        //hash должен быть immutable, то есть хэш должен быть неизменяемым -- мы не найдём ключ по этому значению
        //делать final для полей, которые участвуют в получении хэша
        //hashmap не предназначена для многопоточности, для этого есть concurrenthashmap


        //TREEMAP -- элементы хранятся в отсортированном по ключу массиве.
        //В основе красно-чёрное дерево, оно работает быстро, но не так быстро как hashMap -- O(log n)
        //ключи должны быть уникальными
        //put/get/remove
        //descendingMap - сортировка по убыванию
        //tailMap или headMap -- от элемента до конца/начала
        //first/lastEntry
        //основная цель -- нахождение ренджей
        //нужно чтобы элементы реализовывали Comparable
        TreeMap<StringBuilder, Double> tm = new TreeMap<>();


        //LINKEDHASHMAP - хранит информацию о порядке добавления и использования. Производительность немного ниже
        //ссылки на предыдущий и следующий добавленный элемент
        //есть третий параметр accessOrder (по умолчанию false) -- порядок будет меняться в зависимости от использования -- последние те которые использовали последним
        LinkedHashMap<Double, StringBuilder> lhm = new LinkedHashMap<>();


        //HASHTABLE -- устаревший класс, как HashMap, но synchronized (потокобезопасный) -- методы медленнее
        //ни ключ, ни значение не могут быть null
        //ConcurrentHashMap -- новый класс


        //SET -- коллекция, хранящая только уникальные элементы, её методы очень быстры. В основе урезанная версия Map
        //ключи -- это значения Set
        //нам не нужно value, чтобы хранить элементы, в качестве значения будет какая-то заглушка (константа)
        //можем хранить null
        //add, remove, size, isEmpty, contains, нет метода get
        //есть операции union (.addAll), intersect(.retainAll), substract(.removeAll)
        Set<String> set = new HashSet<>();
        set.add("hello");


        //TREESET -- как set, но в основе treemap (отсортированные)
        //headSet, tailSet -- то есть больше/меньше или равно значения


        //LINKEDHASHSET -- нет возможности запоминать элементы в зависимости от времени использования


        //QUEUE -- DEQUE(linkedlist/arraydeque) и abstractqueue (priorityqueue)
        //базовый интерфейс для последовательности обработки
        //not synchronized
        Queue<String> q = new LinkedList<>(); //Queue это интерфейс
        //add, offer -- если наша очередь полная, то offer не выкидывает исключение, а add выкидывает
        //poll -- в случае если элементов нет, то возвращает null, а remove -- выбросит исключение
        //element -- первый элемент в очереди выкидывает исключение, poll -- не выбрасывает exception
        //можно удалять из середины очереди, но так лучше не делать


        //PRIORITYQUEUE - c натуральной сортировкой или той, которая задана компаратором
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("hello");
        //когда выводим на экран, то нет сортировки, но когда используем, то она работает
        //есть конструктор, который принимает на вход компаратор
        //вне зависимости от порядка добавления, используется элемент с наивысшим приоритетом


        //DEQUE -- в обычной очереди добавляем только в конец, в этой очереди -- и в начало
        Deque<String> dq = new ArrayDeque<>(); //интерфейс реализован LinkedList и ArrayDeque
        //addFirst, addLast, offerFirst, offerLast (add выкидывает искл, offer нет)
        //remove/poll Last/First (remove выкидывает искл, poll нет)
        //get/peek Last/First (get выкидывает искл, peek нет)
        dq.offerFirst("hello");
        dq.addLast("bye");
        dq.pollLast();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
        //когда переопределяем equals, то нужно переопределять и hashcode - потому что по умолчанию хэширование по адресу
        //hashCode преобразует объект в int
        //сравнение в hashMap идёт сначала по хэшу, потом по equals

        //чтобы было меньше коллизий (например, если хэш - длина строки), то часто умножаем на единицу

        //если equals возвращает true, то хэш объектов должен быть равным
        //если equals = false, то хэш не обязательно разный - но лучше чтобы коллизий было как можно меньше - количество int всё равно конечно
    }
}
