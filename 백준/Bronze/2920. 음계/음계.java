import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ascending = {1,2,3,4,5,6,7,8};
        int[] descending = {8,7,6,5,4,3,2,1};

        int[] A = new int[8];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        if (Arrays.equals(A, ascending)) {
            bw.write("ascending");
        } else if (Arrays.equals(A, descending)) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}

