public class MainClass {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal"); //создали переменну анимал куда положили экземпляр класа Энимал
        Cat cat = new Cat("Barsik", 4, "White");//создали переменную кэт куда положили экземпляр класа Кэт
        Duck duck = new Duck("Donald");//создали переменную  дак куда положили экземпляр класа Дак

        animal.animalInfo(); //метод энималинфо мы можем вызвать и у анимал и у кэт
        cat.animalInfo(); // так как он определен в суперклассе от которого у нас наследуется класс кэт

        cat.catInfo();

        duck.fly(); //определен в классе Бёрдс
        duck.swim(); //определен в классе ДАК
        duck.animalInfo();
    }
}
