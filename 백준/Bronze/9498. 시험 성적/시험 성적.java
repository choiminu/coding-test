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

        char grade = '?';
        if (N >= 90) {
            grade = 'A';
        } else if (N >= 80) {
            grade = 'B';
        } else if (N >= 70) {
            grade = 'C';
        } else if (N >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        bw.write(grade);

        br.close();
        bw.flush();
        bw.close();
    }
}

