package malichenko.basicJava.Lession6.Homework;

public class _2MainClassCalc {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
        _2CalculatorFrame app = new _2CalculatorFrame();
                app.setVisible(true);
            }
        });
    }
}
