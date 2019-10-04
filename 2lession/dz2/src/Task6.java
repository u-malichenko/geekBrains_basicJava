public class Task6 {
    public static void main(String[] args) {
        int[] test1 = {2, 1, 1, 2, 1};
        int[] test2 = {10, 10};
        int[] test3 = {1, 1, 1, 2, 1};

        System.out.println(arrCheck(test1));
        System.out.println(arrCheck(test2));
        System.out.println(arrCheck(test3));
    }


    private static boolean arrCheck(int[] arrToCheck){
        int leftSum = 0;
        int rightSum = 0;
        boolean result = false;

        //минимальное число элементов для поиска очевидно 2
        if(arrToCheck.length > 1){
            for (int i = 0; i < arrToCheck.length /2; i++) {
                leftSum += arrToCheck[i]; // сумма от нуля по и и тд
                rightSum += arrToCheck[arrToCheck.length-1-i]; //сумма по длинне массива минус1 так ак он считается с0 и МИНУС И(первый раз 0) для последующих итераций

                //нечетные числа java округляет в меньшую сторону
                //поэтому к правой сумме нужно прибавить еще 1 элемент
                if(i == (arrToCheck.length/2-1) && arrToCheck.length % 2 != 0){ //последний шаг и массив имеет нечетное колличество элементов?
                    rightSum += arrToCheck[arrToCheck.length-2-i]; // прибавляем к правой сумме элемент пропажу! = длинна массива -И и МИНУС 2!(-1 это из-за счета с 0 и еще минус1 =исключение)
                }
            }
            //если левая сумма меньше правой, то продолжаем движение вправо
            //увеличивая левую сумму и уменьшая правую. и наоборот
            if(leftSum<rightSum){
                for (int i = arrToCheck.length / 2; i < arrToCheck.length; i++) {
                    leftSum += arrToCheck[i];
                    rightSum -= arrToCheck[i];
                    if(leftSum == rightSum){
                        result = true;
                        printArray(arrToCheck, i);
                        break;
                    }
                }
            }
            else if(leftSum > rightSum){
                for (int i = arrToCheck.length /2; i < arrToCheck.length; i++) {
                    leftSum -= arrToCheck[i];
                    rightSum += arrToCheck[i];
                    if(leftSum == rightSum){
                        result = true;
                        printArray(arrToCheck, i);
                        break;
                    }
                }
            }
            //если суммы равны в центре то печатаем массив
            else {
                result = true;
                printArray(arrToCheck, arrToCheck.length/2 -1);
            }
        }
        else {
            System.out.println("Передан слишком короткий массив");
        }
        return result;
    }
    static void printArray(int[] arrToPrint, int middleIndex){
        for (int i = 0; i < arrToPrint.length; i++) {
            System.out.print(arrToPrint[i]+" ");
            if(i==middleIndex)
                System.out.print("|| ");
        }
    }
}
