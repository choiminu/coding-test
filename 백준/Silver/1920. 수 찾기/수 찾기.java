import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int[] R = new int[M];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            R[i] = Integer.parseInt(token.nextToken());
        }

        mergeSort(A, 0, A.length - 1);

        for (int num : R) {
            System.out.println(binarySearch(A, num));
        }

    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return 0;
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int t = 0; t < temp.length; t++) {
            arr[t + start] = temp[t];
        }
    }

}

