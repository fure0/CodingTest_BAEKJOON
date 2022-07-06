import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P15649 {

    public static boolean[] visit;
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //4
        M = Integer.parseInt(st.nextToken()); //2

        visit = new boolean[N]; //4
        arr = new int[M]; //2
        dfs(0);
        System.out.println(sb);

    }

    public static void dfs(int depth) {

        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        // ** DFS인것을 감안하자. 깊이 탐색이다. 결과의 첫째는 depth(세로) 값이다. N이 가로 값이다.
        for (int i = 0; i < N; i++) { // 0 < 4
            // 만약 해당 노드(값)을 방문하지 않았다면?
            if (!visit[i]) { // 중복값은 담지 않기 위해
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }
}


/*
https://www.acmicpc.net/problem/15649

https://st-lab.tistory.com/114


문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
예제 출력 1 
1
2
3
예제 입력 2 
4 2
예제 출력 2 
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3

 */