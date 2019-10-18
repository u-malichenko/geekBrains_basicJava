package Lession5;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try{
            test(new StringBuffer(""));
            test(new StringBuilder(""));
        } catch (java.io.IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void test(Appendable obj) throws java.io.IOException {
        // указываем текущее время до теста
        long before = System.currentTimeMillis();
        for (int i = 0; i++ < 1e9; ) {
            obj.append("");
        }
        //узнаем текущее время после теста
        long after = System.currentTimeMillis();
        //выводим результат
        System.out.println(obj.getClass().getSimpleName() + ": " + (after - before) + "ms.");
    }
}
