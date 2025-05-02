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


        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int max = Math.max(Math.max(a,b), Math.max(a,c));

        int prize = 0;

        if (a == b && a == c) {
            prize = 10_000 + a * 1000;
        } else if(a == b || a == c || b == c) {
            if (a == b || a == c) {
                prize = 1000 + a * 100;
            }

            if (b == c) {
                prize = 1000 + b * 100;
            }
        }else {
            prize = max * 100;
        }

        bw.write(prize + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
