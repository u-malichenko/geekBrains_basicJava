package galia.lessons_4;

public class Employee {
    //1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
    //2. Конструктор класса должен заполнять эти поля при создании объекта;
    //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfoEmployee(){
        System.out.println("Сотрудник " + fullName + " на должности " + position
                + " с контактными данными - телефон: " + phone + "  и почта " + email
                + ", сумма зарплаты: " + salary + ", возраст " + age + ".");
    }

    public int getAge() {
        return age;
    }
}
