public class program03 {
    public static void main(String args[]) {
        int num = 1234;
        int reverse = 0;
        int temp;

        while (num > 0) {
            temp = num % 10;
            reverse = reverse * 10 + temp;
            num = num / 10;

        }
        System.out.println("Reverse of the number is: " + reverse);

    }
}
