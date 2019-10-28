package malichenko.basicJava.Lession6.Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class _3CalculatorPanel extends JPanel {
    public _3CalculatorPanel(){
        setLayout(new BorderLayout());

        //панель ввода
        JPanel insertPanel = new JPanel();
        insertPanel.setLayout(new GridBagLayout());
        GridBagConstraints c =new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx =0.5;

        JLabel labelArgument1 = new JLabel("Argument1");
        c.gridx=0;
        c.gridy=0;
        insertPanel.add(labelArgument1,c);

        JTextField argument1 = new JTextField(10);
        c.gridx=1;
        c.gridy=0;
        insertPanel.add(argument1,c);

        JLabel labelArgument2 = new JLabel("Argument2");
        c.gridx=0;
        c.gridy=1;
        insertPanel.add(labelArgument2,c);

        JTextField argument2 = new JTextField(10);
        c.gridx=1;
        c.gridy=1;
        insertPanel.add(argument2,c);

        JLabel labelResult = new JLabel("result");
        c.gridx=0;
        c.gridy=2;
        insertPanel.add(labelResult,c);

        JTextField result = new JTextField(10);
        c.gridx=1;
        c.gridy=2;
        insertPanel.add(result,c);

        add(insertPanel,BorderLayout.CENTER);

        //панель клавиш
        JPanel controlPanel = new JPanel();
        JButton buttonAddition = new _3CalculatorButton("+");
        JButton buttonSubtraction = new _3CalculatorButton("-");
        JButton buttonDivision = new _3CalculatorButton("/");
        JButton buttonMultiply = new _3CalculatorButton("*");
        JButton buttonPower = new _3CalculatorButton("^");

        controlPanel.add(buttonAddition);
        controlPanel.add(buttonSubtraction);
        controlPanel.add(buttonDivision);
        controlPanel.add(buttonMultiply);
        controlPanel.add(buttonPower);
        add(controlPanel, BorderLayout.SOUTH);

        //обработчик события
        ActionListener buttonActionListener = new _3CalculatorActionListener(argument1, argument2,result);

        //навешиваем события
        buttonAddition.addActionListener(buttonActionListener);
        buttonSubtraction.addActionListener(buttonActionListener);
        buttonDivision.addActionListener(buttonActionListener);
        buttonMultiply.addActionListener(buttonActionListener);
        buttonPower.addActionListener(buttonActionListener);

    }
}
