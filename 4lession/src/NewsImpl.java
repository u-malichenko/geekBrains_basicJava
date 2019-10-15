class Newsimpl implements Renderable{
    String title;


    //метод конструктор с заданием зоговорвка
    public Newsimpl(String title){
        this.title = title;
    }

    //переопределение метода рендор
    @Override
    public void render() {
        System.out.println(this.title);
        System.out.println("Вывод на экран новости");
    }
}
