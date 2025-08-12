import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 1000000;
        boolean[] isNotPrimeNumber = new boolean[max + 1];
        isNotPrimeNumber[0] = isNotPrimeNumber[1] = true;

        for (int i = 2; i <= Math.sqrt(max); i++) {

            if (isNotPrimeNumber[i]) {
                continue;
            }

            for (int j = i + i; j <= max; j += i) {
                isNotPrimeNumber[j] = true;
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            boolean flag = false;

            for (int i = 2; i < N; i++) {
                if (!isNotPrimeNumber[i] && !isNotPrimeNumber[N - i]) {
                    bw.write(N + " = " + i + " + " + (N - i) + "\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }

        }

        br.close();
        bw.flush();
        bw.close();
    }


}


