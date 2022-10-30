import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        int v = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        // 노드와 간선에 대한 값을 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    // check배열 false로 초기화
    public static void initCheck() {
        for (int i = 0; i < check.length; i++)
            check[i] = false;
    }

    // dfs 메소드
    public static void dfs(int start) {
        // 경로 출력
        sb.append(start + " ");
        // 현재 노드 방문 처리
        check[start] = true;

        for (int i = 1; i < check.length; i++)
            // 현재 노드와 다른 노드 중 && 미방문 && 간선이 존재
            if (i != start && check[i] == false && arr[start][i] == 1)
                dfs(i);

    }

    public static void bfs(int start) {
        // check배열 초기화
        initCheck();
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작노드 추가
        queue.add(start);
        // 처음 시작노드 방문처리
        check[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num + " ");

            for (int i = 1; i < check.length; i++) {
                // 현재 노드와 다른 노드 중 && 미방문 && 간선이 존재
                if (i != num && check[i] == false && arr[num][i] == 1) {
                    // 노드 추가
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
        sb.append("\n");
    }

}


/*

https://www.acmicpc.net/problem/1260

문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
예제 입력 2 
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2 
3 1 2 5 4
3 1 4 2 5
예제 입력 3 
1000 1 1000
999 1000
예제 출력 3 
1000 999
1000 999

*/