import java.util.StringTokenizer;

public class test {

    public static void main(String[] args)  {
        
        StringTokenizer st = new StringTokenizer("[1,2,3,4]", "[],");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }
}

/*

[],
[,]
,[]

결과는 같다.

"["로 나눴을때 1 2 3 4] 가 출력되는것은 잘 생각해보면 구분자 앞에 아무것도 없으니까...
마찬가지로 "]" 로 나눴을때 뒤에 아무것도 없으니까..

최종적으로 1 2 3 4 가 출력

*/