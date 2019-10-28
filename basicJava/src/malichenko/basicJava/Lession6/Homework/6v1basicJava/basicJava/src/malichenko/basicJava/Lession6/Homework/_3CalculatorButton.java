package malichenko.basicJava.Lession6.Homework;

import javax.swing.*;
import java.util.Arrays;

public class _3CalculatorButton extends JButton {
    private String operation;
    private static String [] availableOperations = {"+","-","/","*","^"};

    public _3CalculatorButton(String userOperation){
        super(userOperation);
        if(Arrays.asList(availableOperations).contains(userOperation)){
            operation = userOperation;
        }
        else{
            System.out.println("Попытка создать кнопку для несуществующей операции");
        }
    }

    public String getOperation(){
        return operation;
    }

}
