class Audi implements CarTemplate {
    protected String name = "Audi";

    @Override
    public int getId() {
        return 198;
    }

    @Override
    public String getName() {
        return "Audi";
    }

    @Override
    public void move() {
        System.out.println(this.name + " is moving");
    }
}
