import java.util.Scanner;

public class P2588 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();

        System.out.println(A*(B%10)); //일의 자리 5의 경우 385 % 10 을 해주면 10으로 나눠준 값의 나머지를 구하니 5가 반환이 될 것이다.
		System.out.println(A*(B%100/10)); //십의자리 8은 385%100 을 해주면 85 가 나오고 이걸 10으로 나누면, 즉 85/10 을 하면 8이 반환 될 것이다.
		System.out.println(A*(B/100)); //백의자리 3은 385/100 을 하면 3이 나온다.
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