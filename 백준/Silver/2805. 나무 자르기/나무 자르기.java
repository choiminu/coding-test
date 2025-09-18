import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken()); // 합이 클 수 있어 long

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) max = trees[i];
        }

        long lo = 0, hi = max;   // 절단 높이 범위
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2; // 현재 절단 높이
            long cut = 0;

            // mid에서 잘리는 나무 길이 총합
            for (int h : trees) {
                if (h > mid) cut += (h - mid);
            }

            if (cut >= M) {
                // 더 높여도 조건을 만족할 수 있는지 시도
                ans = mid;      // 현재 mid는 유효
                lo = mid + 1;   // 더 큰 높이 탐색
            } else {
                // 너무 높게 잘랐음 → 낮춰야 더 많이 잘림
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
