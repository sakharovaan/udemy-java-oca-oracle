package com.level2.Lesson7;

//concurrency - петь и кушать, либо одно, либо другое -- согласованность -- context switching
//concurrency через parallelism (частный случай) -- готовить и говорить по телефону -- одновременно
//это не антонимы

//асинхронное программированное -- мы не ждём завершения каждой задачи. синхронное --

//недетерминированное поведение -- потому что мы не можем заранее определить порядок выполнения

public class Lesson7b {
    volatile int abba;
    //может возникнуть проблема, что в кэше процессора будет неактуальное значение переменной, которая была изменена другим потоком
    //переменные volatile не хранятся в кэше процессора, они обращаются при чтении напрямую к памяти
    //volatile работает корректно когда только один поток может изменять, а остальные только читать

    //операция изменения не атомарная, потоки могут одновременно изменить значение исходя из устаревшего понимания состояния, которое приведёт к конфликту -- data race
    //чтобы не было data race, нужны примитивы синхронизации -- lock

    synchronized void baba(){ //synchronized-блоки. по умолчанию синхронизация на объекте this
        this.abba = 0;
        //этот метод может одновременно исполнять только один поток
        //в нём можно безопасно изменять переменные
    };
    //монитор -- механизм, с помощью которого достигается корректная работа при синхронизации
    //у любого объекта и класса есть привязанный к нему монитор -- который помечается как свободный или занятый
    //монитор должен быть свободный, чтобы с ним можно было работать -- кто первый займёт монитор, тот и работает
    //мы определяем монитор на класса, а не на каком-то коде -- для синхронизации метода используется монитор класса


    public int getAbba() {
        synchronized (this){ //мы пишем блок, который будет исполняться только одним потоком
            //в этом вызове this -- объект, монитор которого мы используем для сихронизации (текущий класс)
            System.out.println("i am the only one");
        }

        synchronized (Counter.class){} //если метод static, то мы используем объект класса
        return abba;
    }

    static final Object lock = new Object(); //мы можем объявлять вот такой объект, по которому будем синхронизироваться

    public static void main(String[] args) {
        synchronized (lock){};
        //синхронизировать конструктор нельзя -- он уже синхронизирован
        Awawaw ri = new Awawaw();
        Thread t1 = new Thread(ri); // в аргументе -- target
        Thread t2 = new Thread(ri);
        Thread t3 = new Thread(ri);

        t1.start(); t2.start(); t3.start();
    }
}

class Counter {
    volatile static int count = 0;
}

class Awawaw implements Runnable {
    public synchronized void increment(){
        Counter.count++;
        System.out.println(Thread.currentThread().getName() + " " + Counter.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Counter.count); // не синхронизирован
            synchronized (this){
                Counter.count++;
                System.out.println(Thread.currentThread().getName() + " " + Counter.count + " ");
            }
            //increment();
        }
    }
}