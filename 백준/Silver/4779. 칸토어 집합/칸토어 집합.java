import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N;
        while ((N = br.readLine()) != null) {
            int num = Integer.parseInt(N);

            char[] A = "-".repeat((int) Math.pow(3, num)).toCharArray();
            recursive(A, 0, A.length - 1);

            bw.write(new String(A) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void recursive(char[] A, int left, int right) {
        int len = right - left + 1;
        if (len < 3) return;

        int mid = len / 3;
        int spaceStart = left + mid;
        int spaceEnd = spaceStart + mid - 1;

        split(A, spaceStart, spaceEnd);

        recursive(A, left, spaceStart - 1);
        recursive(A, spaceEnd + 1, right);
    }

    private static void split(char[] A, int spaceStart, int spaceEnd) {
        while (spaceStart <= spaceEnd) {
            A[spaceStart] = ' ';
            spaceStart++;
        }
    }

}

