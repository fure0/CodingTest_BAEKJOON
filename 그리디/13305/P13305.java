import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1]; // 거리
        long[] cost = new long[N]; // 비용

        // 거리 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        // 리터당 기름값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0]; // 이전 까지의 과정 중 주유 최소 비용

        for (int i = 0; i < N - 1; i++) {

            /*
             * 현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost를 갱신해준다.
             */
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += (minCost * dist[i]);
        }

        System.out.println(sum);

    }

}

/*

https://www.acmicpc.net/problem/13305

https://st-lab.tistory.com/192

입력
표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다. 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다. 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 

출력
표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다. 

예제 입력 1 
4
2 3 1
5 2 4 1

예제 출력 1 
18

예제 입력 2 
4
3 3 4
1 1 1 1

예제 출력 2 
10

*/