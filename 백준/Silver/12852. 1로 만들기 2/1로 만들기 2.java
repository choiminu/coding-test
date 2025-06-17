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
        int[] fw = new int[N + 1];

        dp[1] = 0;
        fw[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);

        while (N > 0) {
            System.out.print(N + " ");

            if (N == 1) break;

            if (N % 3 == 0 && dp[N/3] == dp[N] - 1) {
                N /= 3;
            } else if (N % 2 == 0 && dp[N/2] == dp[N] - 1) {
                N /= 2;
            } else {
                N--;
            }
        }

    }
}

