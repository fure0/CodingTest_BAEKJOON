import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P9663 {
    
	public static int[] arr;
	public static int N;
	public static int count = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; //원소의 index를 '열'이라 생각하고, 원소 값을 '행'이라 생각
 
		nQueen(0);
		System.out.println(count);
 
	}
 
	public static void nQueen(int col) {
		// 모든 원소를 다 채운 상태면 count 증가 및 return 
		if (col == N) { // col이 0부터 넘겨 받기 떄문에
			count++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[col] = i; //인덱스는 열을 나타내고 값은 칸이 된다.
			// 놓을 수 있는 위치일 경우 재귀호출
			if (Possibility(col)) {
				nQueen(col + 1);
			}
		}
 
	}
 
	public static boolean Possibility(int col) {
		// 가로:row
		// 세로:col
		// 같은행이나 대각선에 존재하는지 체크
		for (int i = 0; i < col; i++) {
			// 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우) 
			// 위의 arr[depth] = i; 주목
			// 첫째 열은 0행에 배치, 둘째 열은 0행에 배치 return false
			// 첫째 열은 0행에 배치, 둘째 열은 1행에 배치 통과
			if (arr[col] == arr[i]) {
				return false;
			} 
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 * abs 절대값 
			 * 대각선 체크 절대값(abs)(퀸의 열 - 현재열)) == (핸재행 - 퀸의행)
			 * 퀸이 (0,1) 기준으로 (1,0) 이나 (1,2)를 계산해보면
			 * abs(0-1) = 1, abs(1-0) = 1
			 * abs(0-1) = 1, abs(1-2) = 1
			 */
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}

}

/*

https://st-lab.tistory.com/118

각 원소의 index를 '열'이라 생각하고, 원소 값을 '행'이라 생각하는 것이다.

4x4으로 생각하자.가능한 패턴은 2가지 뿐


문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92

*/