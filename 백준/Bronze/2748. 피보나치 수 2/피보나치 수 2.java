import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (N >= 2) dp[2] = 1;
        if (N >= 3) dp[3] = 2;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[N]);

        br.close();
        bw.flush();
        bw.close();
    }
}
