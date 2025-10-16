import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        a.chars().mapToObj(ch -> {
            if (Character.isLowerCase((char) ch)) {
                return Character.toUpperCase((char)ch);
            }
            return Character.toLowerCase((char)ch);
        }).forEach(ch -> System.out.print(ch + ""));
    }
}