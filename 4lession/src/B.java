public class B extends A {
    int i; //имя прееменной совпадает и скрывает переменную ш в классе А

    B(int a, int b){ //конструктор класса Б
        super.i = a; //обращаемся к переменной i из класса А
        i = b; //обращаемся к переменной i из класса Б
    }

    public void show(){
        System.out.println("i  из суперкласса: " + super.i);
        System.out.println("i в подклассе: " + i);
    }
}
