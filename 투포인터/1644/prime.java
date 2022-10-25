public class prime {
  // 예제와 같이 120까지의 소수를 구하기 위해 120 선언.
	static boolean prime[] = new boolean[121];  

  public static void main(String[] args) throws Exception{
		
    // 구하고자 하는 숫자 범위
    int N = 120;
    
    // 소수는 false
    // 1은 소수가 아니므로 제외
    prime[0] = prime[1] = true;
    
    for (int i=2; i*i<=N; i++){ // 0,1 을 제외했으니까 2부터 시작
      if (!prime[i]){ // prime[i]가 소수라면
        // 소수의 곱들은 전부 소수가 아니다. ex) 2는 소수, 4는 소수가 아니다.
        for (int j=i*i; j<=N; j+=i) prime[j] = true; // prime[j] 소수가 아닌 표시
      }
    }
    
    // 소수 출력
    for (int i=1; i<=N;i++){
      if (!prime[i]) System.out.print(i+" ");
    }
    
  }
}


/*
https://firework-ham.tistory.com/8

소수는 1과 자기 자신 이외로 나눠지는 수가 있으면 소수가 아니다.
*/
