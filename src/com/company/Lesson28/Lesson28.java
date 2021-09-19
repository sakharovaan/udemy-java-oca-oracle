package com.company.Lesson28;

import java.time.*;
import java.time.format.*;

public class Lesson28 {
    public static void main(String[] args) {
        //LocalDate/LocalTime/LocalDateTime

        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2014, Month.AUGUST, 15).minusMonths(2).plus(Period.ofDays(15)).getDayOfWeek());
        System.out.println(LocalDate.of(2014, Month.AUGUST, 15).minusMonths(2).isBefore(LocalDate.now())); //невозможно с помощью конструктора
        //можно сделать LocalDateTime(LocalDate, LocalTime)

        System.out.println(Period.ofDays(15));
        System.out.println(Duration.ofDays(15)); // то же что и Period, но с меньшими значениями
        //с ними не работает method chaining

        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        System.out.println(df.format(LocalDate.now()));

        DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG); //19 сентября 2021 г.
        System.out.println(df2.format(LocalDate.now())); //ofPattern есть - свой формат

        System.out.println(LocalDate.parse("2020-01-09")); //можно вторым аргументом передавать DateTimeFormatter
    }
}

//enum - специальный класс, который хранит константы
//method chaining
