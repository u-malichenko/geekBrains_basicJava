public class dz2 {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        //инициируем массив:
        int[] arr = new int[10];

        // заполняем массив рандомными числами:
        getArr(2, arr); // первый параметр интервал рандомных чисел, туто от 0-1

        //печатаем первый массив:
        printArr(arr);

        //меняем значения в массиве
        arrChange(arr);

        //печатаем измененный массив:
        printArr(arr);

    }

    //метод для заполнения одномерного массива рандомными числами:
    public static void getArr(int n, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  (int) (Math.random() * n);
        }
    }

    // метод для печати одномерного массива:
    public static void printArr(int[] arr){
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    //метод для замены 0-1 и 1 -0:
    public static void arrChange(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]>0) ? 0:1;
        }
    }
}
