package baekjoon.tree;

import java.io.*;

public class BOJ1991 {

    static class Node {
        char name;
        Node left;
        Node right;

        public Node(char name) {
            this.name = name;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            char parent = chars[0];
            char left = chars[2];
            char right = chars[4];

            if (left != '.') {
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        traversalPreorder(tree[0]);
        System.out.println();

        traversalInorder(tree[0]);
        System.out.println();

        traversalPostorder(tree[0]);
        System.out.println();
    }

    private static void traversalPreorder(Node node) {
        if (node != null) {
            System.out.print(node.name);
            traversalPreorder(node.left);
            traversalPreorder(node.right);
        }
    }

    private static void traversalInorder(Node node) {
        if (node != null) {
            traversalInorder(node.left);
            System.out.print(node.name);
            traversalInorder(node.right);
        }
    }

    private static void traversalPostorder(Node node) {
        if (node != null) {
            traversalPostorder(node.left);
            traversalPostorder(node.right);
            System.out.print(node.name);
        }
    }
}
