import java.util.Scanner;

public class P1018 {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) { // 행 순회
            String str = sc.next(); // ex) WBWBWBWB

            for (int j = 0; j < M; j++) { //열 순회
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int N_row = N - 7; //가로
        int M_col = M - 7; //세로

        // 9x9 크기의 경우를 생각하면, 체스판이 8x8 크기 가정이기 때문에 4가지 경우의 패턴을 만들 수 있다
        // (0,0) 부터 시작, (1,0) 부터 시작, (0,1) 부터 시작, (1,1) 부터 시작
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
        sc.close();
    }

    public static void find(int x, int y) {
        int end_x = x + 8; // x시작점에 8을 더해 x축 끝지점 지정
        int end_y = y + 8; // y시작점에 8을 더해 y축 끝지점 지정
        int count = 0;

        boolean TF = arr[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색이 아닐경우 count 1 증가
                if (arr[i][j] != TF) { // 첫번째는 자기 자신이니까 true이고, 다음 것부터 실질적으로 확인이라고 봐야한다.
                    count++;
                }

                // 다음 칸은 색이 바뀌므로 trur라면 false로, false라면 true로 값을 변경한다
                TF = (!TF);
            }

            TF = !TF;
        }

        /*
		 *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의 색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
         *  => 쉽게 말하면 64는 8x8이라서 그런거고, 하나만 바꿔도 되는 경우와, 하나를 위해 전부 다 바꿔야 되는경우는 당연히 하나만 바꾸는 쪽이 비용이 적다 
         *  Math.min 은 입력받은 두개 값중 작은값을 리턴
		 */
        count = Math.min(count, 64 - count);
        
        /*
		 * 이전까지의 경우 중 최솟값보다 현재 count 값이
		 * 더 작을 경우 최솟값을 갱신 
		 */
		min = Math.min(min, count);

    }
}

/*
문제
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

예제 입력 1 
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
예제 출력 1 
1
예제 입력 2 
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
예제 출력 2 
12
*/