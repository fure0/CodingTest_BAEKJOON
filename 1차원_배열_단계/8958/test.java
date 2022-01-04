public class test {
    public static void main(String[] args) {
        String str = "1";
        System.out.println(str.charAt(0));
        if (str.charAt(0) == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        } // false
        if (str.charAt(0) -'0' == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        } // true
    }
}
