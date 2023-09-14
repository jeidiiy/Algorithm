package programmers;

public class 대충_만든_자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] alphabets = new int[26];

            for (String key : keymap) {
                for (int i = 1; i <= key.length(); i++) {
                    char alphabet = key.charAt(i - 1);

                    if (alphabets[alphabet - 'A'] != 0) {
                        alphabets[alphabet - 'A'] = Math.min(alphabets[alphabet - 'A'], i);
                        continue;
                    }

                    alphabets[alphabet - 'A'] = i;
                }
            }

            int[] answer = new int[targets.length];

            for (int attempt = 0; attempt < targets.length; attempt++) {
                String target = targets[attempt];
                for (int i = 0; i < target.length(); i++) {
                    char alphabet = target.charAt(i);
                    int count = alphabets[alphabet - 'A'];

                    if (count == 0) {
                        answer[attempt] = -1;
                        break;
                    }

                    answer[attempt] += count;
                }
            }

            return answer;
        }
    }
}
