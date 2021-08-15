package com.company.Lesson2;

public class PrimitiveDataType {
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 'a';

        long l2 = 10000L;
        float f2 = 87.65f;
        // double по умолчанию создаётся

        char c1 = 500; // 10-ричная
        char c2 = '\u05AB'; //16-ричная

        int a4 = 0b111100;
        int a5 = 074; //8-ричная
        int a6 = 0x3C; //16-ричная

        int a7 = 1_000_000_0; //_ для удобства, не в начале и конце, не около точки в дробных, не около l/f/d/0x/0b, но можно после 0_ в 8-ричном

        System.out.println(b2);
    }
}
