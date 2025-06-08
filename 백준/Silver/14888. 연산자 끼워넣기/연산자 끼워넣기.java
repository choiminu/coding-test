import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static int[] A;
    static int[] operation = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < operation.length; i++) {
            operation[i] = Integer.parseInt(token.nextToken());
        }

        recursive(A[0], 1);

        bw.write(max + "\n" + min);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void recursive(int num, int index) {

        if (index == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < operation.length; i++) {

            if (operation[i] <= 0){
                continue;
            }

            operation[i]--;

            switch (i) {
                case 0: recursive(num + A[index], index + 1); break;
                case 1: recursive(num - A[index], index + 1); break;
                case 2: recursive(num * A[index], index + 1); break;
                case 3: recursive(num / A[index], index + 1); break;
            }

            operation[i]++;
        }
    }
}
