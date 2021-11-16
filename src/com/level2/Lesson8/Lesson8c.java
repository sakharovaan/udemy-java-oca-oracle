package com.level2.Lesson8;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lesson8c {
    public static void main(String[] args) {
        Path path = Paths.get("hello.txt"); //файлы и папки

        System.out.println(path.getFileName());
        System.out.println(path.getParent()); //null, потому что относительный путь
    }
}
