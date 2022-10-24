import java.util.Scanner;

public class P7568 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i ++) {
            arr[i][0] = sc.nextInt(); // [i][0] : 몸무게
            arr[i][1] = sc.nextInt(); // [i][1] : 키
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 같은 사람은 비교 안해도 된다
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) { //i 번째 사람과 j 번째 사람을 비교하여 i 가 j 보다 덩치가 작을 경우 rank 값을 1 증가시킨다
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
        
    }
}

/*
https://www.acmicpc.net/problem/7568

예제 입력 1
5
55 185
58 183
88 186
60 175
46 155

예제 출력 1
2 2 1 2 5
*/
