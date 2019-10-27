package game;

public class Game {
    //ссылка на игровое поле
    private GameBoard board;

    //массив игроков
    private GamePlayer[] gamePlayers = new GamePlayer[2];

    //индекс текущего игрока
    private int playersTurn = 0;

    public Game(){
        //передаем текуший экземпляр игры
        this.board = new GameBoard(this);
    }

    public void instGame(){
        gamePlayers[0] = new GamePlayer(true,'X');
        gamePlayers[0] = new GamePlayer(false,'O');
    }


}
