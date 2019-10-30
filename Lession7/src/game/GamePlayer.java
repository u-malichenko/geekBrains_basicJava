package game;

public class GamePlayer {

    //символ которым играет игрок
    private char playerSign;
    //признак рельный игрок или пк
    private boolean realPlayer = true;

    /**
     * Конструктор игрока
     * @param isRealPlayer - признак игрок или компьютер
     * @param playerSign - символ которым играет игрок
     */
    public GamePlayer(boolean isRealPlayer, char playerSign) {
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    /**
     * создаем геттеры для того чтоб иметь доступ к приватным полям из вне (из кода прогр)
     * получение признака игрока, true = реальный игрок, false = компьютер
     * @return boolean - признак текущего игрока
     */
    public boolean isRealPlayer() {
        return realPlayer;
    }

    /**
     * получение сивола текущего игрока
     * @return -char крестик или нолик
     */
    public char getPlayerSign() {
        return playerSign;
    }
}
