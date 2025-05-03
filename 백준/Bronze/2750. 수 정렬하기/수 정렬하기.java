import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            for (; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j+1] = key;
        }

        bw.write(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("\n")));

        br.close();
        bw.flush();
        bw.close();
    }


}
