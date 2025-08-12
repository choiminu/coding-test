import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i <= 4; i++) {
            sb.append(st.nextToken());
            if (i % 2 == 0) {
                result = result.add(BigInteger.valueOf(Long.parseLong(sb.toString())));
                sb = new StringBuilder();
            }
        }

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

}


