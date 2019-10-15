//5. Создать классы Собака и Кот с наследованием от класса Животное;
//имплементирую метод специфичный для собак - плавать
public class Dog extends Animal implements Swim{

    //конструктор без параметров:
    public Dog(){
    }

    //конструктор с параметрами:
    public Dog(String _name, double _run, double _jump, double _swim){
        this.name = _name;
        this.run = _run;
        this.jump = _jump;
        this.swim = _swim;
    }

    //специфичный метод перезаписанный из абстрактного метода и класса Animal:
    @Override
    protected String voice() {
        return "Gaaafff";
    }

    //методы из специфичного инетфейса Swim:
    @Override
    public void setMaxSwim(double _maxDistance) {
            this.swim = _maxDistance;
    }

    @Override
    public boolean swimming(double _distance) {
        if(_distance <= this.swim)
            return true;
        else
            return false;
    }
}
