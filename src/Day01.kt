fun main() {
    fun part1(input: List<String>): Int {
        return input.map {it.toInt() }
            .zipWithNext()
            .count{ (x,y) -> x < y }
    }

    fun part2(input: List<String>): Int {
        return input.map {it.toInt() }
            .windowed(3)
            .zipWithNext()
            .count{ (x,y) -> x.sum() <  y.sum() }
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
