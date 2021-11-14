package com.level2.Lesson7;

//ThreadPool сам выбирает, какой поток какую задачу выполняет
//Executor/ExecutorService -- интерфейс

//ScheduledExecutorService -- когда хотим установить расписание на запуск потоков из пула

import java.util.concurrent.*;

public class Lesson7e {
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService eS = new ThreadPoolExecutor(); напрямую обычно не создают
        ExecutorService eS = Executors.newFixedThreadPool(5); //fixedThread или singleThread -- это фабрики, возвращают ThreadPoolExecutor
        //ExecutorService eS = Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++) {
            eS.execute(new RunnableImpl());
        }
        eS.shutdown(); //задач больше не будет и программа завершится после того как все задания завершатся
        eS.awaitTermination(5, TimeUnit.SECONDS); //работает как метод join -- ждём пока executorService завершит работу или пока таймаут не



        ScheduledExecutorService eS2 = Executors.newScheduledThreadPool(1);
        for(int i=0; i<10; i++) {
            //eS2.execute(new RunnableImpl()); //execute работает так же
            eS2.schedule(new RunnableImpl(), 3, TimeUnit.SECONDS); //выполни это задание после 3 секунд
            //eS2.scheduleAtFixedRate() -- чтобы она периодически повторялась, есть initialDelay и period
            //если задача выполняется больше чем период, то шедулер ничего не ждёт
        }
        eS2.shutdown(); //задач больше не будет и программа завершится после того как все задания завершатся
        eS2.awaitTermination(5, TimeUnit.SECONDS);

        ExecutorService eS3 = Executors.newCachedThreadPool(); //создаёт новые потоки по надобности, если остальные заняты
        for(int i=0; i<10; i++) {
            eS3.execute(new RunnableImpl()); //execute работает так же
        }
        eS3.shutdown(); //задач больше не будет и программа завершится после того как все задания завершатся
        eS3.awaitTermination(5, TimeUnit.SECONDS);

    }
}

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()); //в имени потока видим название пула
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}