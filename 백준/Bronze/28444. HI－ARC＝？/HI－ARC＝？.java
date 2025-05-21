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

        StringTokenizer token = new StringTokenizer(br.readLine());

        int HI = Integer.parseInt(token.nextToken()) * Integer.parseInt(token.nextToken());
        int ARC = Integer.parseInt(token.nextToken()) * Integer.parseInt(token.nextToken()) * Integer.parseInt(token.nextToken());

        bw.write(HI - ARC + "");

        br.close();
        bw.flush();
        bw.close();
    }

}