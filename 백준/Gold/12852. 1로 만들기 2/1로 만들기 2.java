import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 N을 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 현재 i번째 위치에서 1을 만들기 위해 필요한 최소한의 연산을 저장
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        System.out.println(dp[N]);

        List<Integer> path = new ArrayList<>();
        int current = N;

        while (current != 0) {
            path.add(current);
            current = prev[current];
        }

        path.stream()
                .sorted(Collections.reverseOrder())
                .forEach(i -> System.out.print(i + " "));

        br.close();
        bw.flush();
        bw.close();
    }
}
