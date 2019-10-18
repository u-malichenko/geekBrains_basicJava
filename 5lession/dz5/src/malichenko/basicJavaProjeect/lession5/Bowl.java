package malichenko.basicJavaProjeect.lession5;

//2. Кот должен есть из миски.Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;
public class Bowl {
    protected String bowlName;
    private double size;
    private double eat;


    //конструктор миски
    public Bowl(String _bowlName, double _size, double _eat){
        this.bowlName = _bowlName;
        this.size = _size;
        //если корма больше чем объем миски то излишки просыплются мимо миски.
        if (_eat <= _size) {
            this.eat = _eat;
        } else {
            this.eat = _size;
        }
    }

    //метод наполения конкретной миски. если передется значение с минусом то значит кот есть и миска убывает
    public void setFilling(double _eat){
        this.eat += _eat;
        //если корма больше чем объем миски то излишки просыплются мимо миски и их украдут дикие кошки).
        if (this.eat > this.size) {
            this.eat = this.size;
        }
    }

    // узнать сколько еды в миске осталось
   public double getAmountEat(){
        return this.eat;
    }

    //узнать номер миски*на будущее для новых мисок
    public String getBowlName(){
        return this.bowlName;
    }

}
