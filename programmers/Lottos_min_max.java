package programmers;

public class Lottos_min_max {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int correctNumCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    correctNumCount++;
                }
            }
        }

        answer[0] = calcRank(correctNumCount + zeroCount);
        answer[1] = calcRank(correctNumCount);

        return answer;
    }

    public int calcRank(int num) {
        switch (num) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

}
