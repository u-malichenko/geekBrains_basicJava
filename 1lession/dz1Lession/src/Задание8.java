import java.util.Scanner;

public class Задание8 {
    // Задание 01 - метод main
    public static void main(String[] args) {
        // Задание 02 - типы данных
        byte bytevar = 64;
        short shortvar = 32766;
        char charvar = 'W';
        int intvar = 777;
        long longvar = 777L;
        float floatvar = 3.14f;
        double doublevar = 3.14;
        boolean booleanvar = true;
        String stringvar = "Hello, World!";

        // Интерактив для заданий 03 - 08
        int a = getInteger("Задание 03. Введите целое число а: ");
        int b = getInteger("Введите целое число b: " );
        int c = getInteger("Введите целое число с: ");
        int d = getInteger("Введите целое число d: ");
        System.out.println("Результат задания 03 равен " +  formula(a, b, c, d));

        int x = getInteger("Задание 04. Введите целое число х: ");
        int y = getInteger("Введите целое число у: ");
        System.out.println("Результат задания 04 : " +  sumLimit(x, y));

        x = getInteger("Задание 05. Введите целое число х: ");
        numberSign(x);

        x = getInteger("Задание 06. Введите целое число х: ");
        System.out.println("Результат задания 06 : " +  isBelowZero(x));

        String name = getString("Задание 07. Введите имя: ");
        sayHello(name);

        int year = getInteger("Задание 08. Введите год для проверки на високосность: ");
        isLeapYear(year);
    }

    // Задание 03 - вычисление формулы
    static double formula(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // Задание 04 - проверка на предел суммы 10 и 20
    static boolean sumLimit(int x, int y) {
        return ((x + y) >= 10) && ((x + y) <= 20);
    }

    // Задание 05 - определение знака числа
    static void numberSign(int x) {
        String result = (x < 0) ? "Число отрицательное" : "Число положительное";
        System.out.println(result);
    }

    // Задание 06 - проверка на отрицательность числа
    static boolean isBelowZero(int x) {
        return (x < 0);
    }

    // Задание 07 - вывод привествия
    static void sayHello(String name){
        System.out.println("Привет, " + name + "!");
    }

    // Задание 08 - проверка года на високосность
    static void isLeapYear(int year){
        String result = (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) ? "високосный": "не високосный";
        System.out.println("Год " + year + " - " + result);
    }

    // пользовательский ввод
    static int getInteger(String request) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(request);
        int result = userInput.nextInt();
        return result;
    }

    static String getString(String request) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(request);
        String result = userInput.nextLine();
        return result;
    }
}
