package baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String line = reader.readLine().trim();
    String[] tokens = line.split(" ");

    int numOfVertexes = Integer.parseInt(tokens[0]);
    int numOfEdges = Integer.parseInt(tokens[1]);
    int startVertext = Integer.parseInt(tokens[2]);

    LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
    boolean[] visited = new boolean[numOfVertexes + 1];

    for (int i = 0; i <= numOfVertexes; i++)
      graph.add(new LinkedList<>());
    Arrays.fill(visited, false);

    for (int i = 1; i <= numOfEdges; i++) {
      line = reader.readLine().trim();
      String[] edges = line.split(" ");
      int fromEdge = Integer.parseInt(edges[0]);
      int toEdge = Integer.parseInt(edges[1]);

      LinkedList<Integer> fromVertex = graph.get(fromEdge);
      LinkedList<Integer> toVertex = graph.get(toEdge);
      fromVertex.add(toEdge);
      toVertex.add(fromEdge);
    }

    for (LinkedList<Integer> vertex : graph) {
      vertex.sort((a, b) -> a - b);
    }

    dfs(graph, startVertext, visited);
    Arrays.fill(visited, false);
    System.out.println();
    bfs(graph, startVertext, visited);

    reader.close();
  }

  public static void dfs(LinkedList<LinkedList<Integer>> graph, int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");

    for (int i : graph.get(v)) {
      if (!visited[i])
        dfs(graph, i, visited);
    }
  }

  public static void bfs(LinkedList<LinkedList<Integer>> graph, int v, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<Integer>();

    queue.offer(v);

    visited[v] = true;

    while (queue.size() != 0) {
      v = queue.poll();
      System.out.print(v + " ");
      for (int i : graph.get(v)) {
        if (!visited[i]) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
  }
}
