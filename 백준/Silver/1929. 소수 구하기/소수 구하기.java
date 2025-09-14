import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX = 1_000_000;
        boolean[] isNotPrimeNumber = new boolean[MAX + 1];
        isNotPrimeNumber[0] = isNotPrimeNumber[1] = true;

        for (int i = 2; i < isNotPrimeNumber.length; i++) {

            if (isNotPrimeNumber[i]) {
                continue;
            }

            for (int j = i + i; j < isNotPrimeNumber.length; j += i) {
                isNotPrimeNumber[j] = true;
            }
        }

        StringTokenizer token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        StringBuilder sb = new StringBuilder();
        for (; start <= end; start++) {

            if (!isNotPrimeNumber[start]) {
                sb.append(start).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

