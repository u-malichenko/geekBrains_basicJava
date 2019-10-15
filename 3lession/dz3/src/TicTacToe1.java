import java.util.Random;
import java.util.Scanner;

public class TicTacToe1 {
    /**1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать;
     * Блок настроек игры
     */
    private static char[][] map; // матрица игры
    private static final int SIZE = 4; //размерность поля

    private static final char DOT_EMPTY ='●'; //пустой символ - свободное поле
    private static final char DOT_X = 'X'; //крестик
    private static final char DOT_O = 'O'; // нолик

    private static final boolean SILLY_MODE = false; // включить режим слабого пк
    private static final boolean SCORING_MODE = true; // выключить режим простого подбора по соседним занчениям

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

    /** Оптимизировал и сократил КОЛЛИЧЕСТВО ЦИКЛОВ
     * Метод вывода игрового поля
     *
     */
    private static void printMap(){
        for (int i = 0; i <= SIZE; i++) {
            System.out.print((i) + " "); //печатаем первый элемент номер строки
            for (int j = 1; j <= SIZE; j++) {
                if(i==0){ //печатаем шапку таблицы
                    System.out.print(j + " ");
                }else { // печатаем элементы таблицы
                    System.out.print(map[i-1][j-1] + " ");
                }
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
        System.out.println("Вы выбрали ячейку " + (y+1) + " " + (x+1));
        map [y][x] = DOT_X;
    }

    /**2. Реализовать логику более умного компьютера, который определяет свой ход на основании соседних клеток;
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
            //компьютер ищет свой символ
            //компьютер решает, можно ли продолжить последовательность для выигрыша

            if(!SCORING_MODE){
                //маркер торго, что ход найден Нужен для выхода из двойного цикла
                boolean moveFound = false;

                //упрощенный алгоритм
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) { // обходим массив двойным циклом
                        if(map[i][j] == DOT_EMPTY){ //если мы в текущий момент работаем с пустой клеткой то начинаем опеределять соседей
                            //проверяем направления
                            //лево верх
                            if(i-1 >= 0 && j-1 >= 0 && map[i-1][j-1] == DOT_O){ // проверяем больше ли они нуля, чтоб не выходить за границы массива? последним условием проверяем чтотам нолик
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("LU");
                            }
                            //верх
                            else if (i - 1 >= 0 && map[i-1][j] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("U");
                            }
                            //право верх
                            else if (i - 1 >= 0 && j + 1 < SIZE && map[i-1][j+1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("RU");
                            }
                            //право
                            else if (j + 1 < SIZE && map[i][j+1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("R");
                            }
                            //право низ
                            else if (i + 1 < SIZE && j + 1 < SIZE && map[i+1][j+1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("RD");
                            }
                            //низ
                            else if (i + 1 < SIZE && map[i+1][j] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("B");
                            }
                            //лево низ
                            else if (i + 1 < SIZE && j - 1 >= 0 && map[i+1][j-1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("LB");
                            }
                            //лево
                            else if (j - 1 >= 0 && map[i][j-1] == DOT_O) {
                                y = i;
                                x = j;
                                moveFound = true;
                                System.out.println("L");
                            }
                        }
                        //если ход найден, прерываем внутренний цикл
                        if(moveFound) break;
                    }
                    //если ход найден, прерываем внешинй цикл
                    if(moveFound) break;
                }
            }
            // конец простого хода пк
            else {
                // сложный режим
                int maxScoreFieldX = -1;
                int maxScoreFieldY = -1;
                int maxScore = 0; // максимальный рейтинг

                for (int i = 0; i < SIZE; i++) { //первый цикл строк
                    for (int j = 0; j < SIZE; j++) { //второй цикл столбцов
                        int fieldScore = 0; //переменная для текущего значения рейтинга

                        if(map[i][j] == DOT_EMPTY){ // если поле пустое? то проверяем направления для этой ячейки и считаем рейтинг
                            // проверяем направления
                            if(i-1 >= 0 && j-1 >= 0 && map[i-1][j-1] == DOT_O) fieldScore++;
                            //верх
                            if (i - 1 >= 0 && map[i-1][j] == DOT_O) fieldScore++;
                            //право верх
                            if(i - 1 >= 0 && j + 1 < SIZE && map[i-1][j+1] == DOT_O) fieldScore++;
                            //право
                            if(j + 1 < SIZE && map[i][j+1] == DOT_O) fieldScore++;
                            //право низ
                            if(i + 1 < SIZE && j + 1 < SIZE && map[i+1][j+1] == DOT_O) fieldScore++;
                            //низ
                            if(i + 1 < SIZE && map[i+1][j] == DOT_O) fieldScore++;
                            //лево низ
                            if(i + 1 < SIZE && j - 1 >= 0 && map[i+1][j-1] == DOT_O) fieldScore++;
                            //лево
                            if(j - 1 >= 0 && map[i][j-1] == DOT_O) fieldScore++;
                        } // конец проверки ПУСТОЙ ячейки

                        if(fieldScore > maxScore){ //сравниваем текущее полученное колличество очков с предыдущим максимальным
                            maxScore = fieldScore; //, если надо заменяем максимальное и координаты
                            maxScoreFieldX = j;
                            maxScoreFieldY = i;
                        }
                    }//первый фор
                }//второй фор

                //если в цикле найдена наилучшая клетка
                if(maxScoreFieldX != -1){
                    x = maxScoreFieldX; //обновим координаты х у через временные из цикла
                    y = maxScoreFieldY;
                }
            } // конец сложного хода конец эльзе

            //если ни чего не нашли, тогда генерируем случайный ход
            if (x == -1) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (!isCellValid(x, y));
                System.out.println("RANDOM");
            }
        }
        System.out.println("Компьютер выбрал ячейку " + (y+1) + " " + (x+1));
        map[y][x] = DOT_O;
    }

    /** Оптимизировал сократил количество if
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
                if(map[i][j] == DOT_EMPTY){
                   // пустая клетка найдена
                   result =false;
                   //выход из внутреннего цикла сократит число итераций
                    break;
                }
            }
            // выходим из внешнего цикла, если пустая клетка найдена
            if(!result) break;
        }
        return result;
    }

    /** задание 3. Найти в коде неоптимальные места и улучшить их;
     * Оптимизировано для разных размеров полей
     * Метод проверки выигрыша
     * @param playerSymbol - символ, введенный пользователем
     * @return boolean - результат проверки
     * уПРОСТИТЬ ОПТИМИЗИРОВАТЬ
     */

    private static  boolean checkWin(char playerSymbol){
        boolean result1 = true; //проверить первую диагональ
        boolean result2 = true; //проверить вторую диагональ
        boolean result3 = true;; //проверрка победы по строкам
        boolean result4 = true;; //проверрка победы по столбцам

        for (int i = 0; i < SIZE; i++) {
            result3 = true; //инициируем в цикле для проверки каждой строки отдельно
            result4 = true; // инициируем в цикле для проверки каждого столбца отдельно

            result1 &= (map[i][i] == playerSymbol); // проверить первую диагональ если диагональ прервалась то результат уже в цикле ни когда не будет тру
            result2 &= (map[i][SIZE - 1 - i] == playerSymbol);  //проверить вторую диагональ если диагональ прервалась то результат уже в цикле ни когда не будет тру

            for (int j = 0; j < SIZE; j++) {
                result3 &= (map[i][j] == playerSymbol);  //проверрка победы по строкам
                result4 &= (map[j][i] == playerSymbol);  //проверрка победы по столбцам
                if(!(result3) && !(result4)) break; // если обе строки фолс то нет смысла проверять весь массив, выходим в главный цикл
            }
            if(result3 || result4) break; // если есть победа по вложенному циклу то предыдущий цикл прерываем, уже будет тру
        }
        return (result1 || result2 || result3 || result4);//если хоть один тру, то вернем тру!
    }
}
