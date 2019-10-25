package malichenko.basicJava.Lession6;

import javax.swing.*;

public class ContentPaneTest extends JFrame {
    public ContentPaneTest(){
        super("Test ContentPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //создание панели с двумя кнопками
        JPanel contents = new JPanel();
        contents.add(new JButton("Java"));
        contents.add(new JButton("PHP"));

        //замена понели содержимого
        setContentPane(contents);

        //определение размера окна
        setSize(200,100);

        //открытие окна
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ContentPaneTest();
    }
}
