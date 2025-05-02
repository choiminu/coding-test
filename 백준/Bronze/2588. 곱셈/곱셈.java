import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int temp = b;

        for (int i = 0; i < 3; i++) {
            bw.write(a * (temp % 10) + "\n");
            temp = temp / 10;
        }

        bw.write(a * b + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
