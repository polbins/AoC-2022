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

  fun part2(input: List<String>): Set<Int> {
    var current = 0
    val sums = sortedSetOf(0)

    for (s in input) {
      val num = s.toIntOrNull()
      current = if (num != null) {
        current + num
      } else {
        if (current > sums.first()) {
          sums.add(current)

          if (sums.size > 3) {
            sums.pollFirst()
          }
        }
        0
      }
    }

    return sums
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day01_test")
  check(part1(testInput) == 24000L)

  val input1 = readInput("Day01")
  println(part1(input1))

  val input2 = readInput("Day01")
  println(part2(input2).sum())
}
