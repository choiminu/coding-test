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

        int t = Integer.parseInt(br.readLine());

        int time = 9999;
        for (int i = 0; i < t; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            if (A <= B) {
                time = Math.min(time, B);
            }
        }

        bw.write(time == 9999 ? -1 + "" : time + "");

        br.close();
        bw.flush();
        bw.close();
    }

}