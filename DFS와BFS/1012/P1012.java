import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {

  static int M, N, K;
  static int[][] cabbage;
  static boolean[][] visit;
  static int count;
  static int[] dy = { 1, 0, -1, 0 };
  static int[] dx = { 0, -1, 0, 1 };

  static void dfs(int y, int x) {
    visit[y][x] = true;

    for (int i = 0; i < 4; i++) { //상하좌우 체크
      int cy = y + dy[i];
      int cx = x + dx[i];

      if (cy >= 0 && cx >= 0 && cy < N && cx < M) {
        if (!visit[cy][cx] && cabbage[cy][cx] == 1) {
          dfs(cy, cx);
        }
      }
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    for (int i = 0; i < tc; i++) {
      count = 0;
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      M = Integer.parseInt(st.nextToken()); //가로 길이
      N = Integer.parseInt(st.nextToken()); //세로 길이
      cabbage = new int[N][M];
      visit = new boolean[N][M];

      K = Integer.parseInt(st.nextToken()); //심어진 배추 개수
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        cabbage[cy][cx] = 1; // 배추가 심어져 있는 곳은 1
      }

      for (int y = 0; y < N; y++) {
        for (int x = 0; x < M; x++) {  
          if (cabbage[y][x] == 1 && !visit[y][x]) {
            dfs(y, x);
            count++;
          }
        }
      }

      System.out.println(count);
    }
  }
}