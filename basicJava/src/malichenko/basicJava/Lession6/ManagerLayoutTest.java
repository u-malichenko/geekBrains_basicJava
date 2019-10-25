package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class ManagerLayoutTest extends JFrame {
    public ManagerLayoutTest(){
        super("ManagerLayoutTest");
        setSize(320,240);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //создание панели с табличным расположением
        JPanel grid = new JPanel(new GridLayout(1,2,5,0));

        //добавление кнопок в панель
        grid.add(new JButton("OK"));
        grid.add(new JButton("Отмена"));

        //Создание панели с последовательным расположением
        //компонентов и выравниванием по правому краю

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);

        //получение панели содержимого
        Container container = getContentPane();

        //размещение панели с кнопками внизу справа

        container.add(flow, BorderLayout.SOUTH);

        //открытие окна
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerLayoutTest();
    }
}
