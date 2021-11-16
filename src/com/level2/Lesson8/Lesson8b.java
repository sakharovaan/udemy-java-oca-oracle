package com.level2.Lesson8;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Lesson8b {
    public static void main(String[] args) {
        //NIO - new i/o. Channels, buffers. Очень богатый API
        //channel связывается с файлом и пишет в buffer. когда мы пишем -- то пишем в buffer
        //datagramchannel, socketchannel, filechannel...


        try(RandomAccessFile randomAccessFile = new RandomAccessFile("hello.txt", "rw"); FileChannel fc = randomAccessFile.getChannel();) {
            ByteBuffer b = ByteBuffer.allocate(25); //text.getBytes().length
            // у буффера есть capacity, position и limit
            // capacity -- блок памяти с определённым размером.
            // position -- позиция, на которой записываем или читаем
            // в режиме записи limit=capacity, в режиме чтения limit -- это сколько было записано

            StringBuilder sb = new StringBuilder();

            int byteRead = fc.read(b);
            while(byteRead>0) {
                System.out.println(" read " + byteRead);
                b.flip(); // flip() -- мы записали всё в буфер, записывать больше некуда, и нам нужно начинать читать с 0 -- меняет режим буфера с записи в чтение и позиция на 0

                while(b.hasRemaining()){
                    sb.append((char) b.get()); //b.put()
                }
                b.compact();

                b.clear(); // clear() -- данные в буфере не очищаются, мы ставим позицию в 0 элемент и записываем поверх старой -- write mode
                byteRead = fc.read(b); //опять читаем информацию из файла и пишем в буфер
            }
            System.out.println(sb);

            //b.rewind() - поместит позицию на ячейку 0, чтобы можно был ещё раз прочитать что уже прочитано
            //b.compact() - перемещает данные между limit и capacity в начало буфера - если было неполная запись и нужно дозаписать - не хотим терять непрочитанные байты, но нужно что-то записать
            //b.mark() - чтобы мы могли возвращаться к позиции в буфере
            //b.reset() - позиция возвращается на отметку

        } catch (IOException e ){
            e.printStackTrace();
        }



    }
}
