class News extends Publication {

    //метод конструктор с заданием зоговорвка
    public News(String title){
        this.title = title;
    }

    //переопределение метода рендор
    @Override
    public void render() {
        System.out.println("Вывод на экран новости");
    }
}
