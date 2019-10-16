//5. Создать классы Собака и Кот с наследованием от класса Животное;

public class Cat extends Animal {

    //конструктор без параметров устанавливает лимиты по умолчанию:
    public Cat(){
        this.maxRun = 200;
        this.maxJump = 2;
    }

    //конструктор с параметрами дает возможность задавать лимиты для каждого животного отдельно:
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
