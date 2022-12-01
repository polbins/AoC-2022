fun main() {
  fun part1(input: List<String>): Long {
    var current: Long = 0
    var highest: Long = 0

    for (s in input) {
      current = s.toLongOrNull()?.let {
        current + it
      } ?: 0

      if (current > highest) {
        highest = current
      }
    }

    return highest
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day01_test")
  check(part1(testInput) == 24000L)

  val input = readInput("Day01")
  println(part1(input))
}
