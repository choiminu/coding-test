import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[100 + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }
            System.out.println(dp[N]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

