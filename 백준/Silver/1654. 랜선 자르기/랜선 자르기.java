import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int target = Integer.parseInt(token.nextToken());

        long max = 0;
        long min = 0;

        int[] lan = new int[N];
        for (int i = 0; i < N; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (lan[i] > max) {
                max = lan[i];
            }
        }

        max++;

        while (min < max) {
            long mid = (min + max) / 2;

            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += lan[i] / mid;
            }


            if (cnt < target) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }

}

