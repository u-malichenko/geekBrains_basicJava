//5. Создать классы Собака и Кот с наследованием от класса Животное;

public class Cat extends Animal {

    //конструктор с параметрами:
    public Cat(String _name){
        super("Кот " + _name); //переопределяем конструктор с именем
        this.maxRun = 200;
        this.maxJump = 2;
    }

    //специфичный метод перезаписанный из абстрактного метода и класса Animal:
    @Override
    protected String voice() {
        return "Meeey";
    }

    public void swim(double _distance) {
            System.out.println(this.name + " не умеет плавать!");
    }

}
