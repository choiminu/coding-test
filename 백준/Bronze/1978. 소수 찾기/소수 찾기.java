import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        boolean[] isNotPrime = new boolean[1000 + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i + i; j <= 1000; j += i) {
                isNotPrime[j] = true;
            }
        }

        int result = 0;
        while (token.hasMoreElements()) {
            int num = Integer.parseInt(token.nextToken());

            if (!isNotPrime[num]) {
                result++;
            }
        }

        bw.write(result+"");

        br.close();
        bw.flush();
        bw.close();
    }
}
