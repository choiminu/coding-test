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

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("1");
            bw.flush();
            return;
        }

        int count = 1;
        int range = 1;
        while (range < N) {
            range += count++ * 6;
        }

        bw.write(count + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
}

