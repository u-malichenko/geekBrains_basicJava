//5. Создать классы Собака и Кот с наследованием от класса Животное;
//имплементирую метод специфичный для собак - плавать
public class Dog extends Animal{
    //конструктор с параметрами:
    public Dog(String _name){
       super("Пёс "  + _name);
        this.maxRun = 500;
        this.maxJump = 0.5;
        this.maxSwim = 10;
    }

    //специфичный метод перезаписанный из абстрактного метода и класса Animal:
    @Override
    protected String voice() {
        return "Gaaafff";
    }



}
