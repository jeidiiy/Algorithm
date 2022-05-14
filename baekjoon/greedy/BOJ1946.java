package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1946 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());

                CandidateRank[] ranks = new CandidateRank[N];
                String input;
                String[] tokens;

                for (int j = 0; j < N; j++) {
                    input = br.readLine();
                    tokens = input.split(" ");
                    ranks[j] = new CandidateRank(Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]));
                }

                Arrays.sort(ranks);

                CandidateRank standardCandidateRank = ranks[0];
                int countOfSuccessfullCandidates = 1;

                for (int j = 1; j < N; j++) {
                    if (standardCandidateRank.getInterviewRank() > ranks[j].getInterviewRank()) {
                        standardCandidateRank = ranks[j];
                        countOfSuccessfullCandidates += 1;
                    }
                }
                System.out.println(countOfSuccessfullCandidates);

                for (int j = 0; j < ranks.length; j++) {
                    ranks[j] = null;
                }
                ranks = null;
                input = null;
                tokens = null;
                standardCandidateRank = null;
            }
        }
    }

    static class CandidateRank implements Comparable<CandidateRank> {
        private int documentRank;
        private int interviewRank;

        public CandidateRank(int documentRank, int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }

        public int getDocumentRank() {
            return documentRank;
        }

        public int getInterviewRank() {
            return interviewRank;
        }

        public void setDocumentRank(int documentRank) {
            this.documentRank = documentRank;
        }

        public void setInterviewRank(int interviewRank) {
            this.interviewRank = interviewRank;
        }

        @Override
        public int compareTo(CandidateRank o) {
            return Integer.compare(this.documentRank, o.documentRank);
        }
    }
}
