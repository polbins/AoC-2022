fun main() {
  fun part1(input: List<String>): Int {
    var result = 0

    for (s in input) {
      val intList = s.split("-", ",")
        .map { it.toInt() }
      val left = intList[0] to intList[1]
      val right = intList[2] to intList[3]


      if (left.withinRange(right) || right.withinRange(left)) {
        result++
      }
    }
    return result
  }

  fun part2(input: List<String>): Int {
    var result = 0

    for (s in input) {
      val intList = s.split("-", ",")
        .map { it.toInt() }
      val left = intList[0] to intList[1]
      val right = intList[2] to intList[3]


      if (left.overlaps(right) || right.overlaps(left)) {
        result++
      }
    }
    return result
  }

  // test if implementation meets criteria from the description, like:
  val testInput1 = readInput("Day04_test")
  check(part1(testInput1) == 2)

  val input1 = readInput("Day04")
  println(part1(input1))

  val testInput2 = readInput("Day04_test")
  check(part2(testInput2) == 4)

  val input2 = readInput("Day04")
  println(part2(input2))
}

private fun Pair<Int, Int>.withinRange(other: Pair<Int, Int>): Boolean {
  return first >= other.first && second <= other.second
}

private fun Pair<Int, Int>.overlaps(other: Pair<Int, Int>): Boolean {
  return (first >= other.first && first <= other.second) ||
    (second >= other.first && second <= other.second)
}
