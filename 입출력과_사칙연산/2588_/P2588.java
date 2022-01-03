import java.util.Scanner;

public class P2588 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();

        System.out.println(A*(B%10));
		System.out.println(A*(B%100/10));
		System.out.println(A*(B/100));
		System.out.println(A*B);
    }
}

/*

https://www.acmicpc.net/problem/2588

예제 입력 1 
472
385
예제 출력 1 
2360
3776
1416
181720

 */