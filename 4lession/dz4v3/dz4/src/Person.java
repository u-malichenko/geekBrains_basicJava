public class Person {
//1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

//2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Person(String _fio, String _position, String _email, String _phone, int _salary, int _age){
        this.fio = _fio;
        this.position = _position;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;
    }

//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void getPersonInfo(){
        System.out.println("Фамилия Имя Отчество: " + this.fio + " Должность: " + this.position + " Электронная почта: " + this.email + " Номер телефона: " + this.phone + " Зарплата: " + this.salary + " Возраст: " + this.age);
    }
    public String toString(){
        return ("Фамилия Имя Отчество: " + this.fio + " Должность: " + this.position + " Электронная почта: " + this.email + " Номер телефона: " + this.phone + " Зарплата: " + this.salary + " Возраст: " + this.age);
    }

    public int getPersonAge(){
        return this.age;
    }

}
