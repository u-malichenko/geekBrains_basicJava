class Announcment extends Publication {


    //конструктор
    public Announcment(String title){
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
        //укорачивание текста для анонса

        return this.title;
    }
}
