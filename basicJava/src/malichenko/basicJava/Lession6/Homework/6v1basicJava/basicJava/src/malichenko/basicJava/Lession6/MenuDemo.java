package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuDemo extends JFrame implements ActionListener {
    public MenuDemo(){
        //Создаем панель меню
        JMenuBar menubar = new JMenuBar();

        //создаем меню
        JMenu menu = new JMenu("File");

        //---------------------------------
        //добавление простых элементов меню
        //элемент 1
        JMenuItem itm = new JMenuItem("New");
        menu.add(itm);
        itm.addActionListener(this);

        //элемент 2
        itm = new JMenuItem("Open");
        itm.addActionListener(this);
        menu.add(itm);

        //элемент 3
        itm = new JMenuItem("Close");
        itm.addActionListener(this);
        menu.add(itm);

        //если нужен элемент меню с иконкой
        //itm = new JMenuItem("Close", new ImageIcon("image.gif"));
        //itm = new JMenuItem(new ImageIcon("image.gif"));

        //добавляем разделитель
        menu.add(new JSeparator());

        //создаем вложенное меню
        JMenu submenu = new JMenu("Sub");
        itm = new JMenuItem("Print");
        itm.addActionListener(this);
        submenu.add(itm);

        //следующему элементу назначаем быструю клавишу ALT+E
        itm = new JMenuItem("Export");
        itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        itm.addActionListener(this);
        submenu.add(itm);

        //добавляем вложенное меню
        menu.add(submenu);

        //добавляем менбю в панель меню
        menubar.add(menu);

        //добавляем панель меню в окно
        setJMenuBar(menubar);

        //---------------------------------------------------
        //настройка окна
        setTitle("Menu Demo"); //заголовок окна
        //Желательные размеры окна
        setPreferredSize(new Dimension(640,480));
        //завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();//устанавливаем желательные размеры
        setVisible(true); //щтображаем окно



    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new MenuDemo();
    }
}
