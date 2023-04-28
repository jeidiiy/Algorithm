package programmers;

import java.util.*;

public class 광물_캐기 {
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            /***
             * minerals 배열을 5개 단위로 subset diamond, iron, stone 순으로 내림차순 정렬 앞에서부터 채광
             */
            int answer = 0;

            List<List<String>> list = new ArrayList<>();
            for (int i = 0; i < minerals.length / 5 + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < minerals.length / 5 + 1; i++) {
                for (int j = 0 + i * 5; j < 5 + i * 5; j++) {
                    if (j >= minerals.length)
                        break;
                    list.get(i).add(minerals[j]);
                }
            }

            // 광물이 5로 나누어 떨어질 때는 불필요하게 리스트 1개가 더 생기므로 제거
            if (minerals.length % 5 == 0) {
                list.remove(list.size() - 1);
            }

            // 만약 곡괭이 수보다 자원의 개수가 더 많아서 모두 캐지 못할 경우 캐지 못하는 미네랄은 삭제
            int pickax = picks[0] + picks[1] + picks[2];
            if (pickax < list.size()) {
                int countWillRemove = list.size() - pickax;
                for (int i = 0; i < countWillRemove; i++) {
                    list.remove(list.size() - 1);
                }
            }

            // 다이아, 철, 돌 개수 순으로 리스트 내림차순 정렬
            Collections.sort(list, (l1, l2) -> {
                if (Collections.frequency(l2, "diamond") == Collections.frequency(l1, "diamond")) {
                    if (Collections.frequency(l2, "iron") == Collections.frequency(l1, "iron")) {
                        return Collections.frequency(l2, "stone")
                                - Collections.frequency(l1, "stone");
                    } else {
                        return Collections.frequency(l2, "iron")
                                - Collections.frequency(l1, "iron");
                    }
                } else {
                    return Collections.frequency(l2, "diamond")
                            - Collections.frequency(l1, "diamond");
                }
            });

            // 다이아 곡괭이로 채광
            for (int i = 0; i < picks[0]; i++) {
                if (list.isEmpty())
                    break;
                List<String> curL = list.get(0);
                for (int j = 0; j < curL.size(); j++) {
                    answer += 1;
                }
                list.remove(0);
            }

            // 철 곡괭이로 채광
            for (int i = 0; i < picks[1]; i++) {
                if (list.isEmpty())
                    break;
                List<String> curL = list.get(0);
                for (int j = 0; j < curL.size(); j++) {
                    if (curL.get(j).equals("diamond"))
                        answer += 5;
                    else
                        answer += 1;
                }
                list.remove(0);
            }

            // 돌 곡괭이로 채광
            for (int i = 0; i < picks[2]; i++) {
                if (list.isEmpty())
                    break;
                List<String> curL = list.get(0);
                for (int j = 0; j < curL.size(); j++) {
                    if (curL.get(j).equals("diamond"))
                        answer += 25;
                    else if (curL.get(j).equals("iron"))
                        answer += 5;
                    else
                        answer += 1;
                }
                list.remove(0);
            }

            return answer;
        }
    }
}
