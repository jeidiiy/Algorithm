package programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashSet;

public class 튜플 {
    class Solution {
        public int[] solution(String s) {
            /***
             * 1. 제일 바깥 중괄호 제거
             * 2. 중괄호로 묶인 것으로 분리
             * 3. 배열 길이 기준으로 오름차순 정렬
             * 4. 현재까지 나오지 않은 없는 숫자를 추가
             * 5. 정답 반환
             ***/

            s = s.substring(1);
            s = s.substring(0, s.length() - 1);

            String pattern = "\\{([^}]+)\\}";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);

            ArrayList<int[]> arr = new ArrayList<>();

            while (m.find()) {
                String groupContent = m.group(1);
                String[] numbers = groupContent.split(",");
                int[] intArray = new int[numbers.length];

                for (int i = 0; i < intArray.length; i++) {
                    intArray[i] = Integer.parseInt(numbers[i]);
                }

                arr.add(intArray);
            }

            arr.sort((arr1, arr2) -> {
                if (arr1.length > arr2.length) {
                    return 1;
                }

                if (arr1.length < arr2.length) {
                    return -1;
                }

                return 0;
            });

            HashSet<Integer> set = new HashSet<>();

            int[] answer = new int[arr.size()];
            int size = arr.size();
            for (int i = 0; i < size; i++) {
                int[] intArr = arr.get(i);

                for (int j = 0; j < intArr.length; j++) {
                    if (!set.contains(intArr[j])) {
                        answer[i] = intArr[j];
                        set.add(intArr[j]);
                    }
                }
            }

            return answer;
        }
    }
}
