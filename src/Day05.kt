fun main() {
  fun part1(
    input: List<String>,
    numberOfStacks: Int
  ): String {
    val stacks: MutableList<ArrayDeque<Char>> = buildList(numberOfStacks) {
      add(ArrayDeque<Char>())
    }.toMutableList()
    val crateSize = 4

    var i = 0
    for (s in input) {
      // put on to stack
      while (s.indexOf('[', startIndex = i).also { i = it } != -1) {
        val stackIndex: Int = Math.floorDiv(i, crateSize)
        while (stacks.size - 1 < stackIndex) {
          stacks.add(stacks.size, ArrayDeque())
        }

        val char = s[i + 1]
        stacks[stackIndex].addFirst(char)
        i += 3
      }

      // follow movements
      if (s.contains("move")) {
        val groupValues = "move (\\d+) from (\\d+) to (\\d+)".toRegex().find(s)!!.groupValues
        var count = groupValues[1].toInt()
        val from = groupValues[2].toInt()
        val to = groupValues[3].toInt()

        while (count > 0) {
          val char = stacks[from - 1].removeLast()
          stacks[to - 1].addLast(char)
          count--
        }
      }
    }

    // print out top of stack
    return stacks.map { it.last() }.joinToString("")
  }

  fun part2(
    input: List<String>,
    numberOfStacks: Int
  ): String {
    val stacks: MutableList<ArrayDeque<Char>> = buildList(numberOfStacks) {
      add(ArrayDeque<Char>())
    }.toMutableList()
    val crateSize = 4

    var i = 0
    for (s in input) {
      // put on to stack
      while (s.indexOf('[', startIndex = i).also { i = it } != -1) {
        val stackIndex: Int = Math.floorDiv(i, crateSize)
        while (stacks.size - 1 < stackIndex) {
          stacks.add(stacks.size, ArrayDeque())
        }

        val char = s[i + 1]
        stacks[stackIndex].addFirst(char)
        i += 3
      }

      // follow movements
      if (s.contains("move")) {
        val groupValues = "move (\\d+) from (\\d+) to (\\d+)".toRegex().find(s)!!.groupValues
        val count = groupValues[1].toInt()
        val from = groupValues[2].toInt()
        val to = groupValues[3].toInt()

        val last = stacks[from - 1].takeLast(count)
        repeat(count) { stacks[from - 1].removeLast() }
        stacks[to - 1].addAll(last)
      }
    }

    // print out top of stack
    return stacks.map { it.last() }.joinToString("")
  }

  // test if implementation meets criteria from the description, like:
  val testInput1 = readInput("Day05_test")
  check(part1(testInput1, 3) == "CMZ")

  val input1 = readInput("Day05")
  println(part1(input1, 9))

  val testInput2 = readInput("Day05_test")
  check(part2(testInput2, 3) == "MCD")

  val input2 = readInput("Day05")
  println(part2(input2, 9))
}
