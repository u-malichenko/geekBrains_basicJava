import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /**
     * Блок настроек игры
         */
    private static char[][] map; // матрица игры
    private static int SIZE = 3; //размерность поля

    private static final char DOT_EMPTY ='●'; //пустой символ - свободное поле
    private static final char DOT_X = 'X'; //крестик
    private static final char DOT_O = 'O'; // нолик

    private static final boolean SILLY_MODE = true; // включить режим слабого пк

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true){
            humanTurn(); //ход человека
            if(isEndGame(DOT_X)){ //проверка конца игры
                break;
            }

            computerTurn(); // ход компьютера
            if(isEndGame(DOT_O)){
                break;
            }
        }
        System.out.println("Игра закончена!");
    }

    /**
     * Метод подготовки игрового поля
     */
    private static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод вывода игрового поля
     * ОПТИМИИРОВАТЬ_СОКРАТИТЬ КОЛЛИЧЕСТВО ЦИКЛОВ
     */
    private static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Ход человека
     */
    private static void humanTurn(){
        int x, y;
        do{
            System.out.println("Введите координаты ячейки через пробел");
            y = scanner.nextInt() -1;
            x = scanner.nextInt() -1;

        }while (!isCellValid(x, y));

        map [y][x] = DOT_X;
    }

    /**
     * Ход компьютера
     */
    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if(SILLY_MODE){
            do{
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }while (!isCellValid(x, y));
        }
        else{
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    // проверяем клетки по направлениям переменная счетчик очков брейк прерывает только 1 цикл!
                    // имеет смысл тставить туда ноль только если там можно продолжить какую то линию выигрышную, если там уже стоит другой то нет смысла ставить ноль
                }
            }

        }


        System.out.println("Компьютер выбрал ячейку " + (y+1) + " " + (x+1));
        map[y][x] = DOT_O;
    }

    /**
     * Метод валидации запрашиваемой ячейки на  корректность
     * @param x - координата по горизонтали
     * @param y - координата по вертикали
     * @return boolean - признак валидности
     */
    private static boolean isCellValid(int x, int y){
        boolean result = true;
        if (x < 0 || x > SIZE || y < 0 || y > SIZE || map[y][x] != DOT_EMPTY){
            result = false;
        }
        return result;
    }

    /**
     * Метод проверки игры на завершение
     * @param playerSymbol символ которым играет текущий игрок
     * @return boolean - признак завершения игры
     */
    private static boolean isEndGame(char playerSymbol){
        boolean result = false;
        printMap();

        //проверяем необходимость следующего хода
        if(checkWin(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        //проверяем отсутствие свободных ячеек
        if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }
        return result;
    }

    /**
     * Проверка на 100% заполеннность поля
     * return boolean прищнак оптимальности
     */
    private static boolean isMapFull(){
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY)
/**/                  return false;
            }
        }
        return result;
    }

    /**
     * Метод проверки выигрыша
     * @param playerSumbol - символ, введенный пользователем
     * @return boolean - результат проверки
     * ПРОСТИТЬ ОПТИМИЗИРОВАТЬ
     */
    private static boolean checkWin(char playerSumbol){
        boolean result = false;

        if( (map[0][0] == playerSumbol && map[0][1] == playerSumbol &&map[0][2] == playerSumbol) ||
            (map[1][0] == playerSumbol && map[1][1] == playerSumbol &&map[1][2] == playerSumbol) ||
            (map[2][0] == playerSumbol && map[2][1] == playerSumbol &&map[2][2] == playerSumbol) ||
            (map[0][0] == playerSumbol && map[1][0] == playerSumbol &&map[2][0] == playerSumbol) ||
            (map[0][1] == playerSumbol && map[1][1] == playerSumbol &&map[2][1] == playerSumbol) ||
            (map[0][2] == playerSumbol && map[1][2] == playerSumbol &&map[2][2] == playerSumbol) ||
                checkWin1(playerSumbol) ||
                checkWin2(playerSumbol)){
            result =  true;
        }
            return result;
    }

    // проверить первую диагональ
    private static  boolean checkWin1(char playerSumbol){
        boolean result = false;
/**/        for (int i = 0; i < SIZE ; i++) {
            if (map[i][i] == playerSumbol) {
                result = true;
            } else {
                return false; //если диагональ прервалась то завершаем цикл
            }
        }
        return result;
    }

    //проверить вторую диагональ
    private static  boolean checkWin2(char playerSumbol){
        boolean result = false;
/**/        for (int i = 0; i < SIZE; i++) {
/**/            if(map[i][SIZE-1-i] == playerSumbol){
                result = true;
            } else {
                 return false; //если диагональ прервалась то завершаем цикл
            }
        }
        return result;
    }

}
