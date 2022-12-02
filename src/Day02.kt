fun main() {
  // Rock/Paper/Scissor = 1,2,3
  // Lose/Draw/Win = 0,3,6
  fun part1(input: List<String>): Int {
    var result = 0
    for (s in input) {
      val left = s[0].toScore()
      val right = s[2].toScore()

      val outcome = when (right - left) {
        1, -2 -> 6 // greater or -overlap (rock - scissor)
        -1, 2 -> 0 // lesser or +overlap (scissor - rock)
        else -> 3
      }
      result += right + outcome
    }
    return result
  }

  fun part2(input: List<String>): Int {
    var result = 0
    for (s in input) {
      val left = s[0].toScore()
      val outcome = s[2].toScore()

      result += when (outcome) {
        // lesser or +overlap
        1 -> when (left) {
          1 -> 3
          else -> left - 1
        }.plus(0)
        // match
        2 -> left.plus(3)
        // greater or -overlap
        else -> when (left) {
          3 -> 1
          else -> left + 1
        }.plus(6)
      }
    }

    return result
  }

  // test if implementation meets criteria from the description, like:
  val testInput1 = readInput("Day02_test")
  check(part1(testInput1) == 15)

  val input1 = readInput("Day02")
  println(part1(input1))

  val testInput2 = readInput("Day02_test")
  check(part2(testInput2) == 12)

  val input2 = readInput("Day02")
  println(part2(input2))
}

private fun Char.toScore() = when (this) {
  'A', 'X' -> 1
  'B', 'Y' -> 2
  'C', 'Z' -> 3
  else -> throw IllegalArgumentException("Unknown Char '$this'!")
}
