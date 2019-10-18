package malichenko.basicJavaProjeect.lession4;

public abstract class Animal{
//5. Создать классы Собака и Кот с наследованием от класса Животное;
    protected String name;
    protected double maxRun = 0;
    protected double maxJump = 0;
    protected double maxSwim = 0;

    //доп переменная для 1 задания 5 темы
    protected double appetite; //объем необходимый для пееревода кота в состояние сыт
    protected boolean fullness; // состояние сытости (когда создаем котов, они голодны)


    public Animal(){
        this.name = "Животные";
    }

    public Animal(String _name){
        this.name = _name;
    }

//6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);

    protected abstract String voice(); //добавил поиграль метод издавать звуки

    //задаем ограничения для конкретного обекта класса
    public void setMaxRun(double _maxDistance) {
        if(_maxDistance > 0)
            this.maxRun =_maxDistance;
        else{
            System.out.println("Дистанция не может быть отрицательна или = 0. Установлена максимальная дистанция по умолчанию = 1");
            this.maxRun = 1;
        }
    }
    public void setMaxJump(double _maxHeight) {
        if(_maxHeight > 0)
            this.maxJump =_maxHeight;
        else{
            System.out.println("Высота прыжка не может быть отрицательна или = 0. Установлена максимальная высота по усомчанию = 1");
            this.maxJump = 1;
        }
    }
    public void setMaxSwim(double _maxDistance) {
        if(_maxDistance > 0)
            this.maxSwim =_maxDistance;
        else{
            System.out.println("Дистанция не может быть отрицательна или = 0. Установлена максимальная дистанция по умолчанию = 1");
            this.maxSwim = 1;
        }
    }


    //описываю общие для всех подклассов методы
    public void run(double _distance) {
        if(maxRun > 0 && _distance <= this.maxRun)
            System.out.println(this.name + " пробежал " + _distance + " метров");
        else{
            System.out.println(this.name + " не сможет пробежать столько!");
        }
    }

    public void jump(double _height) {
        if(maxJump > 0 && _height <= this.maxJump)
            System.out.println(this.name + " прыгнул " + _height + " метров");
        else{
            System.out.println(this.name + " не сможет прыгнуть столько!");
        }
    }

    public void swim(double _distance) {
        if(maxSwim > 0 && _distance <= this.maxSwim)
            System.out.println(this.name + " пролыл " + _distance + " метров");
        else{
            System.out.println(this.name + " не сможет проплыть столько!");
        }
    }
}

//8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);

//9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.



