import java.util.Arrays;
import java.util.Scanner;

public class P2667 {

    static int[][] map = new int[25][25]; // 집의 존재 입력할 2차원 배열
    static boolean[][] visit = new boolean[25][25]; // 탐색할 집의 방문 여부 체크
    private static int[] dx = { 0, -1, 0, 1 }; // dx, dy = 상하좌우
    private static int[] dy = { -1, 0, 1, 0 };
    static int count = 1; // 방문한 단지 번호(연결된 단지가 아닐경우 1씩 증가)
    static int N; // 지도의 크기

    // <- , ↑ , -> , ↓ ... 동서남북 4방향 체크해가며 dfs 돌리기
    public static void dfs(int x, int y) {
        map[x][y] = count; // 방문한 집 => count로 표시(1, 2, 3, ... 하나씩 증가)
        visit[x][y] = true; // 방문한 집 => true 체크
        for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우 체크
            // 좌(0,-1) 상(-1, 0), 우(0, 1), 하(1, 0)
            int nx = x + dx[i];
            int ny = y + dy[i];

            // nx, ny = 좌표의 범위, N*N 크기이므로 x, y좌표가 0보단 커야하고 N보단 작아야함.
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && visit[nx][ny] == false) {
                    dfs(nx, ny); // 1이면서 방문하지 않은곳 => dfs 돌리기
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // 지도의 크기
        for (int i = 0; i < N; i++) { // 2차원 행렬 입력받기
            String str = scan.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visit[i][j] == false) {
                    dfs(i, j); // 1이면서 방문하지 않은곳 => dfs 돌리고 단지수 카운트
                    count++; // dfs 재귀 함수가 끝날때 => 탐색(인접)이 끝났으므로, 다음 인접된 집의 단지 번호를 +1 해줘야 함.
                }
            }
        }

        System.out.println(count - 1); // 단지수 출력
        int[] arr = new int[count]; // 단지수 만큼 집의 수 설정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) { // 집이 있는 곳인 경우
                    arr[map[i][j]]++; // 집이 있는 map[i][j]의 경우 count로 저장되었으므로, 단지 번호가 저장된다.
                }
            }
        }

        Arrays.sort(arr);
        for (int i = 1; i < count; i++)
            System.out.println(arr[i]); // 각 단지번호 별로 단지수 출력
        scan.close();
    }
}

/*

https://www.acmicpc.net/problem/2667

참고 : https://zzang9ha.tistory.com/58
상하좌우 설명이 이해가 갈것이다.

*/