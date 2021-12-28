import java.util.Scanner;

public class P1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, num;
        int cnt = 0;
        n = sc.nextInt();
        num = n;
        while(true) {
            num = num%10*10+(num/10+num%10)%10;
            cnt++;
            if (n==num) break;
        }
        System.out.println(cnt);
        sc.close();
    }
}

/*
문제에서처럼 n=26을 예로 들어 설명해 보자면
cnt=0 (cnt: 사이클 길이)
n = 26
num = 26
<반복문>
2+6=8 (2는 num/10, 6은 num%10 이고 8은 둘의 합이므로 num/10+num%10) 이다
num=68 (10의 자리수이므로 6에 10을 곱해준다 따라서 num%10*10 이고, 8의 경우는 위에서 구한 합의 일의 자리이므로 (num/10+num%10)%10 이다 )
cnt++ (cnt는 1)
num이 n과 같아질 때까지 반복한다

출처
https://bskwak.tistory.com/101
*/
