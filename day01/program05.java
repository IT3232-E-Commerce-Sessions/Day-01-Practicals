
import java.util.Scanner;

public class program05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int mid = n / 2;
        int[] arr = new int[n];
        arr[mid] = mid + 1;

        for (int i = 0; i < mid; i++) {
            arr[mid - 1 - i] = i + 1;
            arr[n - 1 - i] = mid + 2 + i;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
