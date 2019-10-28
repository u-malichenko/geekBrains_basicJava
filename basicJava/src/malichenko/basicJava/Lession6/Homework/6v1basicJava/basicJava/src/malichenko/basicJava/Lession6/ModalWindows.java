package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModalWindows {
    public static void main(String[] args) {
        //Создаем окно
        JFrame frame = new JFrame("VerticalLayoutTest");
        //определяем размеры
        frame.setSize(260,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создаем панель с менеджером вертикального расположения компонеттов
        JPanel contents = new JPanel(new FlowLayout()); //добавляем кнопки и текстовое полев
        JButton button = new JButton("Событие");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contents,"<html><h2>Текст</h2><i>в виде разметки HTML</i>","Ошибка!",JOptionPane.ERROR_MESSAGE);
            }
        };

        button.addActionListener(listener);

        contents.add(button);

        //размещаем панель в контейнере
        frame.setContentPane(contents);

        frame.setVisible(true);

    }
}
