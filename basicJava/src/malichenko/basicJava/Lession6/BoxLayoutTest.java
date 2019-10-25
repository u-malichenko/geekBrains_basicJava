package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutTest {
    /**
     * Процедура добавления кнопки в контейнер
     * @param caption заголовок кнопки
     * @param container контейнер
     */
    private static void addButton(String caption, Container container){
        JButton button = new JButton(caption);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    /**
     * роцедура создания интерфейса формы
     * @param container - контейнер
     */
    public static void createUI (Container container){
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        addButton("Хлеб", container);
        addButton("Молоко", container);
        addButton("Колбаса", container);
        addButton("Мясо и птица", container);
        addButton("мороженные продукты", container);

    }

    public static void main(String[] args) {
        //создание окна
        final JFrame frame = new JFrame("BoxLayoutTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //определение интерфейса окна
        createUI(frame.getContentPane());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //открытиеокна
                frame.pack();
                frame.setVisible(true);
            }
        });


    }

}
