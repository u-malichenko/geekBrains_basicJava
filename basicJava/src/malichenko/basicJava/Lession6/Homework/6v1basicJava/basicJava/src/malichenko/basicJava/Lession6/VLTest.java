package malichenko.basicJava.Lession6;

import javax.swing.*;

public class VLTest {
    public static void main(String[] args) {
        //создаем окно
        JFrame frame = new JFrame("VerticalLayoutTest");

        //Определяем размеры
        frame.setSize(260,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //создаем панель с менеджером вертикального расположения компонентов
        JPanel contents = new JPanel(new VerticalLayout());

        //добавляем кнопки и текстовое поле в панель
        contents.add(new JButton("Продукты"));
        contents.add(new JButton("Галантерея"));
        contents.add(new JTextField(20));

        //размещаем панель в контейнере
        frame.setContentPane(contents);

        //открываем окно
        frame.setVisible(true);
    }
}
