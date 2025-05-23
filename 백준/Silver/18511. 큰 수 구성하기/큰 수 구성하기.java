import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] A;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        A = new int[K];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        dfs("");

        bw.write(result+"");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(String value) {
        if (!value.isEmpty()) {
            int num = Integer.parseInt(value);
            if (num > N) return;
            result = Math.max(result, num);
        }

        for (int n : A) {
            dfs(value + n);
        }
    }

}

