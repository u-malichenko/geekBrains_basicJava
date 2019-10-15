public abstract class Publication {
    protected String title;

    //метод конструктор
    public Publication(){
        this.title = "Заголовок по умолчанию";
    }

    //задание закоговка Сеттер
    public void setTitle(String title){
        this.title = title;
    }

    // получение заголовка Геттер
    public String getTitle(){
        return title;
    }

    //метод формирования вывода публкации в зависимости от ее типа
    // этот метот должен напечатать публикацию, но мы не знаем, как именно это сделать, и поэтому
    abstract public void render();
}
