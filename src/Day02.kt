data class Instruction(val instruction: String, val value: Int)
data class Sub(val depth: Int, val hPos: Int)
data class Sub2(val depth: Int, val hPos: Int, val aim: Int)

fun main() {

     fun parseInstruction(input : String) : Instruction {
        var r = input.split(" ")
        return Instruction(r[0], r[1].toInt())
    }

    fun part1(input: List<String>): Int {
        return input
            .map { parseInstruction(it) }
            .fold(Sub(0,0)) { i, c ->
                when (c.instruction) {
                    "forward" -> Sub(i.depth, i.hPos + c.value)
                    "down" -> Sub(i.depth + c.value, i.hPos)
                    "up" -> Sub(i.depth - c.value, i.hPos)
                    else -> Sub(i.depth, i.hPos)
                }
            }
            .run { hPos * depth }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { parseInstruction(it) }
            .fold(Sub2(0,0, 0)) { i, c ->
                when (c.instruction) {
                    "forward" -> Sub2(i.depth + (i.aim) * c.value,i.hPos + c.value,i.aim)
                    "down" -> Sub2(i.depth,i.hPos, i.aim+c.value)
                    "up" -> Sub2(i.depth,i.hPos, i.aim-c.value)
                    else -> Sub2(i.depth,i.hPos,i.aim)
                }
            }
            .run { hPos * depth }
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
