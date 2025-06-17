import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {

            if (dp[i-1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                prev[i] = i - 1;
            }

            if (i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
                dp[i] = dp[i/3] + 1;
                prev[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i/2] + 1 < dp[i]) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i / 2;
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append("\n");

        while (N > 0) {
            sb.append(N).append(" ");
            N = prev[N];
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

