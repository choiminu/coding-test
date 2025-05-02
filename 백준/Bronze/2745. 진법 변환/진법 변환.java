import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        char[] input = st.nextToken().toCharArray();
        int digit = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if (!Character.isDigit(input[i])) {
                sum += (input[i] - 55) * (int) Math.pow(digit, input.length - i - 1);
            } else {
                sum += Character.digit(input[i], 10) * (int) Math.pow(digit, input.length - i - 1);
            }
        }

        System.out.println(sum);
    }
}
