public abstract class Animal{
//5. Создать классы Собака и Кот с наследованием от класса Животное;
    protected String name;
    protected double run;
    protected double jump;
    protected double swim;

//6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);

    protected abstract String voice(); //добавил поиграль метод издавать звуки

    //задаем ограничения для конкретного обекта класса
    public void setMaxRun(double _maxDistance) {
        if(_maxDistance > 0)
            this.run =_maxDistance;
        else{
            System.out.println("Дистанция не может быть отрицательна или = 0. Установлена максимальная дистанция по умолчанию = 1");
            this.run = 1;
        }
    }

    //задаем ограничения для конкретного обекта класса
    public void setMaxJump(double _maxHeight) {
        if(_maxHeight > 0)
            this.jump =_maxHeight;
        else{
            System.out.println("Высота прыжка не может быть отрицательна или = 0. Установлена максимальная высота по усомчанию = 1");
            this.jump = 1;
        }
    }

    //описываю общие для всех подклассов методы(бегать, прыгать) передаю переменнуюдля проверки условия
    public boolean running(double _distance) {
        return _distance <= this.run;
    }

    public boolean jumping(double _height) {
        return _height <= this.jump;
    }
}

//8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);

//9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.



