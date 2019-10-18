package malichenko.basicJavaProjeect.lession4;

public class MainClass {
    public static void main(String[] args) {
//4. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        // Вначале объявляем массив объектов
        Person[] persArray = new Person[5];

        // потом для каждой ячейки массива задаем объект
        persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivIvan@mailbox.com ", "892312312", 30000,30);
        persArray[1] = new Person("Petrov Petr", "Cleaner", " PPetrov@mailbox.com ", "892312313", 60000,42);
        persArray[2] = new Person("Sidorov Oleg", "Builder", " OSidorov@mailbox.com ", "892312314", 32000,35);
        persArray[3] = new Person("Sokolov Ivan", "Manager", " ivSokolov@mailbox.com ", "892312315", 62000,45);
        persArray[4] = new Person("Tarkovsky Ivan", "Seller", " ivTarkovsky@mailbox.com ", "892312316", 30000,40);

        for (Person per : persArray) {
            if(per.getPersonAge() > 40){
                //per.getPersonInfo();
                System.out.println(per);
            }
        }
        System.out.println("");

        Animal[] arrayOfAnimals = new Animal[3];

        arrayOfAnimals[0] = new Cat("Barsik");
        arrayOfAnimals[1] = new Dog("Sharik");
        arrayOfAnimals[2] = new SuperCat("Васька!", 350,3);

        for(Animal animal : arrayOfAnimals){
            animal.run(150);
            animal.jump(2.5);
            animal.swim(5);
        }



    }
}
