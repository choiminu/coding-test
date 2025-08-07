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

        Queue queue = new Queue();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            String[] ins = br.readLine().split(" ");
            if (ins[0].equals("push")) {
                queue.push(Integer.parseInt(ins[1]));
            } else if (ins[0].equals("pop")) {
                sb.append(queue.pop()).append("\n");
            } else if (ins[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (ins[0].equals("empty")) {
                sb.append(queue.empty()).append("\n");
            } else if (ins[0].equals("front")) {
                sb.append(queue.front()).append("\n");
            } else {
                sb.append(queue.back()).append("\n");
            }
        }

        System.out.print(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

class Queue {
    private int[] arr;
    private int front;
    private int rear;

    public Queue() {
        this.arr = new int[100001];
        this.front = 0;
        this.rear = 0;
    }

    public void push(int value) {
        arr[rear++] = value;
    }

    public int pop() {
        if (empty() == 1) {
            return -1;
        }
        return arr[front++];
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
        return arr[front];
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }
        return arr[rear - 1];
    }

}
