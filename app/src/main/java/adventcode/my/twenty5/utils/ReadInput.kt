package adventcode.my.twenty5.utils
import java.math.BigInteger

fun readInput(fileName:String):String{
    val text = java.io.File("app/src/main/resources/$fileName").readText()
    return text
}

fun readInputAsArray(fileName: String): Array<String> {
    return java.io.File("app/src/main/resources/$fileName")
        .readLines()
        .toTypedArray()
}

fun readLinesAsList(fileName: String): List<String> {
    return java.io.File("app/src/main/resources/$fileName").readLines()
}

fun convertStringToCharArray(input:String):CharArray {
   return input.toCharArray()
}

fun generateAllTwoDigitPairsAsInts(input: String): List<Int> {
    val result = mutableListOf<Int>()

    for (i in 0 until input.length - 1) {
        val a = input[i]
        for (j in i + 1 until input.length) {
            val b = input[j]
            result.add("$a$b".toInt())
        }
    }

    return result
}



fun largest12DigitBig(input: String): BigInteger {
    return input
        .windowed(12)
        .maxOf { BigInteger(it) }
}

fun convertArrayToList(inputArray:Array<String>) = inputArray.toMutableList()


fun largest12Digit(input: String): String {
    var best = ""  // this will hold the best 12-digit number seen so far

    for (digit in input) {
        // Add the new digit to the existing best
        val candidate = best + digit

        if (candidate.length <= 12) {
            // If length ≤ 12, simply keep adding digits
            best = candidate
        } else {
            // If length > 12, we must drop exactly ONE digit.
            // We try all ways of removing one digit and keep the largest.
            var max12 = 0L
            for (i in candidate.indices) {
                val removedOne = (candidate.removeRange(i, i + 1)).toLong()
                if (removedOne > max12) max12 = removedOne
            }
            best = max12.toString()
        }
    }

    return best
}


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

fun printAdjacent(grid: List<String>) {

    // 8 surrounding directions
    val directions = listOf(
        -1 to -1,   // top-left
        -1 to  0,   // top
        -1 to  1,   // top-right
        0 to -1,   // left
        0 to  1,   // right
        1 to -1,   // bottom-left
        1 to  0,   // bottom
        1 to  1    // bottom-right
    )

    val rows = grid.size
    val cols = grid[0].length

    for (r in 0 until rows) {
        for (c in 0 until cols) {

            println("Cell ($r,$c) = '${grid[r][c]}'")

            for ((dr, dc) in directions) {
                val nr = r + dr
                val nc = c + dc

                if (nr in 0 until rows && nc in 0 until cols) {
                    println("    Neighbor at ($nr,$nc) = '${grid[nr][nc]}'")
                } else {
                    println("    Neighbor at ($nr,$nc) = OUT OF GRID")
                }
            }

            println("--------------------------------")
        }
    }
}

fun printAdjacentForFilteredCharacter(grid:List<String>,filteredCharacter:Char = '@') : Int {


    val directions = listOf(
        -1 to -1,   // top-left
        -1 to  0,   // top
        -1 to  1,   // top-right
        0 to -1,   // left
        0 to  1,   // right
        1 to -1,   // bottom-left
        1 to  0,   // bottom
        1 to  1    // bottom-right
    )

    val rows = grid.size
    val cols = grid[0].length
    var globalCount = 0
    var localCount = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            localCount = 0

            if(grid[r][c] == filteredCharacter) {
                // println("Cell ($r,$c) = '${grid[r][c]}'")
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc

                    if (nr in 0 until rows && nc in 0 until cols) {

                        if(grid[nr][nc] == filteredCharacter){
                            println("Neighbor at ($nr,$nc) = '${grid[nr][nc]}'")
                            localCount += 1
                        }
                    } else {
                        println("    Neighbor at ($nr,$nc) = OUT OF GRID")
                    }
                }
                println("LocalCount for ${grid[r][c]} is ${localCount} and $r$c]")
                if(localCount  < 4 ){
                    globalCount += 1
                }
            }
            println("-------------------------------- ")
        }

    }
    println("GlobalCount is $globalCount")
    return  globalCount
}

fun printAdjacentForFilteredCharacterAndReturnUpdatedList(grid:List<String>,filteredCharacter:Char = '@') : Pair<Int, List<String>> {

    val directions = listOf(
        -1 to -1, -1 to 0, -1 to 1,
        0 to -1,          0 to 1,
        1 to -1,  1 to 0,  1 to 1
    )

    val rows = grid.size
  //  if (rows == 0) return grid
    val cols = grid[0].length

    // Create a read-only char view of the original grid (we will never mutate this)
    val original = grid.map { it.toCharArray() }

    // Create a mutable copy that we will update and eventually return
    val updated = grid.map { it.toCharArray() }.toMutableList()

    var globalCount = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (original[r][c] != '@') continue

            var localCount = 0
            for ((dr, dc) in directions) {
                val nr = r + dr
                val nc = c + dc
                if (nr in 0 until rows && nc in 0 until cols) {
                    if (original[nr][nc] == '@') localCount++
                }
            }

            if (localCount < 4) {
                globalCount++
                // WRITE into the separate mutable copy only
                updated[r][c] = 'x'
            }
        }
    }

    // Convert mutable char arrays back to List<String> to return
    val result = updated.map { String(it) }
    println("GlobalCount is $globalCount")
    println("result")
    return Pair(globalCount, result)
}
//Day 5
fun searchInputInRange(input:String,start:String,end:String):Pair<Long,String>{
    // println("Input is $input start is $start and end is $end")
    val convertedInput = input.toLong()
    val convertedStart = start.toLong()
    val convertedEnd = end.toLong()
    // println("Converted Input is $convertedInput start is $convertedStart and end is $convertedEnd")
    if(convertedInput in convertedStart .. convertedEnd){
        //println("$convertedInput exists betwen $convertedStart and $convertedEnd ")
        return Pair(convertedInput,"Exists")
    }else{
        //println("$convertedInput does not exists betwen $convertedStart and $convertedEnd ")
        return Pair(0L,"Exists")
    }
}
