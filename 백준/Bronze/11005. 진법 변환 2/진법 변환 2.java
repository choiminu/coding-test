import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int input = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(input > 0) {
            sb.append((char)((input % digit >= 10) ? (input % digit + 55) : (input % digit + '0')));
            input = input / digit;
        }

        System.out.println(sb.reverse());
    }
}
