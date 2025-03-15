
public class program06 {

    public static void main(String args[]) {
        int arr[] = {20, 43, 54, 21, 54};

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        double average = sum / 5;
        System.out.println(average);
    }
}
