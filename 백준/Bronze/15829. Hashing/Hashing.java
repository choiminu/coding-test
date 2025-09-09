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

        int R = 31;
        int M = 1234567891;

        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        int res = 0;
        for (int i = 0; i < input.length; i++) {
            res += (input[i] - 'a' + 1) * ((int)Math.pow(R, i) % M);
        }

        System.out.println(res);

        br.close();
        bw.flush();
        bw.close();
    }
}

