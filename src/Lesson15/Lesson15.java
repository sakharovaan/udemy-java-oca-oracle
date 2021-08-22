package Lesson15;

public class Lesson15 {
    public static void main(String[] args) {
        boolean h = true;
        while (h); // бесконечный цикл если true

        INNER: do {
            System.out.println("s");
        }
        while (h); //проверка после do; по-любому даётся право ответить на первый вопрос
        // если переменная объявлена внутри тела цикла, то она не видна в condition
    }
}
