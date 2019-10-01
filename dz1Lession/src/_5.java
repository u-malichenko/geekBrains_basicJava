import java.util.Scanner;

public class _5 {
    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
    public static void main(String [] args){
        System.out.println("Программа для определения положительное и лиотрицательное число ввел пользователь");
        int a = readArg("Введите число: ");

        getAbs(a);
    }
    static int readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        int arg = userInput.nextInt();
        return arg;
    }

    private static void getAbs(int val){
        String absVal;
        absVal = (val <0) ? " отрицательное." : " положительное.";
        System.out.println("Число " + val + absVal);
    }
}
