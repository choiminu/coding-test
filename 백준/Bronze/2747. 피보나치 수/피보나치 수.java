import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        int N = Integer.parseInt(br.readLine());

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

}
