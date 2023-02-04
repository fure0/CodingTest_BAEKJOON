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

/*
https://www.acmicpc.net/problem/1012

입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 
두 배추의 위치가 같은 경우는 없다.

출력
각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

예제 입력 1 
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

예제 출력 1 
5
1

예제 입력 2 
1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0

예제 출력 2 
2

*/