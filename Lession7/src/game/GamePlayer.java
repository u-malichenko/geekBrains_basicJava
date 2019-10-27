package game;

public class GamePlayer {

    //символ которым играет игрок
    private char playerSign;

    //признак рельный игрок или пк
    private boolean realPlayer = true;

    //конструктор
    public GamePlayer(boolean isRealPlayer, char playerSign){
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    //создаем геттеры для того чтоб иметь доступ к приватным полям из вне (из кода прогр)
    public boolean isRealPlayer(){
        return realPlayer;
    }

    public char getPlayerSign(){
        return playerSign;
    }
}
