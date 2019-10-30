package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {

    //размерность
    static int dimension = 3;
    //размер одной клетки
    static int cellSize = 150;
    //матрица игры(строка столбец)
    private char[][] gameField;
    //массив кнопок
    private GameButton[] gameButtons;
    //ссылка на игру
    private Game game;
    //пустой символ
    private static char nullSymbol = '\u0000';

    /**
     * конструктор
     * @param currentGame - текущая игра
     */
    public GameBoard(Game currentGame) {
        this.game = currentGame;
        initField(); //метод инициализации поля описан ниже
    }

    /**
     * геттер размерности массива, нужен для работы сложного пк в GameActionListener
     * @return - int - размерность игры
     */
    public int getDimension(){
        return dimension;
    }

    /**
     * метод получения знака в кнопке
     * @param x строка массива
     * @param y столбец массива
     * @return char - символ в строке
     */
    public char getGameField(int x, int y){
        return gameField[x][y];
    }

    /**
     * Метод инициации и отрисовки игрового поля
     */
    private void initField() {
        //размеры гибкие для того чтоб можно было задавать различный размер всего окна
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //добавим панель управления игрой-кнопка новая игра:
        JPanel controlPanel = new JPanel(); //создали панель управления игрой
        JButton newGameButton = new JButton("Новая игра"); //кнопка панели управления - НОвая игра с отдельным листнером

        JButton setSillyModeButton = new JButton("sillyMode Off"); //кнопка панели управления - вкл слабый пк

        JButton setScoringModeButton = new JButton("scoringMode Off"); //кнопка панели управления - выключение ближайших значений

        //для scoringMode кнопки отдельный лисенер:
        setScoringModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //запускаем
                game.setScoringMode();
            }
        });

        //для sillyMode кнопки отдельный лисенер:
        setSillyModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //запускаем
                game.setSillyMode();
            }
        });

        //для этой кнопки отдельный лисенер:
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //запускаем метод отчистки поля и матрицы игры
                //отчиститьть все кнопки
                emptyField();
            }
        });

        //устанавливаем стандартные настройки нашей панельки:
        controlPanel.setLayout((new BoxLayout(controlPanel, BoxLayout.X_AXIS))); //задаем расположение менеджер размещения
        controlPanel.add(newGameButton); //добавляем ранее созданную кнопку на панель
        controlPanel.add(setSillyModeButton); //добавляем ранее созданную кнопку на панель
        controlPanel.add(setScoringModeButton); //добавляем ранее созданную кнопку на панель
        controlPanel.setSize(cellSize * dimension, 150); //устанавливаем размерность панели

        //следующая панель это панель самой мгры с кнопками хода
        //новая панелька, добавляем ссылку создаем
        JPanel gameFieldPanel = new JPanel(); //панель самой игры

        //панель будет иметь табличное размещение Гридлеаут
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension)); //размерность таблицы равна размерности матрицы кнопок ходов

        //задаем размер таблицы в зависимости от размера поля и колличества кнопок
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        //инициализируем двумерный массив - матрицу нашей игры
        gameField = new char[dimension][dimension];

        //инициируем массив кнопок игры он одномерный так как мы тупо считаем общее колличество кнопок а все вычисления идут по формулам. так проше и легче счем использовать двумерный массив
        gameButtons = new GameButton[dimension * dimension];

        //нам нужно заполнить игровое поле кнопками(инициализировать его):
        //обходим циклом один раз весь одномерный массив всех кнопок:
        for (int i = 0; i < (dimension * dimension); i++) {
            //создаем новые экземпляры класса GameButton указываем ее индекс и передаем ее текущее поле в ее конструктор
            GameButton fieldButton = new GameButton(i, this); //создаем кномпку
            gameFieldPanel.add(fieldButton); //добавляем кнопку на игровое поле
            gameButtons[i] = fieldButton; //и в массив gameButtons кнопок добавляем полученную ссылку на кнопку
        }

        //две полученые панели нужно добавить на основное окно
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * метод очистки поля и матрицы игры
     */
    void emptyField() {
        //в цикле пробегает весь масив gameButtons
        for (int i = 0; i < (dimension * dimension); i++) {

            //будет обнулять значения внутри наших кнопок:
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol; //нельзя строчке присвоить пустое поле будет возникать ошибка? посему зададим его в переменных
        }
    }

    /**
     * метод получения ссылки на игру, нужен для использования например для получения доступа к свойствам полей пользователя, для вычисления кто ходит.
     * @return - возвращает ссылку на экземпляр нашей игры
     */
    Game getGame() {
        return game;
    }

    /**
     * Метод проверки доступности клетки дял хода
     * @param x - по горизонтали
     * @param y - по вертикали
     * @return boolean
     */
    //метод проверка поля что туда можно пойти получает координаты проверяемой кнопки
    boolean isTurnable(int x, int y) {
        boolean result = false;

        //если поле по данным координатам содержит кнопку с пустым символом, то  тогда можно ходить
        if (gameField[x][y] == nullSymbol)//замил путанные значения у х местами, соответственно смели и в Экшенлисенер
            result = true;
        return result;
    }

    /**
     * Обновление матрицы игры после хода
     * @param x - по горизонтали
     * @param y - по вертикали
     */
    //приняли две координаты
    void updateGameField(int x, int y) {
        //должны поставить в нашу клеточкуу символ игрока
        //для того тчоб получить этот символ у нас есть ссылка на объект игры game
        //у ее мы можем узнать кто же сейчас текущий игрок, но только текущего игрока не хватит
        //мы должны поставить туда его символ а не его самого, по этому
        //у полученного объекта игрока getCurrentPlayer мы получаем символ через getPlayerSign
        //и проставляем его символ в указанную клеточку gameField[y][x]
        gameField[x][y] = game.getCurrentPlayer().getPlayerSign();
    }

    /**
     * Провека победы по линиям и столбцам
     * @return - флаг победы
     */
    boolean checkWin() {
        boolean result = false;
        //символ нашего игрока мы получаем через
        //геттер нашей игры--
        //геттер текущего игрока--
        //геттер символа текущего игрока
        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        //проверяем по диагоналям и линиям как и в прошлом процедурном стиле
        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }
        return result;
    }

    /**
     * метод проверки заполнености поля
     * @return boolean
     */
    boolean isFull() {
        boolean result = true;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (gameField[i][j] == nullSymbol) {
                    result = false;
                    //сокращаем поиски если нашли пустую клетку,
                    // не проверяем весь массив - выходим из внутреннего цикла
                    break;
                }
            }
            //выходим из внешнего цикла, если первая пустая клетка найдена
            if (!result) {
                break;
            }
        }
        return result;
    }

    /**
     * метод получения сылки на кнопку по индексу из массива GameButton
     * @param buttonIndex -на вход получает номер кнопочки
     * @return -и возвращает ссылку на ее из мкассива кнопок gameButtons
     */
    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }


    /**
     * Проверка  победы по столбцам и линиям
     * @param playerSymbol - символ игрока
     * @return флаг победы
     */
    private boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;

        for (int col = 0; col < dimension; col++) { // строки
            cols = true;  // строки
            rows = true; // столбцы

            for (int row = 0; row < dimension; row++) {  // столбцы
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol); //обратно
            }

//это условие после каждой проверки колонки и стобца
//позволяет остановить дальнейшее выполнение, без проверки
//всех остальных строк и столбцов.
            if (cols || rows) {
                result = true;
                break;
            }

            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Проверка  победы по диагоналям
     * @param playerSymbol - символ игрока
     * @return флаг победы
     */
    private boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight, rightLeft, result;
        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < dimension; i++) {

            leftRight &= (gameField[i][i] == playerSymbol);
            rightLeft &= (gameField[dimension - i - 1][i] == playerSymbol);
        }
        if (leftRight || rightLeft) {
            result = true;
        }
        return result;
    }

}
