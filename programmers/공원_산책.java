package programmers;

public class 공원_산책 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int h = park.length; // 세로 길이
            int w = park[0].length(); // 가로 길이
            int curRow = -1;
            int curCol = -1;

            // 맵을 감싸기 위해 +2 한 배열 생성
            int[][] tmpMap = new int[h + 2][w + 2];

            // 맵에 1로 테두리 처리
            setBoundary(tmpMap);

            // 맵 초기화
            for (int row = 1; row <= h; row++) {
                String line = park[row - 1];
                String[] tokens = line.split("");

                for (int col = 1; col <= w; col++) {
                    String token = tokens[col - 1];

                    if (token.equals("S")) {
                        curRow = row;
                        curCol = col;
                        tmpMap[row][col] = 0;
                        continue;
                    }

                    if (token.equals("X")) {
                        tmpMap[row][col] = 1;
                        continue;
                    }
                }
            }

            for (String route : routes) {
                String[] info = route.split(" ");
                String direction = info[0];
                int distance = Integer.valueOf(info[1]);

                int tmpRow = curRow;
                int tmpCol = curCol;
                boolean canMove = true;

                for (int i = 1; i <= distance; i++) {
                    switch (direction) {
                        case "E":
                            tmpCol++;
                            break;
                        case "W":
                            tmpCol--;
                            break;
                        case "S":
                            tmpRow++;
                            break;
                        case "N":
                            tmpRow--;
                            break;
                    }

                    if (tmpMap[tmpRow][tmpCol] == 1) {
                        canMove = false;
                        break;
                    }
                }

                if (canMove) {
                    curRow = tmpRow;
                    curCol = tmpCol;
                }
            }

            return new int[] { curRow - 1, curCol - 1 };
        }

        private void setBoundary(int[][] map) {
            // 0번째 컬럼 초기화
            for (int row = 0; row < map.length; row++) {
                map[row][0] = 1;
            }

            // n번째 컬럼 초기화
            for (int row = 0; row < map.length; row++) {
                map[row][map[0].length - 1] = 1;
            }

            // 0번째 로우 초기화
            for (int col = 0; col < map[0].length; col++) {
                map[0][col] = 1;
            }

            // m번째 로우 초기화
            for (int col = 0; col < map[0].length; col++) {
                map[map.length - 1][col] = 1;
            }
        }
    }
}
