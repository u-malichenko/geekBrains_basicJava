import java.util.Scanner;

public class _4boolean {
    //4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
    public static void main(String[] args){
        System.out.println("Программа, принимающиая на вход два числа, и проверяющая, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false");
        int xX = readArg("Введите первое число: ");
        int yY = readArg("Введите второе число: ");

        System.out.println(getValue(xX,yY));

    }
    static int readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        int arg = userInput.nextInt();
        return arg;
    }

    static boolean getValue(int x, int y){
        boolean result = false;
        if((x * y)>= 10 && (x * y) <= 20){
            result = true;
        }
        return result;
    }
}
