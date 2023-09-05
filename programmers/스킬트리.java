package programmers;

public class 스킬트리 {
    class Solution {
        public int solution(String skill, String[] skillTrees) {
            int answer = 0;

            for (String skillTree : skillTrees) {
                if (skill.startsWith(skillTree.replaceAll("[^" + skill + "]", ""))) {
                    answer += 1;
                }
            }

            return answer;
        }
    }
}
