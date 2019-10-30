package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Даж еесли ПК, каким то чудом выиграл, все равно нужно предавать ход живому игроку
 */
public class GameActionListener implements ActionListener {
    // ряд и строка кнопки
    private int row;
    private int cell;

    //ссылка на нашу кнопку
    private GameButton button;

    //конструктор
    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row; //строка
        this.cell = cell; //столбец
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //через нашу кнопку мы можем получить ссылку на геймбоард:
        GameBoard board = button.getBoard();

        //при ходе мы должны проверять можем ли мы в данную клетку текущему игроку
        //если тру то изменяем кнопку(передаем координаты)
        /**
         * rowNum = buttonIndex / GameBoard.dimension; строка
         * cellNum = buttonIndex % GameBoard.dimension; столбец
         */
        if (board.isTurnable(row, cell)) {//строка и столбец
            //простановка символа игрока
            //вызываем метод обновления данных для игрока человека метод человека
            board.getGame().getCurrentPlayer().updateByPlayersData(button);

            //сразу после хода провреяем не закончились ли места на поле
            if (board.isFull()) {
                //если поле заполнено, выводим сообщение ничья
                board.getGame().showMessage("Ничья!");
                //и чистим наше игровое поле
                board.emptyField();
            }
            //если !не все клетки заполнены и смена хода прошла успешно и
            // сейчас играет игрок с признаком RealPlayer = false то у компьютера есть возможность хода:
            //по ссылке на поле board, геттером getGame() получаем ссылку на игру,
            //по ссылке на игру геттером getCurrentPlayer() получаем ссылку на игрока,
            //по ссылке на игрока геттером isRealPlayer() получаем признак текущего игрока
            else if (!board.getGame().getCurrentPlayer().isRealPlayer()) {
                board.getGame().getCurrentPlayer().updateByAiData(button);
            }
        } else {
            //сообщение об ошибке
            //чрез борд получаем ссылку на игру гетГаме
            //и при помощи метода шоуМессадж говорим пакость
            board.getGame().showMessage("Некорректный ход");
        }
    }

//    private void updateByAiData(GameBoard board) {
//        //генерация координат хода компьютера
//        int x = -1, y = -1;
//        Random rnd = new Random();
//
//        //проверяем играет ли ПК в роли рандомного пк?
//        if (board.getGame().isSillyMode()) {
//            do {
//                x = rnd.nextInt(GameBoard.dimension);
//                y = rnd.nextInt(GameBoard.dimension);
//            } while (!board.isTurnable(x, y));
//        }
//
//        //иначе ПК игрет в роли сильного ПК
//        else {
//            //запрашиваем знак ПК
//            char DOT_O = board.getGame().getCurrentPlayer().getPlayerSign();
//            //запрашиваем размерность игрового поля
//            int SIZE = board.getDimension();
//
//            //компьютер ищет свой символ
//            //иначе компьютер решает, можно ли продолжить последовательность для выигрыша
//
//            //проверяем играет ПК просто подбирая соседние ячейки или хочет рассчитывать вес ячеек?
////true - выключен режим простого подюора!
//            if (board.getGame().isScoringMode()) {
//                //маркер торго, что ход найден! Нужен для выхода из двойного цикла
//                boolean moveFound = false;
//                //упрощенный алгоритм
//                for (int col = 0; col < SIZE; col++) { // строки
//                    for (int row = 0; row < SIZE; row++) { // столбцы       обходим массив двойным циклом
//                        if (board.isTurnable(col, row)) { //если мы в текущий момент работаем с пустой клеткой то начинаем опеределять соседей
//                            //проверяем направления
//                            //лево верх
//                            if (col - 1 >= 0 && row - 1 >= 0 && board.getGameField(col - 1, row - 1) == DOT_O) {
//                                // проверяем больше ли они нуля, чтоб не выходить за границы массива? последним условием проверяем что там есть знак ПК
//                                x = col; // строки
//                                y = row; // столбцы
//                                moveFound = true;
//                                System.out.println("LU");
//                            }
//                            //верх
//                            else if (col - 1 >= 0 && board.getGameField(col - 1, row) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("U");
//                            }
//                            //право верх
//                            else if (col - 1 >= 0 && row + 1 < SIZE && board.getGameField(col - 1, row + 1) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("RU");
//                            }
//                            //право
//                            else if (row + 1 < SIZE && board.getGameField(col, row + 1) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("R");
//                            }
//                            //право низ
//                            else if (col + 1 < SIZE && row + 1 < SIZE && board.getGameField(col + 1, row + 1) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("RD");
//                            }
//                            //низ
//                            else if (col + 1 < SIZE && board.getGameField(col + 1, row) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("B");
//                            }
//                            //лево низ
//                            else if (col + 1 < SIZE && row - 1 >= 0 && board.getGameField(col + 1, row - 1) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("LB");
//                            }
//                            //лево
//                            else if (row - 1 >= 0 && board.getGameField(col, row - 1) == DOT_O) {
//                                x = col;
//                                y = row;
//                                moveFound = true;
//                                System.out.println("L");
//                            }
//                        }
//                        //если ход найден, прерываем внутренний цикл
//                        if (moveFound) break;
//                    }
//                    //если ход найден, прерываем внешинй цикл
//                    if (moveFound) break;
//                }
//            }
//            // конец простого хода пк
//            else {
//// сложный режим
//                int maxScoreFieldX = -1;
//                int maxScoreFieldY = -1;
//                int maxScore = 0; // максимальный рейтинг
//
//                for (int col = 0; col < SIZE; col++) { //первый цикл строк
//                    for (int row = 0; row < SIZE; row++) { //второй цикл столбцов
//                        int fieldScore = 0; //переменная для текущего значения рейтинга
//
//                        if (board.isTurnable(col, row)) { // если поле пустое? то проверяем направления для этой ячейки и считаем рейтинг
//                            // проверяем направления
//                            //лево верх
//                            if (col - 1 >= 0 && row - 1 >= 0 && board.getGameField(col - 1, row - 1) == DOT_O)
//                                fieldScore++;
//                            //верх
//                            if (col - 1 >= 0 && board.getGameField(col - 1, row) == DOT_O) fieldScore++;
//                            //право верх
//                            if (col - 1 >= 0 && row + 1 < SIZE && board.getGameField(col - 1, row + 1) == DOT_O)
//                                fieldScore++;
//                            //право
//                            if (row + 1 < SIZE && board.getGameField(col, row + 1) == DOT_O) fieldScore++;
//                            //право низ
//                            if (col + 1 < SIZE && row + 1 < SIZE && board.getGameField(col + 1, row + 1) == DOT_O)
//                                fieldScore++;
//                            //низ
//                            if (col + 1 < SIZE && board.getGameField(col + 1, row) == DOT_O) fieldScore++;
//                            //лево низ
//                            if (col + 1 < SIZE && row - 1 >= 0 && board.getGameField(col + 1, row - 1) == DOT_O)
//                                fieldScore++;
//                            //лево
//                            if (row - 1 >= 0 && board.getGameField(col, row - 1) == DOT_O) fieldScore++;
//                        } // конец проверки ПУСТОЙ ячейки
//
//                        if (fieldScore > maxScore) { //сравниваем текущее полученное колличество очков с предыдущим максимальным
//                            maxScore = fieldScore; //, если надо заменяем максимальное и координаты
//                            maxScoreFieldX = col;
//                            maxScoreFieldY = row;
//                        }
//                    }//первый фор
//                }//второй фор
//
//                //если в цикле найдена наилучшая клетка
//                if (maxScoreFieldX != -1) {
//                    x = maxScoreFieldX; //обновим координаты х у через временные из цикла
//                    y = maxScoreFieldY;
//                }
//            } // конец сложного хода конец эльзе
//
//            //если ни чего не нашли, тогда генерируем случайный ход
//            if (x == -1) {
//                do {
//                    x = rnd.nextInt(GameBoard.dimension);
//                    y = rnd.nextInt(GameBoard.dimension);
//                } while (!board.isTurnable(x, y));
//            }
//        }
//
//        //обновить матрицу игры
//        board.updateGameField(x, y); //строку и столбец
//
//        //обновить содержимое кнопки
//        //получить индекс кнопки:
//        //размерность нашего поля нужно умножить на номер ряда и прибавить номер столбца
//        //это обратная формула к тем самым двум
//        int cellIndex = GameBoard.dimension * x + y;
//
//        //получить кнопку по ее индексу getButton(cellIndex
//        //и присваиваем ее тексту значение символа текущего игрока тоесть компа
//        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
//
//        //проверяем победу
//        if (board.checkWin()) {
//            button.getBoard().getGame().showMessage("Компьютер выиграл");
//            board.emptyField();
//
////Даж еесли ПК, каким то чудом выиграл, все равно нужно предавать ход живому игроку
////иначе первый ход игрока будет с 0 вместо крестика!
//            board.getGame().passTurn();
//
//        } else {//если победа не найдена то предаем ход игроку
//            //передать ход
//            board.getGame().passTurn();
//        }
//
//    }
}
