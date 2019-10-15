//5. Создать классы Собака и Кот с наследованием от класса Животное;

public class Cat extends Animal {

    //конструктор без параметров:
    public Cat(){
    }

    //конструктор с параметрами:
    public Cat(String _name, double _run, double _jump){
        super("Кот " + _name); //переопределяем конструктор с именем
        this.maxRun = _run;
        this.maxJump = _jump;
    }

    //специфичный метод перезаписанный из абстрактного метода и класса Animal:
    @Override
    protected String voice() {
        return "Meeey";
    }
}
