package malichenko.basicJava.Lession6.Homework;

import javax.swing.*;

public class _3CalculatorApp extends JFrame {
    public _3CalculatorApp(){
        super("Калькулятор преподавателя");

        this.setBounds(500,500,400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        _3CalculatorPanel panel = new _3CalculatorPanel();

        setContentPane(panel);
        setVisible(true);
    }
}
