package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogueExample {
    public static void main(String[] args) {
        //создаем окно
        JFrame frame = new JFrame("VerticalLayoutTest");
        //определяем размеры
        frame.setSize(260,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //создаем панель с менеджером вертикального расположения компонентов
        JPanel contents = new JPanel(new FlowLayout()); //добавим кнопки и текстовое поле
        JButton button= new JButton("Сщбытие");
        JTextField field = new JTextField(20);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = JOptionPane.showInputDialog(contents, "<html><h2>Добро пожаловать!</h2><p>Ваше имя?</p>"); //contents - привязка
                JOptionPane.showInputDialog(contents,"Вы ввели", result);
            }
        };

        button.addActionListener(listener);

        field.addActionListener(listener);

        contents.add(button);

        //размещаем панель в контейнере
        frame.setContentPane(contents);

        frame.setVisible(true);
    }
}
