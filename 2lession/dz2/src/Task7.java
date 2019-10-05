public class Task7 {
    public static void main(String[] args) {
        int [] in = {5,3,7,2,9,13,42};

        //индекс = (номер_шага * сдиг) % длина_массива;

        //индекс = длина_массива + ((Номер_шага * сдвиг) % длина_массива;

        int [] out3 = moves(in, 4);
        Util.printArr(out3, " ");
    }

    public static int[] moves(int[] incoming, int delta){
        //ни чего не надо делать если сдвиг =0
        if(delta != 0){
            // упрощение сдвига в случае если сдвиг больше длинны массива
            if(Math.abs(delta) > incoming.length){ // модуль сдвига сравниваем с длинной массива если он больше то упрощаем сдвиг уменьшаем на длинну массива
                delta = delta % incoming.length; //сдвиг будет равен остатку от деления большого сдвига от длинны массива
            }
            int buffer = incoming[getItemIndexByStepNumber(incoming.length, delta, 0)]; //в буфер кладем 0 элемент при помощи метода
            //в цикле начинаем переставлять элементы согласно формулам
            for (int i = 0; i < incoming.length+1; i++) { // +1 = <= нужна вся длинна для 0го хода
                int currentElementIndex = getItemIndexByStepNumber(incoming.length, delta, i);
                int currentElement = incoming[currentElementIndex];
                incoming[currentElementIndex] = buffer;
                buffer = currentElement;
            }
        }
        return incoming;
    }
// для рассчета индекса массива следующего шага в зависимости от шага
    public static int getItemIndexByStepNumber(int incomingLength, int delta, int step){
        int itemIndex;
        //движение вправо
        if(delta > 0) {
            if(step == 0)
                itemIndex =0; //если шаг нулевой иключение считаем не по формуле
            else
                itemIndex = (step * delta) % incomingLength;
        }
        //движение влево
        else {
            if(step == 0)
                itemIndex =0;
            else
                itemIndex = incomingLength + ((step * delta) % incomingLength);
        }
        //reverse in case of array out of bounds
        if(itemIndex == incomingLength) itemIndex = 0; //вычисляем последний шаг он равен длинне массива 7
        return itemIndex;
    }
}
