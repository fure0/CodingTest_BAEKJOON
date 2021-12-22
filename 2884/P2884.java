import java.util.Scanner;

public class P2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        
        int HH = H; //0
        int MM = M; //10
        
        if ((MM - 45) < 0) { // 10 - 45 = 25
            HH = HH - 1;
            MM = M + 60 - 45;
        } else {
            MM = MM - 45;
        }
        if (HH < 0) {
            HH = 23;    
        }
        System.out.print(HH + " " + MM);
    }
}
