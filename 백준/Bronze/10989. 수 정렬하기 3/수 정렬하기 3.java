import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 수의 개수를 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 입력된 수를 저장할 원본 배열 선언
        int[] original = new int[N];

        // 배열의 최대값을 저장할 변수 선언
        int maxValue = 0;

        // 사용자에게 N개의 수를 입력받으며 최대값을 찾는다.
        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(br.readLine());
            if (original[i] > maxValue) maxValue = original[i];
        }

        // 입력받은 원소들의 빈도수를 저장할 배열 선언
        int[] countArr = new int[maxValue + 1];

        // 원본 배열을 순회하며 원소의 빈도수를 저장한다.
        for (int val : original) {
            countArr[val]++;
        }

        // 빈도수를 저장한 배열을 선언하며 원소들의 누적합을 구해준다.
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        // 정렬된 배열을 저장할 배열 선언
        int[] sortedArr = new int[N];

        // 원본 배열을 순회
        for (int i = 0; i < N; i++) {

            // 뒤에서부터 하나씩 값을 꺼냄
            int num = original[original.length - i - 1];

            // num의 최종 위치 인덱스 = (누적 개수 - 1)
            sortedArr[countArr[num] - 1] = num;

            // 같은 값의 다음 위치를 가리키도록 감소
            countArr[num]--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : sortedArr) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

