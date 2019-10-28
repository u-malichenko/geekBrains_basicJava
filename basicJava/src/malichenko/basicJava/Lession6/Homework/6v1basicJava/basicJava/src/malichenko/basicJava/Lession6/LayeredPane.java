package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class LayeredPane extends JFrame{
    public LayeredPane()
    {
        //создание окна
        super("Exaple LayeredTest");

        //выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //определение многослойности панели
        JLayeredPane lp = getLayeredPane();

        //создание трех фигур
        Figure figure1 = new Figure(Color.red, 0, "Figure popup");
        Figure figure2 = new Figure(Color.blue, 0, "Figure 1");
        Figure figure3 = new Figure(Color.cyan, 1, "Figure 2");

        //определение местоположения фигур в окне
        figure1.setBounds(10, 40, 120, 120);
        figure2.setBounds(60, 120, 160, 180);
        figure3.setBounds(90, 55, 250, 180);

        //добавление фигур в различные слои
        lp.add(figure1, JLayeredPane.POPUP_LAYER);
        lp.add(figure2, JLayeredPane.PALETTE_LAYER);
        lp.add(figure3, JLayeredPane.PALETTE_LAYER);

        //сменапозиции одной из фигур
        lp.setPosition(figure3, 0);

        //опеределение размера и открытие окна
        setSize(280, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new LayeredPane(); //вызов в главном потоке
    }
}