fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.chunked(1).map { y -> y.toInt() } }
            .fold(IntArray(12)) { counter, next ->
                next.forEachIndexed{i,n -> if (n == 0 ) counter[i] += 1 else  counter[i] -= 1 }
                counter
            }
            .map { if(it > 0) 0 else 1 }
            .joinToString("")
            .let {
                (it.toUShort(2) * it.toUInt(2).inv().and(4095u)).toInt()
            }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
