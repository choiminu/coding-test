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
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        boolean isNewbie = M == 1 || M == 2;
        boolean isOldbie = !isNewbie && N >= M;
        boolean isTLE = !isNewbie && !isOldbie;

        if (isNewbie) {
            bw.write("NEWBIE!");
        } else if (isOldbie) {
            bw.write("OLDBIE!");
        } else if (isTLE){
            bw.write("TLE!");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}