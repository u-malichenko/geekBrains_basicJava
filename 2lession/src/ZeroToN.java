import java.util.Scanner;

public class ZeroToN {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите ограничение: ");
        int limit = userInput.nextInt();
        userInput.close();

        int counter =0;
        System.out.println("Список четных чисел из заданного промежутка: ");
        while (counter <= limit){
            if(counter % 2 == 0){
                System.out.println(counter);
            }
            counter++;
        }
    }
}
