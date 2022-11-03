import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

    static int m;
    static int n;
    static int[][] tomatoes;
    static int maxVal;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 문제에서 가로부터 입력됨 주의
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        tomatoes = new int[n][m];
        for (int i = 0; i < n; i++) { // 4
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) { // 6
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        // 토마토밭을 돌다가 1이면 q에 add
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 1) {
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 범위 밖으로 벗어나면 continue
                if (nextY < 0 || nextX < 0 || nextY > n - 1 || nextX > m - 1)
                    continue;

                // 토마토가 없거나, 익은 토마토라면 continue
                if (tomatoes[nextY][nextX] != 0)
                    continue;

                // 위 조건들을 만족하지 않는다면 다음 칸 갱신 후 큐에 다음 칸 인덱스 추가
                tomatoes[nextY][nextX] = tomatoes[nowY][nowX] + 1;
                q.add(new int[] { nextY, nextX });
            }
        }

        // check가 끝난 토마토밭을 돌면서 0이 있는지, 없다면 maxVal은 몇인지 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                maxVal = Math.max(maxVal, tomatoes[i][j]);
            }
        }
        System.out.println(maxVal - 1);
    }

}

/*

https://www.acmicpc.net/problem/7576

https://wiselog.tistory.com/164

*/
