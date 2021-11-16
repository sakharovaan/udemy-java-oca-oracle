package com.level2.Lesson8;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Lesson8 {
    public static void main(String[] args) throws IOException {
        //Stream -- не стримы массивов, они будут помогать писать или читать информацию
        //разные стримы для текстовых и бинарных файлов

        String a = "hello";
        FileWriter wr=null;

        try {
            wr = new FileWriter("hello.txt", false); //абсолютный или относительный путь
            //append=true
            for (int i = 0; i < a.length(); i++) {
                wr.write(a.charAt(i));
                wr.write(a); //string будет разбиваться на симфолы
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            wr.close(); //иначе не запишется
        }

        FileReader r = null;
        try{
            r = new FileReader("hello.txt");
            int charact;
            while((charact=r.read())!=-1) { //интересная техника
                System.out.println((char)charact);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        try(FileWriter wr2=new FileWriter("hello.txt", false); FileReader wr3= new FileReader("hello.txt")) { // типа with в питоне
            wr2.write('a');
        } catch (IOException e) {
            e.printStackTrace();
        } // ресурс, который мы используем в try with resources, должен имплементировать интерфейс AutoClosable


        //BufferedReader/Writer -- загружает файл частями. Это обёртки. Обычный FR посимвольно читает
        try(BufferedReader br = new BufferedReader(new FileReader("hello.txt"))) {
            int charact;
            while((charact=br.read())!=-1) { //интересная техника
                System.out.println((char)charact);
            }
        } catch (IOException e ){
            e.printStackTrace();
        }


        //File[Input/Output]Stream -- для работы с бинарными файлами, такой же принцип работы как и с FileReader
        //Data[Input/Output]Stream -- примитивные типы данных
        //writeByte,writeShort,writeLong,writeFloat,...; такие же методы для чтения значений
        try(DataInputStream dr = new DataInputStream(new FileInputStream("hello.txt"))) {
            int charact;
            while((charact=dr.readByte())!=-1) { //интересная техника
                System.out.println((char)charact);
            }
        } catch (IOException e ){
            e.printStackTrace();
        }


        //сереализация -- преобразование объекта в последовательность байт
        //Object[Input/Output]Stream -- для этого
        //write/readObject -- возвращает object, поэтому нужно делать кастинг
        //чтобы сериализировать объект -- нужно имплементировать Serializable -- это интерфейс-метка без методов
        //все поля в классе, который мы сериализируем, тоже должны имплементить serializable
        //serialVersionUID -- для проверки версии классов, чтобы они были одинаковые
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hello.bin"))) {
            List<String> e = new ArrayList<>();
            e.add("hello");

            oos.writeObject(e);
        } catch (IOException e ){
            e.printStackTrace();
        }


        //RandomAccessFile -- читать и писать в любое место файла
        //у него есть курсор (pointer)
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("hello.txt", "rw")) {
            System.out.println((char) randomAccessFile.read());
            randomAccessFile.seek(0);
            System.out.println((char) randomAccessFile.read());
            randomAccessFile.seek(0);
            System.out.println(randomAccessFile.readLine());
            System.out.println(randomAccessFile.getFilePointer());
            randomAccessFile.writeChars("JavaIsSchizophrenia");
        } catch (IOException e ){
            e.printStackTrace();
        }


        //File -- управление информацией о файлах и каталогах, удаление/права/создание
        //exists, length, createNewFile
        //delete -- из папки нужно сначала удалить содержимое. если нет, то возвратит false
        //.listFiles()
        File f = new File("hello.txt");
        System.out.println(f.getAbsolutePath());

    }
    static final long serialVersionUID=0; //лучше не полагаться на автоматическое создание и делать самостоятельно
    transient int b; //не попадает в сериализованный фаил
}
