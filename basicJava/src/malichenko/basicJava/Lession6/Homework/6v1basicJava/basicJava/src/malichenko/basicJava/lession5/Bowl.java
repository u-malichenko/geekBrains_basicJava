package malichenko.basicJava.lession5;

//2. Кот должен есть из миски.Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;
public class Bowl {
    protected String bowlName;
    protected double size;
    private double eat;


    //конструктор миски
    public Bowl(String _bowlName, double _size, double _eat){
        this.bowlName = _bowlName;
        this.size = _size;
        //если корма больше чем объем миски то излишки просыплются мимо миски.
        if (_eat <= _size) {
            this.eat = _eat;
        } else {
            System.out.println();
            System.out.println("В миску бахнули корма: " + _eat + " единиц, больше чем она могла вместить: " + this.size+ ", излишки просыпались мимо миски и их украли дикие голодные кошки)");
            System.out.println();
            this.eat = this.size;
        }
    }

    //метод наполения конкретной миски. если передется значение с минусом то значит кот есть и миска убывает
    public void setFilling(double _eat){
        this.eat += _eat;
        //если корма больше чем объем миски то излишки просыплются мимо миски и их украдут дикие голодные кошки).
        if (this.eat > this.size) {
            System.out.println();
            System.out.println("В миску бахнули корма: " + _eat + " единиц, больше чем она могла вместить: " + this.size+ ", излишки просыпались мимо миски и их украли дикие голодные кошки)");
            System.out.println();
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

    //метод для красивой печати остатка еды в миске
    public String infoBlow(){
        return (". В миске осталось " + this.getAmountEat() + " единиц еды");
    }

}
