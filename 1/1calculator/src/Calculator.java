import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        double argument1 = readDoubleArgument("Введите первый аргумент: ");
        double argument2 = readDoubleArgument("Введите второй аргумент: ");
        String operation = readStringArgument("Введите операцию [+, -, /, *]: ");

        if (validateCalculatorData(operation)) {
            calculate(operation, argument1, argument2);
        }
    }
    static double readDoubleArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        double argument = userInput.nextDouble();
        return argument;
    }
    static String readStringArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        String argument = userInput.nextLine();
        return argument;
    }
    static boolean validateCalculatorData(String operation){
        boolean result = true;

        if(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*")){
            System.err.println("Введена недопустимая операция");
        result = false;
        }
        return result;
    }
    static void calculate(String operation, double arg1, double arg2) {
        switch (operation) {
            case "+":
                System.out.println(arg1 + arg2);
                break;
            case "-":
                System.out.println(arg1 - arg2);
                break;
            case "/":
                System.out.println(arg1 / arg2);
                break;
            case "*":
                System.out.println(arg1 * arg2);
                break;
        }
    }
}
//        Scanner userInput = new Scanner(System.in);
//
//        System.out.println("Введите операцию [+, -, /, *]: ");
//        String operation = userInput.nextLine();
//
//        System.out.println("Введите первый аргумент: ");
//        double argument1 = userInput.nextDouble();
//
//        System.out.println("Введите второй аргумент: ");
//        double argument2 = userInput.nextDouble();
//        userInput.close();
//
//        switch (operation){
//            case "+":
//                System.out.println(argument1 + argument2);
//                break;
//            case "-":
//                System.out.println(argument1 - argument2);
//                break;
//            case "/":
//                System.out.println(argument1 / argument2);
//                break;
//            case "*":
//                System.out.println(argument1 * argument2);
//                break;
//            default:
//                System.err.println("Нет такой операции");
//                break;
//
