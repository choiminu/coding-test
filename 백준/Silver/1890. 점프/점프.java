import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (dp[y][x] > 0 && map[y][x] != 0) {
                    if (x + map[y][x] < N) dp[y][x + map[y][x]] += dp[y][x];
                    if (y + map[y][x] < N) dp[y + map[y][x]][x] += dp[y][x];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);

        br.close();
        bw.flush();
        br.close();
    }
}