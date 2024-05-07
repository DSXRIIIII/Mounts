public class B2206Test {
    public static void main(String[] args) {
        System.out.println(calN(20));
    }
    public static long calN(long value) {
        long count = 0;
        while (value != 0) {
            count+=value/5;
            value /= 5;
        }
        return count;
    }
}
