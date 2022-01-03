import java.util.Scanner;

public class P14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();

        if (A > 0 && B > 0) {
            System.out.println("1");
        } else if (A > 0 && B < 0) {
            System.out.println("4");
        } else if (A < 0 && B > 0) {
            System.out.println("2");
        } else if (A < 0 && B < 0) {
            System.out.println("3");
        }
    }
}

/*
https://www.acmicpc.net/problem/14681

*/