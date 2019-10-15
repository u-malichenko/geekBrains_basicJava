public class HeavyContainer extends Container {
    protected  int weight;

    public HeavyContainer(int w, int h, int d, int m){
        super(w, h, d);
        weight = m;
    }
}
