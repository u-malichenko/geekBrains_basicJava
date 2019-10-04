import java.util.Scanner;

public class Util {
    //метод для заполнения одномерного массива рандомными числами:
    static void getArr(int n, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  (int) (Math.random() * n);
        }
    }

    // метод для печати одномерного массива:
    static void printArr(int[] arr, String comment){
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println(comment);
    }

    // метод для печати квадратного массива
    static void printArr(int[][] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //метод для ввеода значения пользователем
    static int readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        int arg = userInput.nextInt();

        return arg;
    }


}
