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


        String[] time = br.readLine().split(" ");
        int endTime = Integer.parseInt(br.readLine());

        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]) + endTime;

        if (m >= 60) {
            h += m / 60;
            m = m % 60;

            if (h > 23) {
                h = h % 24;
            }
        }

        bw.write(h + " " + m);


        br.close();
        bw.flush();
        bw.close();
    }
}
