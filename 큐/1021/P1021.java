import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		int count = 0;	// 2, 3번 연산 횟수 누적 합 변수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수
		
		// 1부터 N까지 덱에 담아둔다.
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < M; i++) {
			
			
			// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
			int target_idx = deque.indexOf(seq[i]);
			int half_idx;
			/*
				*  만약 현재 덱의 원소가 짝수 개라면 중간 지점을 
				*  현재 덱의 절반 크기에서 -1 감소시킨다. 
				*  
				*  {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면
				*  인덱스는 1이기 때문
				*/
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			
			
			// 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
			if(target_idx <= half_idx) {
				// idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
				for(int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우 
				// idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
				for(int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			
			}
			deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
		}
		
		System.out.println(count);
	}
}


/*

https://st-lab.tistory.com/216 에제 풀이 접근 설명을 읽으면 이해가 좀더 쉽다

문제
지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.

지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.) 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다. 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제의 정답을 출력한다.

예제 입력 1 
10 3
1 2 3
예제 출력 1 
0
예제 입력 2 
10 3
2 9 5
예제 출력 2 
8
예제 입력 3 
32 6
27 16 30 11 6 23
예제 출력 3 
59
예제 입력 4 
10 10
1 6 3 2 7 9 8 4 10 5
예제 출력 4 
14

*/