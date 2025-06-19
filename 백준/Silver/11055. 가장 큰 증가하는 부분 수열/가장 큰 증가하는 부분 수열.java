import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
            dp[i] = A[i];
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] < dp[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

        br.close();
        bw.flush();
        bw.close();
    }
}
