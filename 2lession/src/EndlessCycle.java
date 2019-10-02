public class EndlessCycle {
    public static void main(String[] args) {
        int i = 0;
        for (;;) {
            if(i>3){
                break;
            }
            System.out.println(i++);
        }
    }
}
