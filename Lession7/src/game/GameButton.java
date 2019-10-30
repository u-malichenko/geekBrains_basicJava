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

        int row = buttonIndex / GameBoard.dimension;
        int cell = buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener(new GameActionListener(row, cell, this));
    }

    /**
     * метод получения ссылки на игровое поле
     * @return - сылку на игровое поле
     */
    public GameBoard getBoard() {
        return board;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }
}


