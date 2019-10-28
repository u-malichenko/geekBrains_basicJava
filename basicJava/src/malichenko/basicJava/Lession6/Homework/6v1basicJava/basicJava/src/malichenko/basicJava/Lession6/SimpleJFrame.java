package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class SimpleJFrame {
    public static void createGUI()
    {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Test label");
        frame.getContentPane().add(label);
        frame.setPreferredSize(new Dimension( 200,100));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() { //вызовв отлдельом потоке
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
