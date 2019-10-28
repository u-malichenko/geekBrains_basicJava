package malichenko.basicJava.Lession6;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

//менеджер вертикального расположения компонентов
public class VerticalLayout implements LayoutManager
{
    private Dimension size = new Dimension();

    //следующие два метода не используются
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }
    @Override
    public void removeLayoutComponent(Component comp) {

    }

    //Метод определения минимального размера для контейнера public Dimension minimumLayoutSize
    @Override
    public Dimension minimumLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    //Метод определения предпочтительного размера для контейнера
    @Override
    public Dimension preferredLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    //метод расположения компонентов в контейнере
    @Override
    public void layoutContainer(Container container) {
        //список компонентов получаем общий массив всех компонет в контейнере
        Component list[] = container.getComponents();
        int currentY = 5;

        //цикл преребора компонентов
        for (int i = 0; i < list.length; i++) {

            //определение предпочтительного размера компонента через метод getPreferredSize
            Dimension pref = list[i].getPreferredSize();

            //размещение компонента на экране методом setBounds
            list[i].setBounds(5,currentY,pref.width,pref.height);

            //учитываем промежуток в 5 пикселов увеличиваем вертикальную текущую координату
            currentY += 5;

            //смещаем вертикальную позицию компонента увеличивая ее на высоту очередного компонента(полученный предпочтительный размер по высоте)
            currentY += pref.height;
        }
    }

    //Метод вычисления оптимального размера контейнера
    private Dimension calculateBestSize(Container c){
        //вычисление длинны конетейнера
        Component[] list = c.getComponents();
        int maxWidth = 0;

        //в цикле в компонентах ищем с самой большой длинной
        for (int i = 0; i < list.length; i++) {
            int width = list[i].getWidth();

            //поиск компонента с максиьальной длинной
            if(width > maxWidth)
                maxWidth = width;
        }

        //размер контейнера в длинну с учетом левого отступа к максимальному додавляем 5 пикселей
        size.width = maxWidth +5; // и мы получаем оптимальную ширину(длинну)

        //вычисление высоты контейнера
        //необходимо сложить все высоты компонентов и прибавить к ним отступы между всеми компонентами
        int height =0;
        for (int i = 0; i < list.length; i++) {
            height += 5; //прибавляем отступ
            height += list[i].getHeight();
        }
        size.height = height;
        return size;
    }
}
