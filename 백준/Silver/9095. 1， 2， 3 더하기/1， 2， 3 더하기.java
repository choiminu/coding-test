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

        int[] dp = new int[11];
        dp[1] = 1; // 1
        dp[2] = 2; // (1+1), (2)
        dp[3] = 4; // (1+1+1), (1+2), (2+1), (3)

        StringBuilder sb = new StringBuilder();
        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 4; i <= N; i++) {
                if (dp[i] != 0) continue;
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }

            sb.append(dp[N]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }


}

