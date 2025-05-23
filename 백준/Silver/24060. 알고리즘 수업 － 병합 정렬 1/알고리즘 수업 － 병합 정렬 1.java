import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int result = -1;
    static int cnt;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        int[] A = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        mergeSort(A, 0, A.length - 1);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] A, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        merge(A, start, mid, end);
    }

    private static void merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (A[i] < A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = A[i++];
        }


        while (j <= end) {
            temp[k++] = A[j++];
        }

        for (int t = 0; t < temp.length; t++) {
            cnt++;

            if (cnt == K) {
                result = temp[t];
                break;
            }

            A[t + start] = temp[t];
        }
    }


}

