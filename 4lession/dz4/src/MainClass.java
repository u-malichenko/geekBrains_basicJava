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
            if(per.getPersonAge() > 40)
            per.getPersonInfo();
        }


        Animal cat1 = new Cat("Barsik", 200,2); //создали переменную кэт куда положили экземпляр класа Анимал c конкретными ограничениями
        Dog dog1 = new Dog("Sharik",500,0.5,10);//создали переменную  дог куда положили экземпляр класа Дог c конкретными ограничениями, так как класс Свимминг есть только там

        System.out.println("");
        //Дог1 пытается проплыть х метров
        double x=10;
        System.out.println(dog1.name + " - результат заплыва на дистанцию: " + x + " метров, равен - " + (dog1.swimming(x) ? (" true. " + dog1.voice()):"false"));

        //Кэт1 пытается пробежать y метров
        double y=200;
        System.out.println(cat1.name + " - результат забега на дистанцию: " + y + " метров, равен - " + (cat1.running(y) ? (" true. " + cat1.voice()):"false"));

        //Кэт1 пытается првгнуть z метров
        double z=2;
        System.out.println(cat1.name + " - результат прыжка высотой: " + z + " метра, равен - " + (cat1.jumping(z) ? "false":(" true. " + cat1.voice())));

        //животное издает звук если может выполнить действие с заданными параметрами

    }
}
