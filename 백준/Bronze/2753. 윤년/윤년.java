import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(br.readLine());
        boolean flag = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        bw.write(flag ? (1 + "") : (0 + ""));

        br.close();
        bw.flush();
        bw.close();
    }
}
