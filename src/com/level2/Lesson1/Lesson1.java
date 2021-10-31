package com.level2.Lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
        //natural order -- лексиграфическое сравнение -- a самые меньшие, z самые большие, от меньшего к большему

        List<Employee> list = new ArrayList<>();
        Employee empl = new Employee(100, "a", "b", 123);
        Employee empl2 = new Employee(15, "b", "c", 233);
        Employee empl3 = new Employee(67, "c", "d", 745);

        // мы можем использовать Arrays.sort, он не требует при колмпиляции имплементации интерфейса Comparable, но будет давать exception в рантайме
        list.add(empl);
        list.add(empl2);
        list.add(empl3);

        System.out.println("Before sorting " + list);

        Collections.sort(list, new idComparator()); //Java не знает как сортировать наш класс, вторым параметром -- компаратор

        System.out.println("After sorting " + list);
    }
}

class Employee{
    int id;
    String name;
    String surname;
    int salary;

    //alt+insert -> Constructor -> выбрать поля
    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    //alt+insert
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    //@Override
    //public int compareTo(Employee anotherEmp) { //должен возвращать int
//        if(this.id == anotherEmp.id) { return 0; }
//        else if (this.id < anotherEmp.id) {return -1;}
//        else {return 1;}



        //return this.id-anotherEmp.id; // другой способ, в основном все так пишут

        //return this.id.compareTo(anotherEmp.id); //ещё один способ, но нужно поменять int на integer

       // return this.name.compareTo(anotherEmp.name);


    //}
}

class idComparator implements Comparator<Employee> { //такая логика что и у compareTo
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int res =  emp1.name.compareTo(emp2.name);
        if (res == 0) {res = emp1.surname.compareTo(emp2.surname); }
        return res;
    }
} // мы можем использовать и compareTo (самый частый вариант) и сделать отдельные компараторы, которые будут перезаписывать метод сортировки
//comparator использует не естественный порядок -- очень рекомендуется для основного compareTo если он возвращает 0, то equals тоже возвращал бы True
//обычно compareTo по id