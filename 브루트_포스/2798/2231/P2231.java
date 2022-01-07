import java.util.Scanner;

public class P2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        sc.close();

        for (int i = 0; i < N; i++) {
            int number = i;
            int sum = 0;

            while(number !=0) { // int형 한자리수를 10으로 나누면 몫이 0이된다
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
