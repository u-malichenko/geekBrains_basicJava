package galia.lessons_4;

public class Dog extends Animal {

    //9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
    public Dog(double valueRun, double valueSwim, double valueJump) {
        super(valueRun, valueSwim, valueJump);

    }

    //7. У каждого животного есть ограничения на действия
    // (бег: кот – 200 м., собака – 500 м.;  плавание: кот не умеет плавать, собака – 10 м.); прыжок: кот – 2 м., собака – 0.5 м.;
    public Dog(){
        super(500.0, 10.0, 0.5);


    }
}
