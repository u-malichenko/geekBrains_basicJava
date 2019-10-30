package game;

import javax.swing.*;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    /**
     * Конструктор кнопки
     * @param gameButtonIndex -на вход получает номер кнопочки и
     * @param currentGameBoard - и сылку на текущее игровое поле
     */
    public GameButton(int gameButtonIndex, GameBoard currentGameBoard) {
        buttonIndex = gameButtonIndex;
        board = currentGameBoard;

        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    /**
     * метод получения ссылки на игровое поле
     * @return - сылку на игровое поле
     */
    public GameBoard getBoard() {
        return board;
    }
}
