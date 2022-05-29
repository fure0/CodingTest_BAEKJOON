import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P14889 {
    static int N;
	static int[][] map;
	static boolean[] visit;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		map = new int[N][N];
		visit = new boolean[N];
 
 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		combi(0, 0);
		System.out.println(Min);
 
	}
 
	// idx는 인덱스, count는 조합 개수(=재귀 깊이)
	static void combi(int idx, int count) {
        // System.out.println("count = " + count);
		// 팀 조합이 완성될 경우
        if(count == N / 2) { //N이4 이면 count 2에서 true, N이6 이면 count 3에서 true
			/*
			 방문한 팀과 방문하지 않은 팀을 각각 나누어
			 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			*/
			diff();
			return;
		}
 
		for(int i = idx; i < N; i++) { //i = idx; 주목 dfs를 통해 계속 재귀하면서, 그 이전 값들을 변경하면 안 되기 때문
			// 방문하지 않았다면?
			if(!visit[i]) {
				visit[i] = true;	// 방문으로 변경
				combi(i + 1, count + 1);	// 재귀 호출
                visit[i] = false;	// 재귀가 끝나면 비방문으로 변경
                // System.out.println("----------");
			}
		}
	}
 
	// 두 팀의 능력치 차이를 계산하는 함수 
	static void diff() {
		int team_start = 0;
		int team_link = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
                // System.out.print("i = " + i + ", j = " + j + "  ");
                // System.out.println(visit[i] + ", " + visit[j]);
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (visit[i] == true && visit[j] == true) {
                    // System.out.println("map[i][j] = " + map[i][j]);
                    // System.out.println("map[j][i] = " + map[j][i]);
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visit[i] == false && visit[j] == false) {
                    // System.out.println("map[i][j] = " + map[i][j]);
                    // System.out.println("map[j][i] = " + map[j][i]);
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int val = Math.abs(team_start - team_link);
		
		/*
		  두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		  더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		Min = Math.min(val, Min);
				
	}
}

/*
https://www.acmicpc.net/problem/14889

https://st-lab.tistory.com/122

4명을 기준으로 할 때

4

!!! 이 2차원 배열은 그냥 능력치다. 신경쓰지 말자 !!!
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0

!!! 위와 같이 4명의 사람이 있을 때 두 팀으로 나눌 수 있는 방법, 즉 조합 방법은 다음과 같다. !!!
[(1, 2), (3, 4)] , [(1, 3), (2, 4)], [(1, 4), (2, 3)]

visit 배열의 역할은 위의 팀의 경우의 수를 dfs로 구하기 위해서 사용할 뿐이다.!! 속지말자


[(1, 2), (3, 4)] 의 경우 dfs
count = 0
count = 1
count = 2
i = 0, j = 1  true, true
i = 0, j = 2  true, false
i = 0, j = 3  true, false
i = 1, j = 2  true, false
i = 1, j = 3  true, false
i = 2, j = 3  false, false
----------

[(1, 3), (2, 4)] 의 경우 dfs
count = 2
i = 0, j = 1  true, false
i = 0, j = 2  true, true
i = 0, j = 3  true, false
i = 1, j = 2  false, true
i = 1, j = 3  false, false
i = 2, j = 3  true, false
----------

[(1, 4), (2, 3)] 의 경우 dfs
count = 2
i = 0, j = 1  true, false
i = 0, j = 2  true, false
i = 0, j = 3  true, true
i = 1, j = 2  false, false
i = 1, j = 3  false, true
i = 2, j = 3  false, true
*/