import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //컴퓨터 개수
        int m = Integer.parseInt(br.readLine()); //연결된 개수

        int[][] arr = new int[n + 1][n + 1]; // n+1해주는 이유는 컴퓨터가 1부터 시작하기 때문에, 입력값에 맞추기 위해.
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>(); //bfs를 사용할 예정
        boolean[] visit = new boolean[n + 1]; //컴퓨터를 확인했는가

        q.add(1); // 1번부터 시작이니 큐에 1을 넣어준다.
        visit[1] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 1; i < visit.length; i++) {
                if (arr[v][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}

// https://www.acmicpc.net/problem/2606
// https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-2606%EB%B2%88-%EB%B0%94%EC%9D%B4%EB%9F%AC%EC%8A%A4-Java-%EC%9E%90%EB%B0%94


/*

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 
컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

예제 입력 1 
7
6
1 2
2 3
1 5
5 2
5 6
4 7
예제 출력 1 
4

*/