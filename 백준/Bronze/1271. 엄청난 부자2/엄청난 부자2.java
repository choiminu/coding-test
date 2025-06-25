import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        BigInteger N = new BigInteger(token.nextToken());
        BigInteger M = new BigInteger(token.nextToken());

        System.out.println(N.divide(M) + "\n" + N.remainder(M));

        br.close();
    }

}

