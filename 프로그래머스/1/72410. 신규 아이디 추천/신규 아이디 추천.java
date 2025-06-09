class Solution {
    public String solution(String new_id) {
        String newId = new_id.toLowerCase();

        newId = newId.replaceAll("[^a-z0-9._-]", ""); // 2단계: 허용 문자만 남기기
        newId = newId.replaceAll("\\.{2,}", "."); // 3단계: 연속된 마침표 하나로
        newId = trimDot(newId); // 4단계: 처음/끝 마침표 제거

        if (newId.isEmpty()) newId = "a"; // 5단계: 빈 문자열 → a

        if (newId.length() > 15) {
            newId = newId.substring(0, 15);
            newId = trimDot(newId); // 끝이 점일 수 있으므로 다시 제거
        }

        while (newId.length() < 3) { // 7단계: 3자 미만이면 마지막 글자 반복
            newId += newId.charAt(newId.length() - 1);
        }

        return newId;
    }

    // 처음이나 끝이 점이면 제거
    private String trimDot(String str) {
        if (str.startsWith(".")) str = str.substring(1);
        if (str.endsWith(".")) str = str.substring(0, str.length() - 1);
        return str;
    }
}
