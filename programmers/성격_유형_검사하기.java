import java.util.Map;
import java.util.HashMap;

public class 성격_유형_검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            Map<String, Integer> personalityType = new HashMap<>();

            init(personalityType);

            for (int i = 0; i < survey.length; i++) {
                String[] types = survey[i].split("");
                int choice = choices[i];

                int result = choice - 4;
                int selectedType = result < 0 ? 0 : 1;

                personalityType.put(
                        types[selectedType],
                        personalityType.get(types[selectedType]) + Math.abs(result));

            }

            StringBuilder sb = new StringBuilder();

            sb.append(personalityType.get("R") >= personalityType.get("T") ? "R" : "T");
            sb.append(personalityType.get("C") >= personalityType.get("F") ? "C" : "F");
            sb.append(personalityType.get("J") >= personalityType.get("M") ? "J" : "M");
            sb.append(personalityType.get("A") >= personalityType.get("N") ? "A" : "N");

            return sb.toString();
        }

        private void init(Map<String, Integer> map) {
            map.put("R", 0);
            map.put("T", 0);
            map.put("C", 0);
            map.put("F", 0);
            map.put("J", 0);
            map.put("M", 0);
            map.put("A", 0);
            map.put("N", 0);
        }
    }
}
