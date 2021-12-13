package programmers;

public class 키패드_누르기 {

    class Solution {

        private StringBuilder sb = new StringBuilder();

        // 왼쪽: -1, 가운데: 0, 오른쪽: 1
        private Position currentLeftPosition = new Position(3, -1);
        private Position currentRightPosition = new Position(3, 1);

        public String solution(int[] numbers, String hand) {

            for (int number : numbers) {
                if (isLeft(number)) {
                    sb.append("L");
                    setCurrentLeftPosition(number);
                    continue;
                }

                if (isRight(number)) {
                    sb.append("R");
                    setCurrentRightPosition(number);
                    continue;
                }

                if (calcDistance("left", number) < calcDistance("right", number)) {
                    sb.append("L");
                    setCurrentLeftPosition(number);
                    continue;
                } else if (calcDistance("left", number) > calcDistance("right", number)) {
                    sb.append("R");
                    setCurrentRightPosition(number);
                    continue;
                } else if (calcDistance("left", number) == calcDistance("right", number)) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        setCurrentLeftPosition(number);
                        continue;
                    }
                    if (hand.equals("right")) {
                        sb.append("R");
                        setCurrentRightPosition(number);
                        continue;
                    }
                }
            }

            return sb.toString();
        }

        private boolean isLeft(int number) {
            return number % 3 == 1;
        }

        private boolean isRight(int number) {
            return number % 3 == 0 && number != 0;
        }

        private void setCurrentLeftPosition(int number) {
            if (number == 1) {
                currentLeftPosition.setPosition(0, -1);
            } else if (number == 4) {
                currentLeftPosition.setPosition(1, -1);
            } else if (number == 7) {
                currentLeftPosition.setPosition(2, -1);
            } else
                setCurrentMiddlePosition(currentLeftPosition, number);
        }

        private void setCurrentRightPosition(int number) {
            if (number == 3) {
                currentRightPosition.setPosition(0, 1);
            } else if (number == 6) {
                currentRightPosition.setPosition(1, 1);
            } else if (number == 9) {
                currentRightPosition.setPosition(2, 1);
            } else
                setCurrentMiddlePosition(currentRightPosition, number);
        }

        private void setCurrentMiddlePosition(Position position, int number) {
            if (number == 2) {
                position.setPosition(0, 0);
            } else if (number == 5) {
                position.setPosition(1, 0);
            } else if (number == 8) {
                position.setPosition(2, 0);
            } else if (number == 0) {
                position.setPosition(3, 0);
            }
        }

        private int calcDistance(String direction, int number) {

            Position currentPosition = null;

            if (direction.equals("left")) {
                currentPosition = currentLeftPosition;
            } else if (direction.equals("right")) {
                currentPosition = currentRightPosition;
            }

            if (number == 2) {
                return Math.abs(currentPosition.getX() - 0) + Math.abs(currentPosition.getY());
            } else if (number == 5) {
                return Math.abs(currentPosition.getX() - 1) + Math.abs(currentPosition.getY());
            } else if (number == 8) {
                return Math.abs(currentPosition.getX() - 2) + Math.abs(currentPosition.getY());
            } else if (number == 0) {
                return Math.abs(currentPosition.getX() - 3) + Math.abs(currentPosition.getY());
            } else {
                return 0;
            }
        }
    }

    class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}