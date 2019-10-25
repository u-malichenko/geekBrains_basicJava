package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
    public BorderLayoutTest(){
        super("BorderLayoutTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250,250);

        //панель содержимого экземпляр класса контейнер полусаем его при помощи метода getContentPane
        Container container = getContentPane();
        /*
        * Размещаем в панели компоненты
        * В качестве параметров можно использовать
        * строки и константы класса BorderLayout
         */
        container.add(new JButton("Север" ), "North"); // необходимо указывать область в которую мы добавляем наш конетйнер
        container.add(new JButton("Юг" ), "South"); // можно строкой - "South"
        container.add(new JLabel("Запад" ), BorderLayout.WEST); // либо параметром класаа BorderLayout - BorderLayout.WEST
        container.add(new JLabel("Восток"), BorderLayout.EAST);

        //При отсутствиии 2го параметра компонент размещается в центре
        container.add(new JButton("Центр"));// тут отсутствует второй прааметр расположения юг серер запад восток

        //открываем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}
