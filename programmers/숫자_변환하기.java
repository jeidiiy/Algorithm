package programmers;

import java.util.*;

public class 숫자_변환하기 {
    class Solution {
        public int solution(int x, int y, int n) {
            int answer = convertBFS(x, y, n);

            return answer;
        }

        private int convertBFS(int x, int y, int n) {
            int depth = 0;
            Set<Integer> set = new HashSet<>();
            Set<Integer> tmp = new HashSet<>();
            set.add(x);

            while (!set.isEmpty()) {
                if (set.contains(y)) {
                    return depth;
                }

                tmp = new HashSet<>();
                for (int elem : set) {
                    int a = elem + n;
                    int b = elem * 2;
                    int c = elem * 3;

                    if (a <= y)
                        tmp.add(a);
                    if (b <= y)
                        tmp.add(b);
                    if (c <= y)
                        tmp.add(c);
                }

                set = tmp;
                depth += 1;
            }

            return -1;
        }
    }
}
