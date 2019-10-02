import java.util.Scanner;

public class _6 {
    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    public static void main(String[] args){
        System.out.println("Программа вернет вам Истину если вы введете отрицательное число.");
        int xX = readArg("Введите целое число: ");

        System.out.println(isNegative(xX));
    }

    static int readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        int arg = userInput.nextInt();
        return arg;
    }

    static boolean isNegative(int x){
        return (x < 0);
    }
}
