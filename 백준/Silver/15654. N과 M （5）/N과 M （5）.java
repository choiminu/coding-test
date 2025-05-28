import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] isVisited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N];
        answer = new int[M];
        isVisited = new boolean[N];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);

        dfs( 0);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth) throws IOException {

        if (depth == M) {
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {

            if (!isVisited[i]) {
                isVisited[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }

        }


    }

}