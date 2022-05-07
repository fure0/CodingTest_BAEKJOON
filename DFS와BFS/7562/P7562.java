import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7562 {

    static int[] dx = { -2, -1, 2, 1, -2, -1, 1, 2 };
    static int[] dy = { 1, 2, 1, 2, -1, -2, -2, -1 };
    static int[][] map;
    static boolean[][] visit;
    static int x, y, gx, gy, limit;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            limit = sc.nextInt();
            map = new int[limit][limit];
            visit = new boolean[limit][limit];
            x = sc.nextInt();
            y = sc.nextInt();
            gx = sc.nextInt();
            gy = sc.nextInt();

            bfs();
            System.out.println(map[gx][gy]);
        }
        sc.close();
    }

    private static void bfs() {
        if (x == gx && y == gy) {
            return;
        }

        Queue<Integer> queuex = new LinkedList<>();
        Queue<Integer> queuey = new LinkedList<>();

        queuex.add(x);
        queuey.add(y);
        visit[x][y] = true;

        while (!queuex.isEmpty()) {
            int a = queuex.poll();
            int b = queuey.poll();

            for (int i = 0; i < dx.length; i++) {
                int x1 = a + dx[i];
                int y1 = b + dy[i];

                if (x1 >= 0 && x1 < limit && y1 >= 0 && y1 < limit && !visit[x1][y1]) {
                    queuex.add(x1);
                    queuey.add(y1);

                    visit[x1][y1] = true;

                    map[x1][y1] = map[a][b] + 1;
                }
            }
        }
    }

}

/*
 * 
 * https://www.acmicpc.net/problem/7562
 * 
 * https://geunzrial.tistory.com/82
 * 
 */