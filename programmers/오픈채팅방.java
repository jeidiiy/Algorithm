package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {

    class Solution {

        private final static String messageWhenEntered = "님이 들어왔습니다.";
        private final static String messageWhenLeft = "님이 나갔습니다.";

        public String[] solution(String[] record) {
            /**
             * 입력받은 문자열 모두를 command, uid, nickname으로 구분
             * uid와 nickname은 map으로 저장시켜 놓음
             * 모든 명령어를 수행한 뒤에 명령어에 따라 로그 메시지를 출력한다.
             */
            ArrayList<String> commands = new ArrayList<>();
            ArrayList<String> uids = new ArrayList<>();
            Map<String, String> userInfoPairs = new HashMap<>();
            ArrayList<String> result = new ArrayList<>();

            for (String line : record) {
                String[] tokens = line.split(" ");
                commands.add(tokens[0]);
                uids.add(tokens[1]);

                if (tokens[0].equals("Leave")) {
                    continue;
                }
                // hashmap은 키가 똑같으면 덮어 쓴다
                userInfoPairs.put(tokens[1], tokens[2]);
            }

            for (int i = 0; i < commands.size(); i++) {
                String command = commands.get(i);
                switch (command) {
                    case "Enter":
                        result.add(String.format("%s%s", userInfoPairs.get(uids.get(i)), messageWhenEntered));
                        break;
                    case "Change":
                        break;
                    case "Leave":
                        result.add(String.format("%s%s", userInfoPairs.get(uids.get(i)), messageWhenLeft));
                        break;
                }
            }

            String[] answer = result.stream().toArray(String[]::new);

            return answer;
        }
    }
}