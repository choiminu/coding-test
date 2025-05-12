import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = new int[3];
        for (int i = 0; i < 3; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        bw.write(A[0] + A[1] - A[2] + "\n");
        bw.write(Integer.parseInt(String.valueOf(A[0]) + A[1]) - A[2] + "\n");

        br.close();
        bw.flush();
        bw.close();

    }
}

