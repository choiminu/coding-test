import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Long> pointSet = new HashSet<>();
        int[] xs = new int[N];
        int[] ys = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xs[i] = x;
            ys[i] = y;
            pointSet.add(encode(x, y));
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            int x = xs[i];
            int y = ys[i];
            if (pointSet.contains(encode(x + A, y)) &&
                pointSet.contains(encode(x, y + B)) &&
                pointSet.contains(encode(x + A, y + B))) {
                count++;
            }
        }

        System.out.println(count);
    }

    static long encode(int x, int y) {
        return ((long) x + 1_000_000_000L) * 2_000_000_001L + (y + 1_000_000_000L);
    }
}
