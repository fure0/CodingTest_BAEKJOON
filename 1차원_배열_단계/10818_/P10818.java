import java.util.Scanner;

public class P10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int minimum = 1000001;
        int maximum = -1000001;

        for (int i = 0; i < N; i++) {
            int val = arr[i];
            if (val > maximum) {
                maximum = val;
            }
            if (val < minimum) {
                minimum = val;
            }
        }
        System.out.println(minimum + " " + maximum);
    }
}
