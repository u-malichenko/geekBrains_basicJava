import java.util.Scanner;

public class _7 {
//7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void main(String[] args){
        System.out.println("Программа для приветствия пользователя");
        String namE = readArg("Введите свое имя: ");
        getHello(namE);
    }
    static String readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        String arg = userInput.nextLine();
        return arg;
    }
    static void getHello(String name){
        System.out.println("Привет," + name + "!");
    }
}
