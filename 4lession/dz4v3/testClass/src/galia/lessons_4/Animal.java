package galia.lessons_4;

public class Animal implements Runnable, Swimable, Jumpable{

    private double valueRun;
    private double valueSwim;
    private double valueJump;

    //5. Создать классы Собака и Кот с наследованием от класса Животное;
    //6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    // В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);

    //7. У каждого животного есть ограничения на действия
    // (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);

    //8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
    // (Например, dog1.run(150); -> результат: run: true);

    //9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
    public Animal(double valueRun, double valueSwim, double valueJump) {
        this.valueRun = valueRun;
        this.valueSwim = valueSwim;
        this.valueJump = valueJump;
    }

    @Override
    public void run(double val) {

        System.out.println("run: " + (val > 0 && val <= valueRun));
    }

    @Override
    public void swim(double val) {
        System.out.println("swim: " + (val > 0 && val <= valueSwim));
    }

    @Override
    public void jump(double val) {
        System.out.println("jump: " + (val > 0 && val <= valueJump));
    }
}
