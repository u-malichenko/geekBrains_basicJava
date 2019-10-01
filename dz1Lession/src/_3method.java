import java.util.Scanner;

public class _3method {
    //3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
    public static void main(String[] args){
        System.out.println("Программа вычисляющая выражение a * (b + (c / d)) и возвращающая результат");
        float aA = readArg("Введите число a: ");
        float bB = readArg("Введите число b: ");
        float cC = readArg("Введите число c: ");
        float dD = readArg("Введите число d: ");

        System.out.println("a * (b + (c / d)) = "+getSum(aA,bB, cC ,dD));
    }
    static float readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        float arg = userInput.nextFloat();
        return arg;
    }

    static float getSum(float a, float b, float c, float d){
        return a * (b +(c/d));
    }
}
