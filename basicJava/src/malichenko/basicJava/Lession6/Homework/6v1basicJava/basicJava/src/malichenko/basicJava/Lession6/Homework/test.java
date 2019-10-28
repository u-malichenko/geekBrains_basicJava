//
//package malichenko.basicJava.Lession6.Homework;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
///**
// * 1. Разработать оконное приложение «Калькулятор»;
// * 1.1. Калькулятор должен выполнять 4 простейшие арифметические операции.
// * 1.2. Калькулятор должен иметь одно окно вывода результатов.
// * 1.3. Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.
// *
// * Подсказка 1: поля ввода в приложении дают читать только текстовые данные. Для преобразования
// * нужно использовать классы-оболочки: https://habrahabr.ru/post/49582/.
// *
// * Подсказка 2: можно сделать код гораздо проще, изучив возможности ActionEvent:
// * https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener.
// *
// * 2. * Научить калькулятор операции возведения в степень.
// */
//public class Calc {
//    public static Double x = new Double(0);
//    public static Double y = new Double(0);
//    public static String operator = "0"; //переменная для хранения оператора действия
//
//    public static void main(String[] args) {
//
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//                //создание окна
//                JFrame frame = new JFrame("Calc");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setSize(250, 300);
//                frame.setLocation(600, 300);
//                frame.setResizable(false);
//
//                //определение интерфейса окна
//                Container container = frame.getContentPane();
//                container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
//                String[] arr = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "^", "0", "=", "+"};
//
//                JTextArea textArea = new JTextArea();
//                container.add(textArea);
//                //JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//                JLabel panelLabel = new JLabel();
//                panelLabel.setPreferredSize(new Dimension(248,60));
//                panelLabel.setBackground(Color.gray);
//                container.add(panelLabel);
//
//                ActionListener listener = new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        double res = 0;
//                        JButton button = (JButton) e.getSource();
//                        String command = button.getActionCommand();
//                        switch (command) {
//                            case "-":
//                            case "+":
//                            case "*":
//                            case "/":
//                            case "^":
//                                if (x > 0 && operator.equals("0") ) {
//                                    textArea.setText(textArea.getText() + command + " ");
//                                    operator = command;
//                                } //else if (command.equals("-"))
//                                //textArea.setText("-");// TODO дорабоаттаь отрицательные числа, нуна метка
//                                break;
//                            case "1":
//                            case "2":
//                            case "3":
//                            case "4":
//                            case "5":
//                            case "6":
//                            case "7":
//                            case "8":
//                            case "9":
//                            case "0": {
//                                if (x > 0 && !operator.equals("0")) { //проверяем какое число вводим 1X или 2еY если х больше 0 и оператор не равен 0 и оператор уже введен
//                                    y = Double.valueOf(command);
//                                    textArea.setText(textArea.getText() + y + " ");
//                                } else if (x <= 0) { //запрет пользователю воодить несколько раз числа
//                                    x = Double.parseDouble(command);
//                                    textArea.setText(textArea.getText() + x + " ");
//                                }
//                                break;
//                            }
//                            case "=": {
//                                if (x != 0 && y != 0) { //проверяем наличие обоих чисел, производи рассчет
//                                    switch (operator) {
//                                        case "+":
//                                            res = x + y;
//                                            break;
//                                        case "-":
//                                            res = x - y;
//                                            break;
//                                        case "*":
//                                            res = x * y;
//                                            break;
//                                        case "/":
//                                            res = x / y;
//                                            break;
//                                        case "^":
//                                            res = Math.pow(x, y);
//                                            break;
//                                        default:
//                                            break;
//                                    }
//                                    textArea.setText(textArea.getText() + " = " + res);
//                                    if(JOptionPane.showConfirmDialog(container, "Результат вычисления равен: " + res+"\nЗакрыть калькулятор?","Хотите закрыть калькулятор?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0){
//                                        System.exit(0); //для закрытия окна
//                                    } else{
//                                        panelLabel.setText("<html>"+ textArea.getText()+"<br>"+ panelLabel.getText()+"</html>");
//                                        textArea.setText("");
//                                        x = 0.0;
//                                        y = 0.0;
//                                        operator ="0";
//                                    }
//                                }
//                                break;
//                            }
//                        }
//                    }
//                };
//                //создаем таблицу с кнопками
//                Container grid = new JPanel(new GridLayout(4, 4, 5, 12));
//                for (int i = 0; i < 16; i++) {
//                    JButton btn = new JButton(arr[i]);
//                    btn.setActionCommand(arr[i]);
//                    btn.addActionListener(listener);
//                    grid.add(btn);
//                }
//                container.add(grid);
//                frame.setVisible(true);
//            }
//        });
//    }
//}
//
//
//
////package malichenko.basicJava.Lession6.Homework;
////
////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
/////**
//// * 1. Разработать оконное приложение «Калькулятор»;
//// * 1.1. Калькулятор должен выполнять 4 простейшие арифметические операции.
//// * 1.2. Калькулятор должен иметь одно окно вывода результатов.
//// * 1.3. Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.
//// * Подсказка 1: поля ввода в приложении дают читать только текстовые данные. Для преобразования
//// * нужно использовать классы-оболочки: https://habrahabr.ru/post/49582/.
//// * <p>
//// * Подсказка 2: можно сделать код гораздо проще, изучив возможности ActionEvent:
//// * https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener.
//// * <p>
//// * 2. * Научить калькулятор операции возведения в степень.
//// */
////public class test {
////
////    public static void main(String[] args) {
////
////        javax.swing.SwingUtilities.invokeLater(new Runnable() {
////            @Override
////            public void run() {
////                Double x = 0.0;
////                Double y = 0.0;
////
////                //создание окна
////                JFrame frame = new JFrame("Calc");
////                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////                frame.setSize(300,300);
////
////                //определение интерфейса окна
////
////                Container container = frame.getContentPane();
////
////                container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
////                String[] arr = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+"};
////
////                JTextField textField = new JTextField(20);
////                container.add(textField);
////
////                Container grid = new JPanel(new GridLayout(4, 4, 5, 12));
////
////
////                for (int i = 0; i < 16; i++) {
////                    //addButton("" + arr[i],grid);
////                    //grid.add(new JButton("" + arr[i]));
////
////                    JButton btn = new JButton(arr[i]);
////
////                    btn.setActionCommand(arr[i]);
////                    //btn.addActionListener(this);
////                    grid.add(btn);
////
////                }
////                container.add(grid);
////
//////                 ActionListener listener = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        String result = JOptionPane.showInputDialog(container,"Введите первое число:");
//////                        double x = Double.parseDouble(result);
//////                        textField.setText(result);
//////                    }
//////                };
////
////                frame.setVisible(true);
////            }
////        });
////
////
////
////
////    }
////}
////
//////                JButton button1 = new JButton("введите первое число");
//////                button1.setAlignmentX(Component.CENTER_ALIGNMENT);
//////                container.add(button1);
//////
//////                JButton button2 = new JButton("введите второе число");
//////                button2.setAlignmentX(Component.CENTER_ALIGNMENT);
//////                container.add(button2);
//////
//////                //вспомогательная панель
//////                JPanel grid = new JPanel();
//////                GridLayout layout = new GridLayout(2,4,5,12);
//////                grid.setLayout(layout);
//////
//////                JButton button3 = new JButton("+");
//////                button3.setAlignmentX(Component.CENTER_ALIGNMENT);
//////                grid.add(button3);
//////
//////                JButton button4 = new JButton("-");
//////                button4.setAlignmentX(Component.CENTER_ALIGNMENT);
//////                grid.add(button4);
//////
//////                JButton button5 = new JButton("*");
//////                button5.setAlignmentX(Component.CENTER_ALIGNMENT);
//////                grid.add(button5);
//////
//////                JButton button6 = new JButton("/");
//////                button6.setAlignmentX(Component.CENTER_ALIGNMENT);
//////                grid.add(button6);
//////
//////
//////
//////
//////
//////                JLabel label1 = new JLabel();
//////                label1.setAlignmentY(Component.CENTER_ALIGNMENT);
//////                grid.add(label1);
//////
//////                JLabel label2 = new JLabel();
//////                label2.setAlignmentY(Component.CENTER_ALIGNMENT);
//////                grid.add(label2);
//////
//////                JLabel label3 = new JLabel();
//////                label3.setAlignmentY(Component.CENTER_ALIGNMENT);
//////                grid.add(label3);
//////
//////                JLabel label4 = new JLabel();
//////                label4.setAlignmentY(Component.CENTER_ALIGNMENT);
//////                grid.add(label4);
//////
//////                container.add(grid);
//////
//////
//////
//////                ActionListener listener1 = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        String result = JOptionPane.showInputDialog(container,"Введите первое число:");
//////                        double x = Double.parseDouble(result);
//////                        label1.setText(result);
//////                    }
//////                };
//////
//////                ActionListener listener2 = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        String result = JOptionPane.showInputDialog(container,"Введите первое число:");
//////                        double y =  Double.parseDouble(result);
//////                        label3.setText(result);
//////
//////
//////                    }
//////                };
//////
//////                ActionListener listener3 = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        double result = x + y;
//////                        label2.setText(" плюс "+result);
//////                    }
//////                };
//////
//////                ActionListener listener4 = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        double result = x - y;
//////                        label4.setText(" вычесть "+result);
//////                    }
//////                };
//////
//////                ActionListener listener5 = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        double result = x * y;
//////                        label4.setText(" умножить "+result);
//////                    }
//////                };
//////
//////                ActionListener listener6 = new ActionListener() {
//////                    @Override
//////                    public void actionPerformed(ActionEvent e) {
//////                        double result = x / y;
//////                        label4.setText(" разделить "+result);
//////                    }
//////                };
//////
//////                //устанавливаем слушатель
//////                button1.addActionListener(listener1);
//////                button2.addActionListener(listener2);
//////                button3.addActionListener(listener3);
//////                button4.addActionListener(listener4);
//////                button5.addActionListener(listener5);
//////                button6.addActionListener(listener6);
////
//////открытиеокна
//////frame.pack();
//////                frame.setVisible(true);
//////                        }
//////                        });
//////
//////
//////
//////
//////                        }
//////                        }
////
//////public class Calc extends JFrame {
//////
//////    private static void addButton(String caption, Container container) {
//////        JButton button = new JButton(caption);
//////        button.setAlignmentX(Component.CENTER_ALIGNMENT);
//////        container.add(button);
//////    }
//////
//////
//////    public static void createGUI(Container container) {
//////        char[] arr = new char[]{'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '.', '0', '=', '+'};
//////
//////        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
//////
//////        JTextField textField = new JTextField(20);
//////        container.add(textField);
//////
//////        Container grid = new JPanel(new GridLayout(4, 4, 5, 12));
//////
//////
//////        for (int i = 0; i < 16; i++) {
//////            addButton("" + arr[i],grid);
//////            //grid.add(new JButton("" + arr[i]));
//////
//////        }
//////        container.add(grid);
//////
//////    }
//////
//////    public static void main(String[] args) {
//////        //создание окна
//////        final JFrame frame = new JFrame("Calc");
//////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////
//////        //определение интерфейса окна
//////        createGUI(frame.getContentPane());
//////
//////        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//////            @Override
//////            public void run() {
//////
//////                //открытиеокна
//////                frame.pack();
//////                frame.setVisible(true);
//////            }
//////        });
//////
//////
//////    }
//////}
////
////
//////    public Calc (){
//////        super("Calc");
//////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////        setSize(300,400);
//////        setLocation(100,100);
//////        setVisible(true);
//////
//////
//////        private static void addButton(String caption, Container container){
//////            JButton button = new JButton(caption);
//////            button.setAlignmentX(Component.CENTER_ALIGNMENT);
//////            container.add(button);
//////        }
//////
//////        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
//////
//////        JTextField textField = new JTextField(20);
//////        JPanel grid = new JPanel(new GridLayout(4,4, 5,12));
//////        for (int i = 0; i < 16 ; i++) {
//////            grid.add(new JButton("i"));
//////        }
//////
//////
//////        JPanel contents = new JPanel();
//////        contents.add(textField);
//////        contents.add(grid);
//////        setContentPane(contents);
//////
//////
//////    }
//////
//////    public static void main(String[] args) {
//////        JFrame.setDefaultLookAndFeelDecorated(true);
//////        javax.swing.SwingUtilities.invokeLater(new Runnable() { //вызовв отлдельом потоке
//////            @Override
//////            public void run() {
//////                new Calc();
//////            }
//////        });
//////    }
////
////
//////}
