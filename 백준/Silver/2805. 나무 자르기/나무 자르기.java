import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int min = 0;
        int max = 0;

        int[] tree = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(token.nextToken());

            if (tree[i] > max) {
                max = tree[i];
            }
        }

        while (min < max) {

            int mid = (max + min) / 2;
            long sum = 0;

            for (int t : tree) {
                if (t - mid > 0) {
                    sum += (t - mid);
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        bw.write(min - 1 + "");


        br.close();
        bw.flush();
        br.close();
    }

}
