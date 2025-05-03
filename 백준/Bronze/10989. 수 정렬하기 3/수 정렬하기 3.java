import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            if (A[i] > maxValue) maxValue = A[i];
        }


        int[] countArr = new int[maxValue + 1];
        for (int i = 0; i < A.length; i++) {
            countArr[A[i]]++;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i-1];
        }


        int[] sortedArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            sortedArr[countArr[num] - 1] = num;
            countArr[num]--;
        }

        for (int i : sortedArr) {
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
