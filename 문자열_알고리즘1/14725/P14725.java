import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P14725 {
  static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //4
        StringTokenizer st;
        Node root = new Node();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); // 2 KIWI BANANA
            int size = Integer.parseInt(st.nextToken()); // 2
            Node cur = root;

            for(int j=0; j<size; j++){
                String s = st.nextToken(); // KIWI

                if(!cur.childs.containsKey(s)){
                    cur.childs.put(s, new Node());
                }
                cur = cur.childs.get(s);
            }
        }
        print(root, "");
    }

    public static void print(Node root, String bar){
        Object[] key = root.childs.keySet().toArray();
        Arrays.sort(key);

        for (Object s : key){
            System.out.println(bar+s);
            print(root.childs.get(s),bar+"--");
        }
    }
}

class Node{
  HashMap<String, Node> childs = new HashMap<>();
}


/*
https://www.acmicpc.net/problem/14725
https://howtolivelikehuman.tistory.com/252

입력
첫 번째 줄은 로봇 개미가 각 층을 따라 내려오면서 알게 된 먹이의 정보 개수 N개가 주어진다.  (1 ≤ N ≤ 1000)

두 번째 줄부터 N+1 번째 줄까지, 각 줄의 시작은 로봇 개미 한마리가 보내준 먹이 정보 개수 K가 주어진다. (1 ≤ K ≤ 15)

다음 K개의 입력은 로봇 개미가 왼쪽부터 순서대로 각 층마다 지나온 방에 있는 먹이 정보이며 먹이 이름 길이 t는 (1 ≤ t ≤ 15) 이다. 

출력
개미굴의 시각화된 구조를 출력하여라.

개미굴의 각 층을 "--" 로 구분하며, 같은 층에 여러개의 방이 있을 때에는 사전 순서가 앞서는 먹이 정보가 먼저 나온다.

예제 입력 1 
3
2 B A
4 A B C D
2 A C

예제 출력 1 
A
--B
----C
------D
--C
B
--A

예제 입력 2 
4
2 KIWI BANANA
2 KIWI APPLE
2 APPLE APPLE
3 APPLE BANANA KIWI

예제 출력 2 
APPLE
--APPLE
--BANANA
----KIWI
KIWI
--APPLE
--BANANA

*/