package programmers;

public class RecommendingNewId {

    public String solution(String new_id) {
        String s = new_id;

        // 1단계
        s = s.toLowerCase();

        // 2단계
        s = s.replaceAll("[^a-z0-9\\-_.]*", "");

        // 3단계
        s = s.replaceAll("\\.{2,}", "\\.");

        // 4단계
        s = s.replaceAll("^[.]|[.]$", "");

        // 5단계
        if (s.equals("")) {
            s = "a";
        }

        // 6단계
        if (s.length() >= 16) {
            s = s.substring(0, 15);
        }

        s = s.replaceAll("[.]$", "");

        // 7단계
        if (s.length() < 3) {
            while (s.length() != 3) {
                s += s.substring(s.length() - 1);
            }
        }

        return s;
    }
}
