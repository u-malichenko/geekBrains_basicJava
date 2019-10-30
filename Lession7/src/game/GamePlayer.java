package game;

import java.util.Random;

public class GamePlayer {

    //символ которым играет игрок
    private char playerSign;
    //признак рельный игрок или пк
    private boolean realPlayer = true;

    /**
     * Конструктор игрока
     * @param isRealPlayer - признак игрок или компьютер
     * @param playerSign - символ которым играет игрок
     */
    public GamePlayer(boolean isRealPlayer, char playerSign) {
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    /**
     * создаем геттеры для того чтоб иметь доступ к приватным полям из вне (из кода прогр)
     * получение признака игрока, true = реальный игрок, false = компьютер
     * @return boolean - признак текущего игрока
     */
    public boolean isRealPlayer() {
        return realPlayer;
    }

    /**
     * получение сивола текущего игрока
     * @return -char крестик или нолик
     */
    public char getPlayerSign() {
        return playerSign;
    }

    /**
     * ход человека
     *
     * @param button - GameBoard ссылка на игровое поле
     */
    void updateByPlayersData(GameButton button) {

        int row = button.getButtonIndex() / GameBoard.dimension;
        int cell = button.getButtonIndex() % GameBoard.dimension;

        //обновляем матрицу игры - записываем в ее значение проставленного хода
        button.getBoard().updateGameField(row, cell);

        //теперь нужно обновить содержимое кнопки
        //обращаемся к Баттон задаем ей сет текст и при помощи класса Обертки Чарактер
        // переводим ту стринг и получаем символ игрока известным нам методом:
        //для того тчоб получить этот символ у нас есть геттер на объект игры game
        //у ее мы можем узнать кто же сейчас текущий игрок, но только текущего игрока не хватит
        //мы должны поставить туда его символ а не его самого, по этому
        //у полученного объекта игрока getCurrentPlayer мы получаем символ через getPlayerSign
        //чар и стринг не идентичные типы так что используем тустринг
        button.setText(Character.toString(button.getBoard().getGame().getCurrentPlayer().getPlayerSign()));

        //и после хода нам нужно проверить состояние победы
        if (button.getBoard().checkWin()) {
            //если он возвращает тру оповещаем игрока о том что он выиграл
            button.getBoard().getGame().showMessage("Вы выиграли!");
            button.getBoard().emptyField();            //чистим поле
        } else {         //иначе мы должны передать ход
            button.getBoard().getGame().passTurn();
        }
    }

    void updateByAiData(GameButton button) {
        //генерация координат хода компьютера
        int x = -1, y = -1;
        Random rnd = new Random();

        //проверяем играет ли ПК в роли рандомного пк?
        if (button.getBoard().getGame().isSillyMode()) {
            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!button.getBoard().isTurnable(x, y));
        }

        //иначе ПК игрет в роли сильного ПК
        else {
            //запрашиваем знак ПК
            char DOT_O = button.getBoard().getGame().getCurrentPlayer().getPlayerSign();
            //запрашиваем размерность игрового поля
            int SIZE = button.getBoard().getDimension();

            //компьютер ищет свой символ
            //иначе компьютер решает, можно ли продолжить последовательность для выигрыша

            //проверяем играет ПК просто подбирая соседние ячейки или хочет рассчитывать вес ячеек?
//true - выключен режим простого подюора!
            if (button.getBoard().getGame().isScoringMode()) {
                //маркер торго, что ход найден! Нужен для выхода из двойного цикла
                boolean moveFound = false;
                //упрощенный алгоритм
                for (int col = 0; col < SIZE; col++) { // строки
                    for (int row = 0; row < SIZE; row++) { // столбцы       обходим массив двойным циклом
                        if (button.getBoard().isTurnable(col, row)) { //если мы в текущий момент работаем с пустой клеткой то начинаем опеределять соседей
                            //проверяем направления
                            //лево верх
                            if (col - 1 >= 0 && row - 1 >= 0 && button.getBoard().getGameField(col - 1, row - 1) == DOT_O) {
                                // проверяем больше ли они нуля, чтоб не выходить за границы массива? последним условием проверяем что там есть знак ПК
                                x = col; // строки
                                y = row; // столбцы
                                moveFound = true;
                                System.out.println("LU");
                            }
                            //верх
                            else if (col - 1 >= 0 && button.getBoard().getGameField(col - 1, row) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("U");
                            }
                            //право верх
                            else if (col - 1 >= 0 && row + 1 < SIZE && button.getBoard().getGameField(col - 1, row + 1) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("RU");
                            }
                            //право
                            else if (row + 1 < SIZE && button.getBoard().getGameField(col, row + 1) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("R");
                            }
                            //право низ
                            else if (col + 1 < SIZE && row + 1 < SIZE && button.getBoard().getGameField(col + 1, row + 1) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("RD");
                            }
                            //низ
                            else if (col + 1 < SIZE && button.getBoard().getGameField(col + 1, row) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("B");
                            }
                            //лево низ
                            else if (col + 1 < SIZE && row - 1 >= 0 && button.getBoard().getGameField(col + 1, row - 1) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("LB");
                            }
                            //лево
                            else if (row - 1 >= 0 && button.getBoard().getGameField(col, row - 1) == DOT_O) {
                                x = col;
                                y = row;
                                moveFound = true;
                                System.out.println("L");
                            }
                        }
                        //если ход найден, прерываем внутренний цикл
                        if (moveFound) break;
                    }
                    //если ход найден, прерываем внешинй цикл
                    if (moveFound) break;
                }
            }
            // конец простого хода пк
            else {
// сложный режим
                int maxScoreFieldX = -1;
                int maxScoreFieldY = -1;
                int maxScore = 0; // максимальный рейтинг

                for (int col = 0; col < SIZE; col++) { //первый цикл строк
                    for (int row = 0; row < SIZE; row++) { //второй цикл столбцов
                        int fieldScore = 0; //переменная для текущего значения рейтинга

                        if (button.getBoard().isTurnable(col, row)) { // если поле пустое? то проверяем направления для этой ячейки и считаем рейтинг
                            // проверяем направления
                            //лево верх
                            if (col - 1 >= 0 && row - 1 >= 0 && button.getBoard().getGameField(col - 1, row - 1) == DOT_O)
                                fieldScore++;
                            //верх
                            if (col - 1 >= 0 && button.getBoard().getGameField(col - 1, row) == DOT_O) fieldScore++;
                            //право верх
                            if (col - 1 >= 0 && row + 1 < SIZE && button.getBoard().getGameField(col - 1, row + 1) == DOT_O)
                                fieldScore++;
                            //право
                            if (row + 1 < SIZE && button.getBoard().getGameField(col, row + 1) == DOT_O) fieldScore++;
                            //право низ
                            if (col + 1 < SIZE && row + 1 < SIZE && button.getBoard().getGameField(col + 1, row + 1) == DOT_O)
                                fieldScore++;
                            //низ
                            if (col + 1 < SIZE && button.getBoard().getGameField(col + 1, row) == DOT_O) fieldScore++;
                            //лево низ
                            if (col + 1 < SIZE && row - 1 >= 0 && button.getBoard().getGameField(col + 1, row - 1) == DOT_O)
                                fieldScore++;
                            //лево
                            if (row - 1 >= 0 && button.getBoard().getGameField(col, row - 1) == DOT_O) fieldScore++;
                        } // конец проверки ПУСТОЙ ячейки

                        if (fieldScore > maxScore) { //сравниваем текущее полученное колличество очков с предыдущим максимальным
                            maxScore = fieldScore; //, если надо заменяем максимальное и координаты
                            maxScoreFieldX = col;
                            maxScoreFieldY = row;
                        }
                    }//первый фор
                }//второй фор

                //если в цикле найдена наилучшая клетка
                if (maxScoreFieldX != -1) {
                    x = maxScoreFieldX; //обновим координаты х у через временные из цикла
                    y = maxScoreFieldY;
                }
            } // конец сложного хода конец эльзе

            //если ни чего не нашли, тогда генерируем случайный ход
            if (x == -1) {
                do {
                    x = rnd.nextInt(GameBoard.dimension);
                    y = rnd.nextInt(GameBoard.dimension);
                } while (!button.getBoard().isTurnable(x, y));
            }
        }

        //обновить матрицу игры
        button.getBoard().updateGameField(x, y); //строку и столбец

        //обновить содержимое кнопки
        //получить индекс кнопки:
        //размерность нашего поля нужно умножить на номер ряда и прибавить номер столбца
        //это обратная формула к тем самым двум
        int cellIndex = GameBoard.dimension * x + y;

        //получить кнопку по ее индексу getButton(cellIndex
        //и присваиваем ее тексту значение символа текущего игрока тоесть компа
        button.getBoard().getButton(cellIndex).setText(Character.toString(button.getBoard().getGame().getCurrentPlayer().getPlayerSign()));

        //проверяем победу
        if (button.getBoard().checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл");
            button.getBoard().emptyField();

//Даж еесли ПК, каким то чудом выиграл, все равно нужно предавать ход живому игроку
//иначе первый ход игрока будет с 0 вместо крестика!
            button.getBoard().getGame().passTurn();

        } else {//если победа не найдена то предаем ход игроку
            //передать ход
            button.getBoard().getGame().passTurn();
        }

    }
}
