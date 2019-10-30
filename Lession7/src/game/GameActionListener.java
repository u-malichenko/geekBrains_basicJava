package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    // ряд и строка кнопки
    private int row;
    private int cell;

    //ссылка на нашу кнопку
    private GameButton button;

    //конструктор
    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //через нашу кнопку мы можем получить ссылку на геймбоард:
        GameBoard board = button.getBoard();

        //при ходе мы должны проверять можем ли мы в данную клетку текущему игроку
        //если тру то изменяем кнопку(передаем координаты)
        if (board.isTurnable(row, cell)) {
            //простановка символа игрока
            //вызываем метод обновления данных для игрока человека метод человека
            updateByPlayersData(board);

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
            else if(!board.getGame().getCurrentPlayer().isRealPlayer()){
                updateByAiData(board);
            }
        }
        else {
            //сообщение об ошибке
            //чрез борд получаем ссылку на игру гетГаме
            //и при помощи метода шоуМессадж говорим пакость
            board.getGame().showMessage("Некорректный ход");
        }
    }

    /**
     * ход человека
     * @param board - GameBoard ссылка на игровое поле
     */
    private void updateByPlayersData(GameBoard board) {
        //обновляем матрицу игры - записываем в ее значение проставленного хода
        board.updateGameField(row, cell);

        //теперь нужно обновить содержимое кнопки
        //обращаемся к Баттон задаем ей сет текст и при помощи класса Обертки Чарактер
        // переводим ту стринг и получаем символ игрока известным нам методом:
        //для того тчоб получить этот символ у нас есть геттер на объект игры game
        //у ее мы можем узнать кто же сейчас текущий игрок, но только текущего игрока не хватит
        //мы должны поставить туда его символ а не его самого, по этому
        //у полученного объекта игрока getCurrentPlayer мы получаем символ через getPlayerSign
        //чар и стринг не идентичные типы так что используем тустринг
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        //и после хода нам нужно проверить состояние победы
        if (board.checkWin()) {
            //если он возвращает тру оповещаем игрока о том что он выиграл
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();            //чистим поле
        }
        else {         //иначе мы должны передать ход
            board.getGame().passTurn();
        }

    }

    private void updateByAiData(GameBoard board) {
        //генерация координат хода компьютера
        int x, y;
        Random rnd = new Random();

        do {
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        } while (!board.isTurnable(x, y));

        //обновить матрицу игры
        board.updateGameField(x, y);

        //обновить содержимое кнопки
        //получить индекс кнопки:
        //размерность нашего поля нужно умножить на номер ряда и прибавить номер столбца
        //это обратная формула к тем самым двум
        int cellIndex = GameBoard.dimension * x + y;

        //получить кнопку по ее индексу getButton(cellIndex
        //и присваиваем ее тексту значение символа текущего игрока тоесть компа
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        //проверяем победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл");
            board.emptyField();
        } else {//если победа не найдена то предаем ход игроку
            //передать ход
            board.getGame().passTurn();
        }

    }
}
