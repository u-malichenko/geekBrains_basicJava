//5. Создать классы Собака и Кот с наследованием от класса Животное;

public class Cat extends Animal {

    //конструктор без параметров:
    public Cat(){
    }

    //конструктор с параметрами:
    public Cat(String _name, double _run, double _jump){
        this.name = _name;
        this.run = _run;
        this.jump = _jump;
    }

    //специфичный метод перезаписанный из абстрактного метода и класса Animal:
    @Override
    protected String voice() {
        return "Meeey";
    }
}
