import java.util.Scanner;

public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26];
        String s = sc.next();
        sc.close();

        for (int i=0; i<s.length(); i++) {
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) { // 대문자
                arr[s.charAt(i) - 'A']++; // -65
            } else {
                arr[s.charAt(i) - 'a']++; // -97
            }
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char)(i + 65); // 대문자로 출력해야 하므로 65를 더한다.
            } else if (arr[i] == max) { // 두개 이상이 최대일 경우
                ch = '?';
            }
        }

        System.out.print(ch);

    }
}
