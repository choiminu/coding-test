import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int number = 666;

        while (cnt != N) {
            number++;
            if (String.valueOf(number).contains("666")) {
                cnt++;
            }
        }

        bw.write(number+"");

        br.close();
        bw.flush();
        bw.close();
    }


}

