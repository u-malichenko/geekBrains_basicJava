public class Cat extends Beast {
    protected String color;

    public Cat (String name, int pawsNumber, String color){
        this.name = name;
        this.pawsNumber = pawsNumber;
        this.color = color;
    }

    public void catInfo(){
        System.out.println("Cat: " + name + " Color " + color);
    }





//    String name;
//    String color;
//    int age;
//    public Cat (String _name, String _color, int _age){
//        name = _name;
//        color = _color;
//        age = _age;
//    }
//    public Cat (String _name){
//        name = _name;
//        color = "Unknown";
//        age = 1;
//    }
//    public Cat (){
//        name = "Unknown";
//        color = "Unknown";
//        age = 1;
//    }
//
//
//    public String getCatName(){
//        return this.name;
//    }
}
