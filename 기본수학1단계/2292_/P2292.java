import java.util.Scanner;

public class P2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int count = 1;
        int range = 2;
        if (N == 1) {
            System.out.print(1);
        } else {
            while (range <= N) {
                //System.out.println("range:" +range);
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
        
    }
}
/*
https://www.acmicpc.net/problem/2292

1 1 1
2~7 6 2
8~19 12 3
20~37 18 4

range = 2 + (6 * 1) = 8
range = 8 + (6 * 2) = 20

*/