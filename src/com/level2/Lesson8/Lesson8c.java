package com.level2.Lesson8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Lesson8c {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("hello.txt"); //файлы и папки

        System.out.println(path.getFileName());
        System.out.println(path.getParent()); //null, потому что относительный путь
        System.out.println(path.toAbsolutePath().getParent());
        System.out.println(path.resolve("papa")); //hello.txt\papa
        System.out.println(path.relativize(Paths.get("hello.txt"))); //один путь относительно другого

        System.out.println(Files.size(path));
        // есть метод isSameFile
        System.out.println(Files.getAttribute(path, "creationTime"));
        System.out.println(Files.readAttributes(path, "*")); //возвращает map


        Files.copy(path, Paths.get("asas.txt"), StandardCopyOption.REPLACE_EXISTING); //можно папки копировать, но без содержимого -- это нужно вручную делать
        //move -- перемещение или переименование
        //delete
        //write
        //readAllLines
        Files.write(path, "kuskusuzhemelenka".getBytes(StandardCharsets.UTF_8));
        System.out.println(Files.readAllLines(path));


        //Files.walkFileTree() - Path start -- откуда начинаем, FileVisitor - логика обхода дерева файлов
        //в интерфейсе FileVisitor есть несколько функций-коллбеков, preVisitDirectory/visitFile/postVisitDirectory/visitFileFailed
        Files.walkFileTree(Paths.get("."), new MyFileVisior());


    }
}

class MyFileVisior implements FileVisitor<Path>{ //с помощью этой штуки можно рекурсивно скопировать папку, так как мы получаем все файлы
    //ещё рекурсивно удалять папку

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter " + dir.getFileName());
        return FileVisitResult.CONTINUE; //мы можем указать поведение -- SKIP, CONTINUE (директорию или файлы), TERMINATE
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
