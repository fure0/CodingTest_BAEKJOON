import java.util.Scanner;

public class P2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int max = -1000001;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            int val = arr[i];
            if (val > max) {
                max = val;
                index = i;
            }
        }
        index = index + 1;
        System.out.println(max);
        System.out.print(index);
    }    
}
