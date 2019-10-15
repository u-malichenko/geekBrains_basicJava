public class Beast extends Animal {
    protected  int pawsNumber;

    public Beast(){
        this.name = "united";
        this.pawsNumber = 4;
    }

    public Beast(String name, int pawsNumber){
        this.name = name;
        this.pawsNumber = pawsNumber;
    }

    public void beastInfo(){
                System.out.println("Beast:" + name + " with " + pawsNumber + " paws");
    }
}
