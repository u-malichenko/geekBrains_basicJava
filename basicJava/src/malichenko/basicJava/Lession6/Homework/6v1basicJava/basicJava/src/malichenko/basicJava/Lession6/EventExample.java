package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventExample {
    public static void main(String[] args) {

        //создаем окно
        JFrame frame = new JFrame("VerticalLayoutTest");
        //определяем размеры
        frame.setSize(260, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //создаем панель с менеджером вертикального расположения компонентов
        JPanel contents = new JPanel(new FlowLayout()); //добавим кнопки и текстовое поле в парнель
        JButton button = new JButton("Событие");
        JTextField field = new JTextField(20);

        //добавляем кнопку на панель
        contents.add(button);
        contents.add(field);

        //создаем слушатель
        ActionListener listener = new ActionListener() {
            //в тело этого метода мы задаем поеведение
            //которое будет выполняться при нажатии на кнопку
            @Override
            public void actionPerformed(ActionEvent e) { //анонимный класс
                System.out.println("Button pressed..."); // вывод в консоль нашего нажатия
            }
        };

        ActionListener fieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + field.getText());
            }
        };

        //устанавливаем слушатель
        button.addActionListener(listener);

        field.addActionListener(fieldListener);

        //удалить слушателя
       // button.removeActionListener(listener);

        //размещаем панель в конетейнере
        frame.setContentPane(contents);

        //открываем окно
        frame.setVisible(true);
    }
}
