import java.util.Arrays;
import java.util.Scanner;

public class P2667 {

    static int[][] map = new int[25][25]; // 집의 존재 입력할 2차원 배열 (문제에서 25까지 제한둠)
    static boolean[][] visit = new boolean[25][25]; // 탐색할 집의 방문 여부 체크
    private static int[] dx = { 0, -1, 0, 1 }; // dx, dy = 좌상우하
    private static int[] dy = { -1, 0, 1, 0 };
    static int count = 1; // 방문한 단지 번호(연결된 단지가 아닐경우 1씩 증가)
    static int N; // 지도의 크기

    // <- , ↑ , -> , ↓ ... 동서남북 4방향 체크해가며 dfs 돌리기
    public static void dfs(int y, int x) {
        map[y][x] = count; // 방문한 집 => count로 표시(1, 2, 3, ... 하나씩 증가)
        visit[y][x] = true; // 방문한 집 => true 체크
        for (int i = 0; i < 4; i++) { // 현재좌표 기준 좌상우하 체크
            // 좌(0,-1) 상(-1, 0), 우(0, 1), 하(1, 0) 순으로
            int ny = y + dy[i];
            int nx = x + dx[i];

            // nx, ny = 좌표의 범위, N*N 크기이므로 x, y좌표가 0보단 커야하고 N보단 작아야함.
            if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                if (map[ny][nx] == 1 && visit[ny][nx] == false) {
                    dfs(ny, nx); // 1이면서 방문하지 않은곳 => dfs 돌리기
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
                // charAt() 을 쓸 경우  - '0' 또는 -48 을 연산해야 한다. (아니면 아스키코드에 대응하는 문자가 나온다.)
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

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

예제 출력 1 
3
7
8
9
*/