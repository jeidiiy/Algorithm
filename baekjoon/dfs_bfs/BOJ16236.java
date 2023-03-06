package baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ16236 {
    static int ans, N;
    static int[][] space;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            space = new int[N][N];

            Fish shark = null;
            boolean isFeedNotExists = true;

            for (int i = 0; i < N; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < N; j++) {
                    // 아기 상어 위치를 찾으면 상어 객체 생성
                    if (line[j] == 9) {
                        shark = new Fish(i, j, 2, 0, 0);
                        // 아기 상어가 돌아다니기 위해 아기 상어 자리를 0으로 변경
                        space[i][j] = 0;
                        continue;
                    } else if (line[j] > 0) {
                        isFeedNotExists = false;
                    }
                    space[i][j] = line[j];
                }
            }

            // 먹을 물고기가 없으면 0 반환 후 종료
            if (isFeedNotExists) {
                System.out.println(0);
                return;
            }

            // 먹이를 찾는 과정에서 먹을 수 있는 물고기들의 위치를 저장하기 위한 우선순위 큐
            // 정렬 기준은 다음과 같다.
            // 1. 거리가 가장 가까운 물고기
            // 2. 거리가 같은 경우 위에 있는 물고기
            // 3. 같은 행에 있으면 가장 왼쪽에 있는 물고기
            PriorityQueue<Fish> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.distance == o2.distance) {
                    if (o1.row == o2.row) {
                        return o1.col - o2.col;
                    } else {
                        return o1.row - o2.row;
                    }
                } else {
                    return o1.distance - o2.distance;
                }
            });

            Queue<Fish> q = new LinkedList<>();
            q.offer(shark);

            // 엄마 상어를 부를 때까지 반복
            while (true) {
                boolean[][] isVisited = new boolean[N][N];
                // 상어 위치 방문처리
                isVisited[q.peek().row][q.peek().col] = true;

                while (!q.isEmpty()) {
                    Fish fish = q.poll();
                    int curRow = fish.row;
                    int curCol = fish.col;

                    for (int i = 0; i < 4; i++) {
                        int nextRow = curRow + dx[i];
                        int nextCol = curCol + dy[i];

                        // 범위를 벗어나거나
                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)
                            continue;
                        // 방문한 적이 있거나
                        if (isVisited[nextRow][nextCol] == true)
                            continue;
                        // 아기 상어보다 몸집이 크면 패스
                        if (space[nextRow][nextCol] > fish.size)
                            continue;

                        // 아기 상어보다 작고 빈 칸이 아닌 경우
                        // 우선순위 큐에 먹이의 위치를 저장하고, 저장할 때 상어가 먹은 횟수와 이동 횟수를 1씩 증가
                        if (space[nextRow][nextCol] < fish.size && space[nextRow][nextCol] > 0)
                            pq.offer(new Fish(nextRow, nextCol, fish.size, fish.eatCount + 1,
                                    fish.distance + 1));

                        // 해당 좌표로 이동하기 위해 큐에 상어의 이동 횟수를 1 증가시켜서 저장
                        q.offer(new Fish(nextRow, nextCol, fish.size, fish.eatCount,
                                fish.distance + 1));

                        // 다음 칸 방문처리
                        isVisited[nextRow][nextCol] = true;
                    }
                }

                // BFS가 끝나고 먹을 수 있는 먹이가 없다면
                if (pq.isEmpty()) {
                    System.out.println(ans);
                    return;
                }

                Fish fish = pq.poll();
                if (fish.size == fish.eatCount) {
                    fish.size++;
                    fish.eatCount = 0;
                }

                // 공간에서 위치의 값을 0으로 처리(물고기를 먹었으므로)
                space[fish.row][fish.col] = 0;
                // 물고기를 먹기 위해 해당 위치까지 이동한 거리를 추가
                ans += fish.distance;
                // 큐에 물고기를 먹은 상어를 저장. 저장할 때 이동 거리를 0으로 초기화
                q.offer(new Fish(fish.row, fish.col, fish.size, fish.eatCount, 0));
                // 물고기는 이동한 칸에 있는 물고기 1개만 먹어야 하므로 클리어
                pq.clear();
            }
        }
    }

    private static class Fish {
        int row;
        int col;
        int size;
        int eatCount;
        int distance;

        public Fish(int row, int col, int size, int eatCount, int distance) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCount = eatCount;
            this.distance = distance;
        }
    }
}
