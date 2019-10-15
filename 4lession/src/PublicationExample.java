public class PublicationExample {
    public static void main(String[] args) {
        //создаем массив публикаций
        Renderable[] publications = new Renderable[3];

        publications[0] = new Newsimpl("Новость");
        publications[1] = new AnnouncmentImpl("Анонс");
        publications[2] = new Newsimpl("Привет Юра!");


        //работаем с ними как с обобщенным классом публикаций Publication
        for(Renderable pub : publications){
            //и вызываем рендор вне зависимости от конкретного типа
            pub.render();
        }
    }
}
