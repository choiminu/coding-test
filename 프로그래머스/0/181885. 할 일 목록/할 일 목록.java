import java.util.stream.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length).mapToObj(i -> !finished[i] ? todo_list[i] : "").filter(str -> !str.isEmpty()).toArray(String[]::new);
    }
}