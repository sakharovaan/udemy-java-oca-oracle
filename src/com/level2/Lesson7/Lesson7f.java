package com.level2.Lesson7;

import java.util.concurrent.*;

public class Lesson7f {
    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService eS = Executors.newSingleThreadExecutor();
        Factorial f = new Factorial(5);
        eS.execute(f);
        eS.shutdown();
        eS.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(Lesson7f.factorialResult);

        ExecutorService eS2 = Executors.newSingleThreadExecutor();
        CallableFactorial f2 = new CallableFactorial(5);
        Future<Integer> future = eS2.submit(f2); //в future хранится результат выполнения, submit вместо execute
        try {
            System.out.println(future.isDone());
            Integer fR = future.get(); //если мы вызываем get, то наш поток будет заблокирован пока мы не получим результат
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        } catch (ExecutionException e ){
            System.out.println(e.getCause());
        } finally {
            eS2.shutdown();
        }
        eS2.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(Lesson7f.factorialResult);

        //мы можем submit использовать и на Runnable, но он тогда всегда будет возвращать void
        //на основе Callable нельзя сделать тред
        //Runnable если нам не нужно возвращать значение, Callable если нужно
        //Future f3 = eS.submit(f);

        //мы можем делать List<Future<Long>>, и в него класть результаты через add()
        //и потом в for-each получаем через .get() из этих future
    }
}

class Factorial implements Runnable {
    int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public void run() { //у run returnType void, поэтому приходится использовать внешнюю переменную, плюс мы не можем выбрасывать исключение
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result*=i;
        }
        Lesson7f.factorialResult = result;
    }
}

class CallableFactorial implements Callable<Integer>{ // returntype не void,
    int f;

    public CallableFactorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f<=0){
            throw new Exception("No");
        }
        int  result = 1;
        for (int i = 1; i <= f; i++) {
            result*=i;
        }
        return result;
    }
}