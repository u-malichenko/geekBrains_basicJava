package game;

import java.util.Random;

public class GamePlayer {

    //символ которым играет игрок
    private char playerSign;
    //признак рельный игрок или пк
    private boolean realPlayer = true;

    //запрашиваем знак ПК
    private char DOT_O = getPlayerSign();
    //запрашиваем размерность игрового поля
    private int SIZE = GameBoard.dimension;

    //начальные заведомо ошибочные координаты
    private int row = -1;
    private int cell = -1;
    Random rnd = new Random();


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

    /**
     * ход компьютера
     * @param button
     */
    void updateByAiData(GameButton button) {
        //генерация координат хода компьютера
        //проверяем играет ли ПК в роли рандомного символа(isSillyMode)?
        if (button.getBoard().getGame().isSillyMode()) {
            do {
                row = rnd.nextInt(GameBoard.dimension);
                cell = rnd.nextInt(GameBoard.dimension);
            } while (!button.getBoard().isTurnable(row, cell));
        }
        //иначе ПК игрет в роли сильного ПК
        // (есть два способа
        // 1 подбор по ближайшему полю содержащему 0(isScoringMode = true)
        // 2 взвешивание каждой ячейки и определение самой подходящей
        else {
            //проверяем играет ПК просто подбирая соседние ячейки или хочет рассчитывать вес ячеек? isScoringMode = true - выключен режим простого подбора!
            if (button.getBoard().getGame().isScoringMode()) {
                // сложный режим 1 c одбором, вынес в отдельный метод scoringModeOn
                scoringModeOn(button);
            } // конец сложного хода с обычным подбором ячеек содержащих 0
            else {
                // сложный режим 2, вынес в отдельный метод scoringModeOff
                scoringModeOff(button);
            } // конец сложного хода конец эльзе
            //если ни чего не нашли, тогда генерируем случайный ход, или для первого хода
            if (row == -1) {
                do {
                    row = rnd.nextInt(GameBoard.dimension);
                    cell = rnd.nextInt(GameBoard.dimension);
                } while (!button.getBoard().isTurnable(row, cell));
            }
        }
        //обновить матрицу игры
        button.getBoard().updateGameField(row, cell); //строку и столбец
        //обновить содержимое кнопки
        //получить индекс кнопки:
        //размерность нашего поля нужно умножить на номер ряда и прибавить номер столбца
        //это обратная формула к тем самым двум
        int cellIndex = GameBoard.dimension * row + cell;
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
        } else {
            //если победа не найдена то предаем ход игроку
            //передать ход
            button.getBoard().getGame().passTurn();
        }
    }

    /**
     * метод ложного ПК 1 - включен режим простого подбора ячеек по первому совпадению со знаком ПК
     * @param button- ссылка на кнопку для получения  свойств
     */
    private void scoringModeOn (GameButton button){
        //маркер торго, что ход найден! Нужен для выхода из двойного цикла
        boolean moveFound = false;
        //упрощенный алгоритм
        for (int i = 0; i < SIZE; i++) { // строки
            for (int j = 0; j < SIZE; j++) { // столбцы       обходим массив двойным циклом
                if (button.getBoard().isTurnable(i, j)) { //если мы в текущий момент работаем с пустой клеткой то начинаем опеределять соседей
                    //проверяем направления
                    //лево верх
                    if (i - 1 >= 0 && j - 1 >= 0 && button.getBoard().getGameField(i - 1, j - 1) == DOT_O) {
                        // проверяем больше ли они нуля, чтоб не выходить за границы массива? последним условием проверяем что там есть знак ПК
                        row = i; // строки
                        cell = j; // столбцы
                        moveFound = true;
                        System.out.println("LU");
                    }
                    //верх
                    else if (i - 1 >= 0 && button.getBoard().getGameField(i - 1, j) == DOT_O) {
                        row = i;
                        cell = j;
                        moveFound = true;
                        System.out.println("U");
                    }
                    //право верх
                    else if (i - 1 >= 0 && j + 1 < SIZE && button.getBoard().getGameField(i - 1, j + 1) == DOT_O) {
                        row = i;
                        cell = j;
                        moveFound = true;
                        System.out.println("RU");
                    }
                    //право
                    else if (j + 1 < SIZE && button.getBoard().getGameField(i, j + 1) == DOT_O) {
                        row = i;
                        cell = j;
                        moveFound = true;
                        System.out.println("R");
                    }
                    //право низ
                    else if (i + 1 < SIZE && j + 1 < SIZE && button.getBoard().getGameField(i + 1, j + 1) == DOT_O) {
                        row = i;
                        cell = j;
                        moveFound = true;
                        System.out.println("RD");
                    }
                    //низ
                    else if (i + 1 < SIZE && button.getBoard().getGameField(i + 1, j) == DOT_O) {
                        row = i;
                        cell = j;
                        moveFound = true;
                        System.out.println("B");
                    }
                    //лево низ
                    else if (i + 1 < SIZE && j - 1 >= 0 && button.getBoard().getGameField(i + 1, j - 1) == DOT_O) {
                        row = i;
                        cell = j;
                        moveFound = true;
                        System.out.println("LB");
                    }
                    //лево
                    else if (j - 1 >= 0 && button.getBoard().getGameField(i, j - 1) == DOT_O) {
                        row = i;
                        cell = j;
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

    /**
     * метод сложного пк 2 - взвешивает ценность каждой кнопки
     * @param button - ссылка на кнопку для получения  свойств
     */
    private void scoringModeOff(GameButton button){
        int maxScoreFieldRow = -1;
        int maxScoreFieldCell = -1;
        int maxScore = 0; // максимальный рейтинг

        for (int i = 0; i < SIZE; i++) { //первый цикл строк
            for (int j = 0; j < SIZE; j++) { //второй цикл столбцов
                int fieldScore = 0; //переменная для текущего значения рейтинга
                if (button.getBoard().isTurnable(i, j)) { // если поле пустое? то проверяем направления для этой ячейки и считаем рейтинг
                    // проверяем направления
                    //лево верх
                    if (i - 1 >= 0 && j - 1 >= 0 && button.getBoard().getGameField(i - 1, j - 1) == DOT_O)
                        fieldScore++;
                    //верх
                    if (i - 1 >= 0 && button.getBoard().getGameField(i - 1, j) == DOT_O) fieldScore++;
                    //право верх
                    if (i - 1 >= 0 && j + 1 < SIZE && button.getBoard().getGameField(i - 1, j + 1) == DOT_O)
                        fieldScore++;
                    //право
                    if (j + 1 < SIZE && button.getBoard().getGameField(i, j + 1) == DOT_O) fieldScore++;
                    //право низ
                    if (i + 1 < SIZE && j + 1 < SIZE && button.getBoard().getGameField(i + 1, j + 1) == DOT_O)
                        fieldScore++;
                    //низ
                    if (i + 1 < SIZE && button.getBoard().getGameField(i + 1, j) == DOT_O) fieldScore++;
                    //лево низ
                    if (i + 1 < SIZE && j - 1 >= 0 && button.getBoard().getGameField(i + 1, j - 1) == DOT_O)
                        fieldScore++;
                    //лево
                    if (j - 1 >= 0 && button.getBoard().getGameField(i, j - 1) == DOT_O) fieldScore++;
                } // конец проверки ПУСТОЙ ячейки
                if (fieldScore > maxScore) { //сравниваем текущее полученное колличество очков с предыдущим максимальным
                    maxScore = fieldScore; //, если надо заменяем максимальное и координаты
                    maxScoreFieldRow = i;
                    maxScoreFieldCell = j;
                }
            }//первый фор
        }//второй фор
        //если в цикле найдена наилучшая клетка
        if (maxScoreFieldRow != -1) {
            row = maxScoreFieldRow; //обновим координаты х у через временные из цикла
            cell = maxScoreFieldCell;
        }
    }
}
