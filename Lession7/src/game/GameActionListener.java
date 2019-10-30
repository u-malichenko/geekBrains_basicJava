package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Даж еесли ПК, каким то чудом выиграл, все равно нужно предавать ход живому игроку
 */
public class GameActionListener implements ActionListener {
    //ссылка на нашу кнопку
    private GameButton button;

    //конструктор
    public GameActionListener(int row, int cell, GameButton gButton) {
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //через нашу кнопку мы можем получить ссылку на геймбоард:
        GameBoard board = button.getBoard();

        int row = button.getButtonIndex() / GameBoard.dimension;
        int cell = button.getButtonIndex() % GameBoard.dimension;

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
}
