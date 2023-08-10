package programmers;

import java.util.Arrays;

public class h_index {

    class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);

            for (int h = citations.length; h > 0; h--) {
                if (citations[citations.length - h] >= h) {
                    return h;
                }
            }

            return 0;
        }
    }
}
