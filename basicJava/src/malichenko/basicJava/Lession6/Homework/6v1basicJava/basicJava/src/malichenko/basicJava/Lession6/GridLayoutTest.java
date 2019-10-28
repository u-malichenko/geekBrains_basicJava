package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame
{
    public GridLayoutTest(){
        super("GridLayout");
        setSize(320,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //вспомогательная панель
        JPanel grid = new JPanel();

        /*
        *  Первые два конструктора GridLayout определяют количество
        * строчек и столбцов в таблице. Вторые 2 параметра - расстояние между
        * ячейками по горизонталии и вертикали
         */
        GridLayout layout = new GridLayout(2,0,5,12); //0 - рандомное колличество столбцов, одновременно оба 0 делать низя
        grid.setLayout(layout);

        //создаем 8 кнопок
        for (int i = 0; i < 8; i++) {
            grid.add(new JButton("Кнопка" + i));
        }

        //размещаем нашу панель в панели содержимого
        getContentPane().add(grid);

        //Устанавливаем оптимальный размер окна
        pack();

        //открываем коно
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutTest();
    }
}
