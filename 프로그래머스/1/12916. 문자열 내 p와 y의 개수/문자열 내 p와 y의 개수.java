class Solution {
    boolean solution(String s) {
        return s.toLowerCase().chars().filter(ch -> ch == 'p' || ch == 'y').reduce(0, (count, ch) -> count + (ch == 'p' ? 1 : -1)) == 0;
    }
}