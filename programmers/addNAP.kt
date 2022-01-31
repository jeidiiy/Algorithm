class Solution {
  fun solution(absolutes: IntArray, signs: BooleanArray): Int {
    var result: Int = 0
    for ((index, abs) in absolutes.withIndex()) {
      result += if (signs[index] == true) abs else -abs
    }
    return result
  }
}
