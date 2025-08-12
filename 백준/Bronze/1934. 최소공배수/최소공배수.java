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

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int gcd = getGcd(x, y);

            bw.write(gcd * (x / gcd) * (y / gcd) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int getGcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return getGcd(y, x % y);
    }

}


