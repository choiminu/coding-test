import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 1000;

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < isPrime.length; i++) {

            if (!isPrime[i]) {
                continue;
            }

            for (int j = i + i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }

        }

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if (isPrime[value]) result++;
        }

        bw.write(result +"");

        br.close();
        bw.flush();
        bw.close();
    }
}

