import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 목표 숫자 N
        int N = Integer.parseInt(br.readLine());

        // dp[i] : 정수 i를 1로 만드는 최소 연산 횟수
        int[] dp = new int[N + 1];

        // prev[i] : i를 최소 연산으로 만들 때 바로 이전 값
        int[] prev = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        System.out.println(dp[N]);

        List<Integer> list = new ArrayList<>();
        int currentIdx = N;

        while (currentIdx != 0) {
            list.add(currentIdx);
            currentIdx = prev[currentIdx];
        }

        for (Integer i : list) {
            bw.write(i + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
