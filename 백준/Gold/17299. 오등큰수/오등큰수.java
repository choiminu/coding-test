import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 크기를 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 각 숫자의 등장 빈도를 저장할 자료구조
        Map<Integer, Integer> map = new HashMap<>();

        // 정답을 저장할 배열
        int[] answer = new int[N];

        // 입력 수열
        int[] nums = new int[N];

        // 아직 오등큰수를 찾지 못한 인덱스 저장
        Stack<Integer> stack = new Stack<>();

        // 수열 입력과 동시에 등장 횟수 집계
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 오등큰수 탐색
        for (int i = 0; i < nums.length; i++) {
            // 현재 값이 스택 최상단이 가리키는 값의 등장 빈도보다 크면 현재 값이 그 인덱스의 오등큰수가 된다.
            while (!stack.isEmpty() && map.get(nums[stack.peek()]) < map.get(nums[i])) {
                answer[stack.pop()] = nums[i];
            }
            //현재 인덱스를 스택에 추가
            stack.push(i);
        }

        // 끝까지 오등큰수를 찾지 못한 인덱스는 -1로 설정
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        // 결과 출력
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


