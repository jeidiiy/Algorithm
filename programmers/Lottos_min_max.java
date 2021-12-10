package programmers;

public class Lottos_min_max {

    private static int LOTTOS_LENGTH = 6;

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int correctNumCount = 0;

        for (int i = 0; i < LOTTOS_LENGTH; i++) {
            for (int j = 0; j < LOTTOS_LENGTH; j++) {
                if (lottos[i] == win_nums[j]) {
                    correctNumCount++;
                    break;
                }
            }
            if (lottos[i] == 0)
                zeroCount++;
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
