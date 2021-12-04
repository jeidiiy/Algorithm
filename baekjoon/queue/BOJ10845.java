package com.example;

import java.io.*;
import java.util.*;

class BOJ10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Command command = new Command();

        while (N-- > 0) {
            String line = br.readLine();
            String[] token = line.split(" ");

            System.out.print(command.process(token));
        }
    }
}

class Command {

    private LinkedList<Integer> q = new LinkedList<>();

    public String process(String[] token) {
        String command = token[0];
        String result = "";

        if (command.equals("push")) {
            q.add(Integer.parseInt(token[1]));
        } else if (command.equals("pop")) {
            Integer pop = q.pollFirst();
            result = String.valueOf(pop == null ? -1 : pop);
        } else if (command.equals("size")) {
            result = String.valueOf(q.size());
        } else if (command.equals("empty")) {
            result = String.valueOf(q.isEmpty() ? 1 : 0);
        } else if (command.equals("front")) {
            Integer front = q.peekFirst();
            result = String.valueOf(front == null ? -1 : front);
        } else if (command.equals("back")) {
            Integer back = q.peekLast();
            result = String.valueOf(back == null ? -1 : back);
        } else {
            throw new IllegalArgumentException();
        }

        if (isNotPush(command)) {
            return result.concat("\n");
        }

        return result;
    }

    private boolean isNotPush(String command) {
        return !command.equals("push");
    }
}