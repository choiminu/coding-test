import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Deque deque = new Deque();
        while (T-- > 0) {
            String[] ins = br.readLine().split(" ");

            switch (ins[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(ins[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(ins[1]));
                    break;
                case "pop_front":
                    sb.append(deque.getFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.getLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }

        System.out.print(sb);

        br.close();
        bw.flush();
        bw.close();
    }

}

class Deque {
    private int[] arr;
    private int front;
    private int rear;

    public Deque() {
        this.arr = new int[10_001];
        this.front = arr.length / 2;
        this.rear = arr.length / 2;
    }

    public void addFirst(int value) {
        arr[front--] = value;
    }

    public void addLast(int value) {
        arr[++rear] = value;
    }

    public int getFirst() {
        if (empty() == 1) {
            return -1;
        }
        return arr[++front];
    }

    public int getLast() {
        if (empty() == 1) {
            return -1;
        }
        return arr[rear--];
    }

    public int size() {
        return rear - front;
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int front() {
        if (empty() == 1) {
            return -1;
        }
        return arr[front + 1];
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }
        return arr[rear];
    }
}

