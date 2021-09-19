module javatest { //дескриптор модуля
    exports com.company.Lesson2; // то что модуль его предоставляет
    requires com.company.Lesson2; // то что модулю он нужен для работы (из другого модуля)
}