package com.level2.Lesson7;

//low-level синхронизация -- когда мы сами открываем и закрываем мониторы
//Semaphore -- можно задавать количество потоков, которые одновременно исполняются

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson7g {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(2);
        s.acquire(); //поток заблокирован пока семафор не разблокирован
        System.out.println(s.availablePermits());
        s.release(); //всегда в finally надо
        System.out.println(s.availablePermits());
        //мы можем передавать этот семафор в конструктор

        CountDownLatch cd = new CountDownLatch(1); //передаём количество изначальных операций
        //потоки ждут, пока не будет выполнено определённое количество операций -- то есть это обратный семафор
        cd.countDown();
        System.out.println(cd.getCount());
        cd.await();
        //у нас например есть список из трёх операций, и каждая из операций будет уменьшать на 1

        Exchanger<Integer> ex = new Exchanger<>(); //поток отправляет данные и блокируется в ожидании ответа от другого потока
        //потоки должны обмениваться информацией в один момент
        //Integer reply = ex.exchange(2); -- потоки по сути одновременно должны вызвать этот метод чтобы обменяться данными

        AtomicInteger ai = new AtomicInteger();
        //synchronized -- тяжёлая штука, потому что каждый раз происходит блокировка/разблокировка интерфейса
        //можно работать с int, используя атомарные операции
        ai.incrementAndGet();
        //synchronized уже не нужна
        ai.getAndIncrement();
        ai.addAndGet(5); ai.getAndAdd(10);


        //synchronized -- обёртываем классические коллекции, concurrent -- изначально созданы для многопоточности
        //Collections.synchronizedList -- используют блокировки для разграничения работы потоков, в один момент времени только один
        //у concurrent коллекций производительность выше
        List<Integer> sl = Collections.synchronizedList(new ArrayList<>());
        //если мы одновременно попытаемся изменять несинхр лист -- будет ConcurrentModificationException
        //интераторы сбоят в многопоточном приложении -- если один использует iterator.hasNext(), а другой меняет, то будет даже в синхр
        //чтобы такого не было, нужно полностью блокировать потоки на время перебора - оборачивать в synchronized(sl)

        //ConcurrentHashMap<-ConcurrentMap<-Map
        //делит множество элементов на сегменты, и ПРИ ИЗМЕНЕНИИ блокирует не всю коллекцию, а только конкретный сегмент
        //любое количество может читать без блокировки
        //можно рассматривать как группу hashmap'ов
        //null нельзя добавлять
        HashMap<Integer, String> map = new HashMap<>();


        //CopyOnWriteArrayList - интерфейс List - небольшое количество операций по изменению и большое количество по чтению
        //при каждом изменении коллекции создаётся копия list
        CopyOnWriteArrayList<Integer> cow = new CopyOnWriteArrayList<>();
        //то есть старые итераторы возвращают элементы в коллекции на момент создания интератора

        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(4); //мы задаём изначально размер очереди
        //потокобезопасная очередь с ограниченным размером (capacity restricted)
        //один или несколько потоков в конец очереди, а другие из начала очереди
        abq.add(1);
        abq.put(5); //в конец
        System.out.println(abq);
        System.out.println(abq.take()); //из начала

    }
}
