import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(A);

        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i - 1] + A[i];
            sum += A[i];
        }

        bw.write(sum+"");

        br.close();
        bw.flush();
        bw.close();

    }
}

