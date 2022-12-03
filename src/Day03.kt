fun main() {
  fun part1(input: List<String>): Int {
    val charPriority = buildCharPriority()
    var result = 0

    for (s in input) {
      val left = s.substring(0, s.length / 2).toSet()
      val right = s.substring(s.length / 2, s.length).toSet()
      val intersection = left.intersect(right).first()
      result += charPriority[intersection]!!
    }

    return result
  }

  fun part2(input: List<String>): Int {
    val charPriority = buildCharPriority()
    var result = 0

    val group: MutableList<Set<Char>> = mutableListOf()
    group.clear()
    for (s in input) {
      group.add(s.toSet())

      if (group.size == 3) {
        val intersection = group[0].intersect(group[1]).intersect(group[2]).first()
        result += charPriority[intersection]!!
        group.clear()
      }
    }

    return result
  }

  // test if implementation meets criteria from the description, like:
  val testInput1 = readInput("Day03_test")
  check(part1(testInput1) == 157)

  val input1 = readInput("Day03")
  println(part1(input1))

  val testInput2 = readInput("Day03_test")
  check(part2(testInput2) == 70)

  val input2 = readInput("Day03")
  println(part2(input2))
}

fun buildCharPriority(): Map<Char, Int> {
  var num = 1
  val result = mutableMapOf<Char, Int>()

  for (c in 'a'..'z') {
    result[c] = num++
  }
  for (c in 'A'..'Z') {
    result[c] = num++
  }
  return result
}
