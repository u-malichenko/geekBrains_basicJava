package malichenko.basicJava.Lession6.Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 1. Разработать оконное приложение «Калькулятор»;
 * 1.1. Калькулятор должен выполнять 4 простейшие арифметические операции.
 * 1.2. Калькулятор должен иметь одно окно вывода результатов.
 * 1.3. Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.
 *
 * Подсказка 1: поля ввода в приложении дают читать только текстовые данные. Для преобразования
 * нужно использовать классы-оболочки: https://habrahabr.ru/post/49582/.
 *
 * Подсказка 2: можно сделать код гораздо проще, изучив возможности ActionEvent:
 * https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener.
 *
 * 2. * Научить калькулятор операции возведения в степень.
 */
public class Calc {
    public static Double x = new Double(0);
    public static Double y = new Double(0);
    public static String operator = "0"; //переменная для хранения оператора действия

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //создание окна
                JFrame frame = new JFrame("Calc");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(250, 300);
                frame.setLocation(600, 300);

                //определение интерфейса окна
                Container container = frame.getContentPane();
                container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
                String[] arr = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "^", "0", "=", "+"};
                JTextField textField = new JTextField(20);
                container.add(textField);

                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        double res = 0;
                        JButton button = (JButton) e.getSource();
                        String command = button.getActionCommand();
                        switch (command) {
                            case "-":
                            case "+":
                            case "*":
                            case "/":
                            case "^":
                                if (x > 0) {
                                    textField.setText(textField.getText() + command + " ");
                                    operator = command;
                                } //else if (command.equals("-"))
                                    //textField.setText("-");// TODO дорабоаттаь отрицательные числа, нуна метка
                                break;
                            case "1":
                            case "2":
                            case "3":
                            case "4":
                            case "5":
                            case "6":
                            case "7":
                            case "8":
                            case "9":
                            case "0": {
                                if (x > 0 && !operator.equals("0")) { //проверяем какое число вводим 1X или 2еY если х больше 0 и оператор не равен 0 и оператор уже введен
                                    y = Double.valueOf(command);
                                    textField.setText(textField.getText() + y + " ");
                                } else if (x <= 0) { //запрет пользователю воодить несколько раз числа
                                    x = Double.parseDouble(command);
                                    textField.setText(textField.getText() + x + " ");
                                }
                                break;
                            }
                            case "=": {
                                if (x != 0 && y != 0) { //проверяем наличие обоих чисел, производи рассчет
                                    switch (operator) {
                                        case "+":
                                            res = x + y;
                                            break;
                                        case "-":
                                            res = x - y;
                                            break;
                                        case "*":
                                            res = x * y;
                                            break;
                                        case "/":
                                            res = x / y;
                                            break;
                                        case "^":
                                            res = Math.pow(x, y);
                                            break;
                                        default:
                                            break;
                                    }
                                    textField.setText(textField.getText() + " = " + res);
                                    //JOptionPane.showMessageDialog(container, "Результат вычисления равен: " + res); //вывод результата
                                    if(JOptionPane.showConfirmDialog(container, "Результат вычисления равен: " + res+"\nЗакрыть калькулятор?","Хотите закрыть калькулятор?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0){
                                        System.exit(0); //для закрытия окна
                                    } else{
                                        textField.setText("");
                                        x = 0.0;
                                        y = 0.0;
                                        operator ="0";
                                    }
                                }
                                break;
                            }
                        }
                    }
                };
                //создаем таблицу с кнопками
                Container grid = new JPanel(new GridLayout(4, 4, 5, 12));
                for (int i = 0; i < 16; i++) {
                    JButton btn = new JButton(arr[i]);
                    btn.setActionCommand(arr[i]);
                    btn.addActionListener(listener);
                    grid.add(btn);
                }
                container.add(grid);
                frame.setVisible(true);
            }
        });
    }
 }


