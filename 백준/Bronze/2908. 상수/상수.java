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

        StringTokenizer token = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(String.valueOf(new StringBuilder(token.nextToken()).reverse()));
        int n2 = Integer.parseInt(String.valueOf(new StringBuilder(token.nextToken()).reverse()));

        bw.write(n1 < n2 ? n2 + "" : n1 + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
