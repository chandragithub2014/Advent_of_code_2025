package adventcode.my.twenty5.utils

fun readInput(fileName:String):String{
    val text = java.io.File("app/src/main/resources/$fileName").readText()
    return text
}

fun readInputAsArray(fileName: String): Array<String> {
    return java.io.File("app/src/main/resources/$fileName")
        .readLines()
        .toTypedArray()
}

fun convertArrayToList(inputArray:Array<String>) = inputArray.toMutableList()
fun parseRange(input: String): Pair<Long, Long> {
   // println("ParseRange is $input")
    val parts = input.split("-")
    if (parts.size != 2) {
        throw IllegalArgumentException("Invalid range format: $input")
    }
    val start = parts[0].toLong()
    val end = parts[1].toLong()
    return start to end
}

fun convertInputResultToArray(inputResult:String) =  inputResult.lines().toTypedArray()


fun findRepeatedSequenceNumbers(start: Long, end: Long): List<Long> {
    val result = mutableListOf<Long>()

    for (n in start..end) {
        if (isRepeatedSequence(n)) {
            result.add(n)
        }
    }
    return result
}

fun isRepeatedSequence(num: Long): Boolean {
    val s = num.toString()
    if (s.length % 2 != 0) return false   // must be even length

    val half = s.length / 2
    val first = s.substring(0, half)
    val second = s.substring(half)

    return first == second
}

fun findRepeatedSequenceNumbersForAny(start: Long, end: Long): List<Long> {
    val result = mutableListOf<Long>()

    for (n in start..end) {
        if (isRepeatedSequenceForAny(n)) {
            result.add(n)
        }
    }
    return result
}

fun isRepeatedSequenceForAny(n: Long): Boolean {
    val s = n.toString()
    val len = s.length

    // Try all possible block sizes
    for (k in 1..len / 2) {
        // Only check blocks that divide the length (perfect repeats)
        if (len % k != 0) continue

        val block = s.substring(0, k)
        val repeated = block.repeat(len / k)

        if (repeated == s) return true
    }

    return false
}
/*
Notes:
s = "9999"
        len = 4
        for(k in 1 .. 2)
             4 % 1 == 0
        block = 9
        repeated  = 9.repeat(4) = 9999

 */
