class AnnouncmentImpl implements Renderable {

    String title;

    //конструктор
    public AnnouncmentImpl(String title){
        this.title = title;
    }

    //переопределенный метод редор содержит дополнительный метод укорачивания текста для анонса
    @Override
    public void render() {
        cutText();
        System.out.println("вывод на экран анонса");
    }

    //доп метод
    private String cutText(){
        System.out.println(this.title);
        //укорачивание текста для анонса
        return this.title;
    }
}
