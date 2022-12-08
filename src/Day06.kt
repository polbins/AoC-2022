fun main() {
  fun part1(input: List<String>, size: Int = 4): List<Int> {
    val result = mutableListOf<Int>()
    input.forEach { s ->
      val chars = mutableListOf<Char>()
      s.toCharArray().forEachIndexed { index, c ->
        chars.add(c)
        if (chars.size == size) {
          if (chars.toSet().size == size) {
            result.add(index + 1)
            return@forEach
          } else {
            chars.removeAt(0)
          }
        }
      }
    }
    return result
  }

  // test if implementation meets criteria from the description, like:
  val testInput1 = readInput("Day06_test")
  check(
    part1(testInput1) ==
      listOf(
        7, 5, 6, 10, 11
      )
  )

  val input1 = readInput("Day06")
  println(part1(input1))

  val testInput2 = readInput("Day06_test")
  check(
    part1(testInput2, 14) == listOf(
      19, 23, 23, 29, 26
    )
  )

  val input2 = readInput("Day06")
  println(part1(input2, 14))
}
