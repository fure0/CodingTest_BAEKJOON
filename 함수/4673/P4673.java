public class P4673 {
    public static void main(String[] args) {
 
        // Boolean(Object)의 기본값은 null이고 boolean(primitive)의 기본값은 false
		boolean[] check = new boolean[30];	// 1부터 10000이므로
 
		for (int i = 1; i < 30; i++){
            int n = d(i);
		
			if(n < 30){	// 10000 이 넘는 수는 필요가 없음
				check[n] = true;
			}
		}
 
		StringBuilder sb = new StringBuilder();
        
		for (int i = 1; i < 30; i++) {
			if (!check[i]) {	// false 인 인덱스만 출력
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
 
	public static int d(int number){
        int sum = number;
        
        System.out.println("sum1:" + sum);
		while(number != 0){
            sum = sum + (number % 10); // 첫 째 자리수
            System.out.println("sum2:" + sum);
            number = number/10;	// 10을 나누어 첫 째 자리를 없앤다
            System.out.println("number:" + number);
            System.out.println("-------------");
        }
        
		return sum;
	}
}
