import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int A;
    static int B;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        long result = pow(A, B, C);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long pow(long a, long b, long c) {

        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a % c;
        }

        long temp = pow(a, b / 2, c);

        if (b % 2 == 0) {
            return (temp * temp) % c;
        } else {
            return ((temp * temp) % c * a) % c;
        }
    }
}