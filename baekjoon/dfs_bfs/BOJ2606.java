package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ2606 {
  private static LinkedList<Integer> list[];

  public static void main(String[] args) throws IOException {

    String line;
    String[] tokens;
    int res = 0;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int numOfVertexes = Integer.parseInt(br.readLine().trim());
    int numOfComputerPair = Integer.parseInt(br.readLine().trim());
    boolean[] visited = new boolean[numOfVertexes + 1];

    list = new LinkedList[numOfVertexes + 1];

    for (int i = 0; i < list.length; i++) {
      list[i] = new LinkedList<Integer>();
    }
    Arrays.fill(visited, false);

    for (int i = 1; i <= numOfComputerPair; i++) {
      line = br.readLine().trim();
      tokens = line.split(" ");

      int fromVertex = Integer.parseInt(tokens[0]);
      int toVertex = Integer.parseInt(tokens[1]);

      list[fromVertex].offer(toVertex);
      list[toVertex].offer(fromVertex);
    }

    for (int i = 1; i < list.length; i++) {
      list[i].sort((a, b) -> a - b);
    }

    res = bfs(list, 1, visited);
    System.out.println(res);

    br.close();
  }

  public static int bfs(LinkedList<Integer>[] graph, int v, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<Integer>();
    visited[v] = true;
    int numOfInfectedComputers = 0;

    queue.offer(v);

    while(queue.size() != 0) {
      v = queue.poll();
      
      for(int i : graph[v]) {
        if(!visited[i]) {
          queue.offer(i);
          visited[i] = true;
          numOfInfectedComputers += 1;
        }
      }
    }

    return numOfInfectedComputers;
  }
}
