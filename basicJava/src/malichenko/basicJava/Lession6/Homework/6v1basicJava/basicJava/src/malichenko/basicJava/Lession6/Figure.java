package malichenko.basicJava.Lession6;

import javax.swing.*;
import java.awt.*;

public class Figure extends JComponent {
    private Color color;
    private int type; // 0 круг 1 - прямоугольник
    private String text;

    //параметры цвет и тип фигуры
    Figure(Color color,int type, String text){
        this.color = color;
        this.type = type;
        this.text = text;
        setOpaque(false);
    }

    public void paintComponent(Graphics g){
        //проприсовка фигуры
        g.setColor(color);
        switch (type){
            case 0: g.fillOval(0,0,90,90); break;
            case 1: g.fillRect(0,0,130,80); break;
        }
    }
}
