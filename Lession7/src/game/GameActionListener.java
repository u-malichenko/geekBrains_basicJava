package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    // ряд и строка кнопки
    private int row;
    private int cell;

    //ссылка на нашу кнопку
    private GameButton button;

    //конструктор
    public GameActionListener(int row, int cell, GameButton gButton){
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
