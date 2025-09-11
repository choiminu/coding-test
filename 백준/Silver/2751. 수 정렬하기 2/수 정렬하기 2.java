import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, arr.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }


    public static void mergeSort(int[] arr, int left, int right) {

        // 배열의 원소가 하나이거나 없는 경우 종료
        if (left >= right) return;

        // 배열의 중간 값을 저장
        int mid = (left + right) / 2;

        // 배열 분할 (left)
        mergeSort(arr, left, mid);

        // 배열 분할 (right)
        mergeSort(arr, mid + 1, right);

        // 병합 정렬
        merge(arr, left, mid, right);

    }

    public static void merge(int[] arr, int left, int mid, int right) {

        // 정렬된 배열을 저장할 임시 배열 생성
        int[] temp = new int[right - left + 1];

        // 왼쪽 배열의 시작 포인터
        int i = left;

        // 오른쪽 배열의 시작 포인터
        int j = mid + 1;

        // 정렬 결과를 쌓아 넣을 temp의 인덱스
        int k = 0;

        // 두 부분 배열 모두 원소가 남아있는 동안 병합한다 (둘 중 하나가 소진되면 종료)
        while (i <= mid && j <= right) {
            // 왼쪽 배열의 값이 오른쪽 배열의 값보다 작다면?
            if (arr[i] <= arr[j]) {
                // 임시 배열에 왼쪽 배열의 원소를 저장하고 포인터를 이동시킨다.
                temp[k++] = arr[i++];
            } else {
                // 임시 배열에 오른쪽 배열의 원소를 저장하고 포인터를 이동시킨다.
                temp[k++] = arr[j++];
            }
        }

        // 만약 왼쪽 배열의 원소가 남아있다면?
        while (i <= mid) {
            // 임시 배열에 왼쪽 배열의 값들을 저장시키고 포인터를 이동시킨다.
            temp[k++] = arr[i++];
        }

        // 만약 오른쪽 배열의 원소가 남아있다면?
        while (j <= right) {
            // 임시 배열에 오른쪽 배열의 값들을 저장시키고 포인터를 이동시킨다.
            temp[k++] = arr[j++];
        }

        // 병합 결과를 원본의 [left..right] 구간에 되돌려 쓴다
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }

}

