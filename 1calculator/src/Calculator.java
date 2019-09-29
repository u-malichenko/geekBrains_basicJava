import java.util.Scanner;
//55
public class Calculator {
    public static void main (String  [] args){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Введите операцию [+, -, /, *]: ");
        String operation = userInput.nextLine();

        System.out.println("Введите первый аргумент: ");
        double argument1 = userInput.nextDouble();

        System.out.println("Введите второй аргумент: ");
        double argument2 = userInput.nextDouble();
        userInput.close();

        switch (operation){
            case "+":
                System.out.println(argument1 + argument2);
                break;
            case "-":
                System.out.println(argument1 - argument2);
                break;
            case "/":
                System.out.println(argument1 / argument2);
                break;
            case "*":
                System.out.println(argument1 * argument2);
                break;
            default:
                System.err.println("Нет такой операции");
                break;
        }
    }
}
