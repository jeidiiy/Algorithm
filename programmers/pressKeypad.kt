package programmers

class Solution {

  val currentLeftHandPosition = Position(3, -1)
  val currentRightHandPosition = Position(3, 1)

  fun solution(numbers: IntArray, hand: String): String {

    return with(StringBuilder()) {
      for (number in numbers) {
        when (decideDirection(number)) {
          Direction.LEFT -> {
            append("L")
            setCurrentLeftPosition(number)
          }
          Direction.RIGHT -> {
            append("R")
            setCurrentRightPosition(number)
          }
          else -> {
            val calcedLeftDistance: Int = calcDistance("left", number)
            val calcedRightDistance: Int = calcDistance("right", number)

            when (compare(calcedLeftDistance, calcedRightDistance)) {
              -1 -> {
                append("L")
                setCurrentLeftPosition(number)
              }
              1 -> {
                append("R")
                setCurrentRightPosition(number)
              }
              0 -> {
                when (hand) {
                  "left" -> {
                    append("L")
                    setCurrentLeftPosition(number)
                  }
                  "right" -> {
                    append("R")
                    setCurrentRightPosition(number)
                  }
                }
              }
            }
          }
        }
      }
      toString()
    }
  }

  fun decideDirection(num: Int): Direction {

    var direction = Direction.MIDDLE

    if (isLeft(num)) {
      direction = Direction.LEFT
    }
    if (isRight(num)) {
      direction = Direction.RIGHT
    }

    return direction
  }

  fun compare(n1: Int, n2: Int): Int = if (n1 > n2) 1 else if (n1 < n2) -1 else 0

  fun isLeft(num: Int) = num % 3 == 1
  fun isRight(num: Int) = num % 3 == 0 && num != 0

  fun setCurrentLeftPosition(num: Int) {
    when (num) {
      1 -> currentLeftHandPosition.setPosition(0, -1)
      4 -> currentLeftHandPosition.setPosition(1, -1)
      7 -> currentLeftHandPosition.setPosition(2, -1)
      else -> setCurrentMiddlePosition(currentLeftHandPosition, num)
    }
  }

  fun setCurrentRightPosition(num: Int) {
    when (num) {
      3 -> currentRightHandPosition.setPosition(0, 1)
      6 -> currentRightHandPosition.setPosition(1, 1)
      9 -> currentRightHandPosition.setPosition(2, 1)
      else -> setCurrentMiddlePosition(currentRightHandPosition, num)
    }
  }

  fun setCurrentMiddlePosition(position: Position, num: Int) {
    when (num) {
      2 -> position.setPosition(0, 0)
      5 -> position.setPosition(1, 0)
      8 -> position.setPosition(2, 0)
      0 -> position.setPosition(3, 0)
    }
  }

  fun calcDistance(direction: String, num: Int): Int {
    val currentHandPosition: Position

    if (direction == "left") {
      currentHandPosition = currentLeftHandPosition
    } else {
      currentHandPosition = currentRightHandPosition
    }

    return when (num) {
      2 -> Math.abs(currentHandPosition.x - 0) + Math.abs(currentHandPosition.y)
      5 -> Math.abs(currentHandPosition.x - 1) + Math.abs(currentHandPosition.y)
      8 -> Math.abs(currentHandPosition.x - 2) + Math.abs(currentHandPosition.y)
      0 -> Math.abs(currentHandPosition.x - 3) + Math.abs(currentHandPosition.y)
      else -> 0
    }
  }

  enum class Direction {
    LEFT,
    RIGHT,
    MIDDLE
  }

  class Position(var x: Int, var y: Int) {
    fun setPosition(newX: Int, newY: Int) {
      x = newX
      y = newY
    }
  }
}
