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

        StringTokenizer token = new StringTokenizer(br.readLine());
        BigInteger A = BigInteger.valueOf(Integer.parseInt(token.nextToken()));
        BigInteger B = BigInteger.valueOf(Integer.parseInt(token.nextToken()));

        A.add(B);

        bw.write(A.add(B) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}