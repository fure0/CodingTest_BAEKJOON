import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1644 {

  static boolean prime[];
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
  
    // 1. 소수 구하기
    prime = new boolean[N+1];        
    prime[0] = prime[1] = true;       
    for(int i=2; i*i<=N; i++){
        if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;                
    }            
    for(int i=1; i<=N;i++){
      if(!prime[i]) prime_numbers.add(i);     
    }
    
    int left = 0;
    int right = 0;
    int ans = 0;
    int sum = 2;
    int size = prime_numbers.size();

    // 합이 크면 left를 늘리고 합이 작으면 right를 늘리는 방식으로 구한다.
    // https://code-lab1.tistory.com/134 < -- 그림으로 이해
    while (left < size && right < size) {
      if (sum == N) {
        ans++;
        sum -= prime_numbers.get(left);
        left++;
      } else if (sum > N) {
        sum -= prime_numbers.get(left);
        left++;
      } else {
        right++;
        if (right >= size) break;
        sum += prime_numbers.get(right);
      }
    }
    System.out.println(ans);
  }	
}



/*

https://www.acmicpc.net/problem/1644
https://m.blog.naver.com/ebsmath1/221839056906 <-- 소수 설명
https://firework-ham.tistory.com/10

문제
하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.

3 : 3 (한 가지)
41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
53 : 5+7+11+13+17 = 53 (두 가지)
하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.

자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)

출력
첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.

예제 입력 1 
20
예제 출력 1 
0
예제 입력 2 
3
예제 출력 2 
1
예제 입력 3 
41
예제 출력 3 
3
예제 입력 4 
53
예제 출력 4 
2
*/