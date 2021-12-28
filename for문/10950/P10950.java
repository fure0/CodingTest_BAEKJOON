import java.util.Scanner;

public class P10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] sum = new int[cnt];
        
        for (int i = 0; i < cnt; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            sum[i] = A + B;
        }
        sc.close();
        for (int k : sum) {
            System.out.println(k);
        }
    }
}
