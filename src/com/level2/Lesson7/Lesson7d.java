package com.level2.Lesson7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock; //цель такая что и у synchronized-конструкции

public class Lesson7d {
    public static void main(String[] args) {
        Call call = new Call();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        t1.start();
        t2.start();
    }
}

class Call {
    private Lock lock = new ReentrantLock();
    //optional fairness parameter -- мы можем смотреть чтобы захватывал тред с наибольшим временем ожидаения
    void mobileCall() {
        try{
            if(lock.tryLock()){ //попробовать захватить замок и выполняем код только если захватили
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {

        } finally {
            lock.unlock(); //здесь нам нужно вручную открывать замок, в synchronized замок сам открывается
        }
    }
}

//user threads -- обычно если основной поток main завершается, то мы ждём завершения всех user потоков
//daemon threads -- для предоставления сервисов, при завершении мы не ждём пока они завершатся
//нужно задавать setDeamon(true) после создания потока, но перед запуском. проверить isDeamon

//мы не можем прервать поток напрямую, но можем послать в него сигнал, что мы хотим его прервать с помощью метода interrupt()
//в самом потоке мы можем проверять ifInterrupted(), если он работает -- если он спит, то в нём выбрасывается InterruptedException

class IntThread extends Thread {
    public void run(){
        while (true){
            if(isInterrupted()){
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}