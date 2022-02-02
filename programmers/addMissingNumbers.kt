class AddMissingNumbers {
  fun solution(numbers: IntArray): Int {
    var arrForCheck = BooleanArray(10)

    for (number in numbers) {
      arrForCheck[number] = true
    }

    var sum = 0

    for ((index, elem) in arrForCheck.withIndex()) {
      when (elem) {
        false -> sum += index
      }
    }

    return sum
  }

  // 성능 비교 결과 위 코드가 훨씬 좋았다.
  // 위 코드 -> 약 0.02ms
  // 아래 코드 -> 약 10ms
  fun simpleSolution(numbers: IntArray): Int {
    val answer = 45
    return answer - numbers.sum()
  }
}
