package com.level2.Lesson7;

//low-level синхронизация -- когда мы сами открываем и закрываем мониторы
//Semaphore -- можно задавать количество потоков, которые одновременно исполняются

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

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
    }
}
