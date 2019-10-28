package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutTest  extends JFrame {
    /**
     *
     * @param container
     */
    public static void createPanelUI(Container container){
        JButton button;
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(); // необходимо настраивать класс - GridBagConstraints для каждого добавляемого компонента

        //по умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.HORIZONTAL; //-тип заполнения
        constraints.weightx = 0.5; // -вес
        constraints.gridy = 0; //нулевая ячейка табилцы по вертикали - куда элемент будет вставлен
        button = new JButton("Школа");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0; //нулевая ячейка табилцы по горизонтали
        container.add(button, constraints);

        button = new JButton("Институт");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1; //1 ячейка табилцы по горизонтали
        container.add(button, constraints);

        button = new JButton("Академия");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2; //2 ячейка табилцы по горизонтали
        container.add(button, constraints);

        button = new JButton("Высокая кнопка размером в 2 ячейки");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 45; //кнопка высокая
        constraints.weightx = 0.0;
        constraints.gridwidth = 2; //размер кнопки в 2 ячейки
        constraints.gridx = 0; //0я ячейка по горизонтали
        constraints.gridy = 1; //1я ячейка по вертикали
        container.add(button, constraints);

        button = new JButton("Семья");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 0; //установить первоначальный размер кнопки
        constraints.weighty = 1.0; // установить отступ

        //установить кнопку в конец окна
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.insets = new Insets(5,0,0,0); // граница ячейки по У
        constraints.gridwidth = 2; // размер кнопки в 2 ячейки
        constraints.gridx = 1; //первая ячейка таблицы по горизонтали
        constraints.gridy = 2; //вторая ячейка по вертикали
        container.add(button, constraints);

    }

    public static void main(String[] args) {
        //создание окна
        JFrame frame =  new JFrame("GridBagLayoutTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //оперделить панель содержания
        createPanelUI(frame.getContentPane());

        //показать окно
        frame.pack();
        frame.setVisible(true);

    }
}
