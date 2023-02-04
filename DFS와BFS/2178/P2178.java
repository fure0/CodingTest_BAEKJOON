import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {

    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; // y방향배열-좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]); //목적지의 코스트 출력 (배열 0부터 시작이니까 -1 해준다)
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>(); // 상하좌우 문제를 큐로 푸는 경우니까 int[]를 사용
        q.add(new int[] { x, y });

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
                    continue;
                if (visited[nextY][nextX] || map[nextY][nextX] == 0)
                    continue;

                q.add(new int[] { nextY, nextX });
                map[nextY][nextX] = map[nowY][nowX] + 1; //최종 코스트를 계산하기 위해
                visited[nextY][nextX] = true;
            }
        }
    }

}

/*

https://www.acmicpc.net/problem/2178

https://wiselog.tistory.com/163

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011
예제 출력 1 
15
예제 입력 2 
4 6
110110
110110
111111
111101
예제 출력 2 
9

*/