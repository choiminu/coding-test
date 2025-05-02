import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[] arr = new int[26];

        for (char ch : A) {
            arr[ch - 'a']++;
        }

        for (char ch : B) {
            arr[ch - 'a']--;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i]);
        }

        bw.write(sum + "");

        bw.close();
        br.close();
    }

}
