package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest extends JFrame {
    public FlowLayoutTest(){
        super("FlowLayout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,120);

        //панель содержимого
        Container container = getContentPane();

        /*
        * Определение последовательного расположения
        * с выравниванием компонентов по центру
         */
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        //добавляем компоненты
        container.add(new JButton("Школа"));
        container.add(new JButton("Институт"));
        container.add(new JButton("Академия"));

        //открываем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}
