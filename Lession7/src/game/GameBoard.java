package game;

import javax.swing.*;

public class GameBoard extends JFrame {
    //размерность
    static int dimension = 3;

    //размер одной клетки
    static int cellSize = 150;

    //матрица игры
    private char[][] gameField;

    //массив кнопок
    private GameButton[] gameButtons;

    //ссылка на игру
    private Game game;

    //конструктор
    public GameBoard(Game currentGame){
        this.game = currentGame;
    }

}
