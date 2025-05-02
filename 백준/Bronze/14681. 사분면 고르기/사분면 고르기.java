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


        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int result = 0;
        
        if (a > 0 && b > 0) {
            result = 1;    
        } else if (a > 0 && b < 0) {
            result = 4;
        } else if (a < 0 && b < 0) {
            result = 3;
        }else {
            result = 2;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
