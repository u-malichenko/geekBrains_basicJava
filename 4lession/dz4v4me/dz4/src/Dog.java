//5. Создать классы Собака и Кот с наследованием от класса Животное;
//имплементирую метод специфичный для собак - плавать
public class Dog extends Animal implements Swim{

    //конструктор без параметров:
    public Dog(){
        this.maxRun = 500;
        this.maxJump = 0.5;
        this.maxSwim = 10;
    }

    //конструктор с параметрами:
    public Dog(String _name, double _run, double _jump, double _swim){
       super("Пёс "  + _name);
        this.maxRun = _run;
        this.maxJump = _jump;
        this.maxSwim = _swim;
    }

    //специфичный метод перезаписанный из абстрактного метода и класса Animal:
    @Override
    protected String voice() {
        return "Gaaafff";
    }

    //методы из специфичного инетфейса Swim:
    @Override
    public void setMaxSwim(double _maxDistance) {
        if(_maxDistance > 0)
            this.maxSwim =_maxDistance;
        else{
            System.out.println("Дистанция не может быть отрицательна или = 0. Установлена максимальная дистанция по умолчанию = 1");
            this.maxSwim = 1;
        }
    }

    @Override
    public boolean swimming(double _distance) {
        if(_distance <= this.maxSwim)
            return true;
        else
            return false;
    }
}
