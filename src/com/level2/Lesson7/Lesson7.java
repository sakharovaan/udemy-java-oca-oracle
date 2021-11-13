package com.level2.Lesson7;

public class Lesson7 {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        System.out.println("thread 1 prio " + thread1.getPriority() + " t2 prio " + thread2.getPriority() );
        // по умолчанию у каждого потока есть приоритет 5 (до 10), но нет гарантии что поток с более высоким приоритетом получит больше времени
        // по умолчанию у потока имя в формате Thread-1

        thread1.start();
        thread2.start(); //потоки не синхронизированы, поэтому они выполняются независимо и числа не чередуются
        //можно запустить два экземпляра одного класса потока

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("privet");
            }
        }).start(); //создать поток с помощью анонимного класса
        //implements Runnable, так как в Java нет множественного наследования, и

        new Thread(() -> System.out.println("privet")).start(); //создание потока с помощью лямбды

        //если run запускать напрямую, то он будет выполняться не в отдельном потоке.
        thread1.join(); //ожидание завершения других потоков
        thread2.join(1500); //main поток будет ждать либо конца работы, либо количество времени, прежде чем продолжит работу

        //ЖЦ потоков: New -> Runnable после вызова start (Ready ждёт ОС-Running) -> Terminated
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i=1; i <= 1000; i++){
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState()); //инфа может быть уже неактуальной, он может быть уже terminated
            System.out.println(i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {// мы не можем здесь throws InterruptedException, потому что в оригинальной перегрузке её нет
        for(int i=1000; i > 0; i--){
            System.out.println(i);
            try {
                Thread.sleep(100); //сон в потоке. второй параметр -- наносекунды
            } catch (InterruptedException e) { //поток может прервать другой поток, нас попросили остановиться, пока мы спали
                e.printStackTrace();
            }
        }
    }
}