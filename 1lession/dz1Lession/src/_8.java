import java.util.Scanner;

public class _8 {
    //8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void main(String[] args) {
        System.out.println("Программа для расчета количества дней введенного Вами месяца и года.");
        int yeaR = readArg("Введите год: ");
        int montH = readArg("Введите месяц(число от 1-12): ");

        System.out.println(getValue(montH, yeaR));
    }
    static int readArg(String text){
        Scanner userInput = new Scanner(System.in);
        System.out.println(text);
        int arg = userInput.nextInt();
        return arg;
    }

    private static String getValue(int month, int year) {
        int numDays;
        String monthString;
        switch (month) {
            case 1:
                monthString = "Январе";
                numDays = 31;
                break;
            case 3:
                monthString = "Марте";
                numDays = 31;
                break;
            case 5:
                monthString = "Мае";
                numDays = 31;
                break;
            case 7:
                monthString = "Июле";
                numDays = 31;
                break;
            case 8:
                monthString = "Августе";
                numDays = 31;
                break;
            case 10:
                monthString = "Октябре";
                numDays = 31;
                break;
            case 12:
                monthString = "Декабре";
                numDays = 31;
                break;
            case 4:
                monthString = "Апреле";
                numDays = 30;
                break;
            case 6:
                monthString = "Июне";
                numDays = 30;
                break;
            case 9:
                monthString = "Сентябре";
                numDays = 30;
                break;
            case 11:
                monthString = "Ноябре";
                numDays = 30;
                break;
            case 2:
                monthString = "Феврале";
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    numDays = 29;
                    monthString = "Феврале больше на 1 день так как " + year + "-й високосный год, будет";
                } else {
                    numDays = 28;
                }
                break;
            default:
                monthString = "такого не знаем";
                numDays = 0; // чтоб не было ошибки при обращении к переменной
                System.err.println("Несуществующий месяц");
                break;
        }
        return ("В " + year + " году, в " + monthString + " " + numDays + " дней");
    }
}
