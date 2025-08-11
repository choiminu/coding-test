import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 수열의 크기를 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 수열의 오른쪽의 값을 저장할 배열
        Stack<Integer> stack = new Stack<>();

        // 오큰수를 저장할 배열 선언
        int[] answer = new int[N];

        // 수열을 저장할 배열 선언
        int[] nums = new int[N];

        // StringTokenizer를 사용해 공백을 기준으로 nums 배열에 정수를 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // nums 배열 순회
        for (int i = 0; i < nums.length; i++) {
            // 스택이 비어있지 않고 스택에 저장된 수열의 인덱스 값을 꺼내어 nums 배열과 현재 값을 비교
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // 현재 값이 더 크다면 오큰 수 이므로 오큰수 배열에 저장
                answer[stack.pop()] = nums[i];
            }
            // 스택에 수열의 인덱스를 저장한다.
            stack.push(i);
        }

        // 수열의 끝처리 & 오큰수가 없다면
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);

        br.close();
        bw.flush();
        bw.close();
    }

}


