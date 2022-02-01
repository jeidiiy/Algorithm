import java.io.*

fun main() {
  return with(BufferedReader(InputStreamReader(System.`in`))) {
    val tc = readLine()!!.toInt()

    repeat(tc) {
      val input = readLine()
      var result = 0
      var accPoint = 0
      for (answer in input) {
        when (answer) {
          'O' -> result += ++accPoint
          'X' -> accPoint = 0
        }
      }
      println(result)
    }
  }
}
