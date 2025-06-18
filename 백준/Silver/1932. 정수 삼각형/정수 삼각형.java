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

        int[][] dp = new int[N][N];

        for (int row = 0; row < N; row++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int max = 0;
        for (int val : dp[N - 1]) {
            max = Math.max(max, val);
        }

        System.out.println(max);

        br.close();
        bw.flush();
        bw.close();
    }
}

