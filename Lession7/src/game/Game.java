package game;

import javax.swing.*;

public class Game {
    //ссылка на игровое поле
    private GameBoard board;
    //массив игроков
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    //индекс текущего игрока
    private int playersTurn = 0;
    // включить режим слабого пк
    private static boolean sillyMode = false;
    // выключить режим простого подбора по соседним занчениям
    private static boolean scoringMode = true;

    /**
     * конструктор игры
     */
    public Game() {
        //передаем текуший экземпляр игры
        this.board = new GameBoard(this);
    }

    /**
     * инициализация игры,
     * тут мы задаем рельному игроку isRealPlayer - true
     * которое в последствии проверяется при ходе компьютера
     */
    public void initGame() {
        // включить режим слабого пк
        sillyMode = false;

        // выключить! режим простого подбора по соседним занчениям false = on
        scoringMode = false;

        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
    }

    /**
     * метод передачи хода
     */
    void passTurn() {
        if (playersTurn == 0)
            playersTurn = 1;
        else
            playersTurn = 0;
    }

    /**
     * геттер sillyMode статуса слабого ПК
     * @return boolean
     */
    public boolean isSillyMode() {
        return sillyMode;
    }

    /**
     * геттер scoringMode статуса сильного ПК
     * для простого подбора или для подсчета веса ячейки
     * @return boolean
     */
    public boolean isScoringMode() {
        return scoringMode;
    }

    /**
     * получение объекта телущего игрока
     * @return GamePlayer объект игрока
     */
    GamePlayer getCurrentPlayer() {
        return gamePlayers[playersTurn];
    }

    /**
     * метод для вывода диалоговых окно
     * @param messageText - текст сообщения
     */
    void showMessage(String messageText) {
        JOptionPane.showMessageDialog(board, messageText);
    }
}
