public class DivisionByZero {
    public static void main(String[] args) {
        int a=5, b=10, c=0;
        if( b!=0){
            System.out.println("b не равно 0");
            c=b/a;
            System.out.println("b / a равно "+c);
        }
    }

}
