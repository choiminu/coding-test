import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        dp[4] = 2L;

        while (tc --> 0) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 5; i <= N; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            System.out.println(dp[N]);
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
