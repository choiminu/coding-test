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

        int day = Integer.parseInt(br.readLine());

        int[][] schedule = new int[day + 1][2];
        for (int i = 1; i <= day; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(token.nextToken());
            schedule[i][1] = Integer.parseInt(token.nextToken());
        }

        int[] dp = new int[day + 2];
        for (int i = day; i >= 1; i--) {
            int nextDay = i + schedule[i][0];

            if (nextDay <= day + 1) {
                dp[i] = Math.max(dp[i + 1], schedule[i][1] + dp[nextDay]);
            } else {
                dp[i] = dp[i + 1];
            }

        }

        System.out.println(dp[1]);

        br.close();
        bw.flush();
        bw.close();
    }
}
