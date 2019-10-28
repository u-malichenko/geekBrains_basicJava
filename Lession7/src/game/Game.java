package game;

import javax.swing.*;

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

    /**
     * метод передачи хода
     */
    void passTurn(){
        if (playersTurn == 0)
            playersTurn =1;
        else playersTurn =0;
    }

    /**
     * получение объекта телущего игрока
     * @return GamePlayer объект игрока
     */
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }

    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }
}
