package adventcode.my.twenty5

import adventcode.my.twenty5.utils.readLinesAsList

/*
fun main(){
    day_4_part1()
}

fun day_4_part1(){
    //day4_input_test.txt
    val input = readLinesAsList("day4_input_test.txt")
    println("received input is $input")
}*/

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    println("Hello, world!!!")
    val grid = listOf(
        "..@@.@@@@.",
        "@@@.@.@.@@",
        "@@@@@.@.@@",
        "@.@@@@..@.",
        "@@.@@@@.@@",
        ".@@@@@@@.@",
        ".@.@.@.@@@",
        "@.@@@.@@@@",
        ".@@@@@@@@.",
        "@.@.@@@.@."
    )

    printAdjacent(grid)
}

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
    var globalCount = 0
    var localCount = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            localCount = 0

            if(grid[r][c] == '@') {
                // println("Cell ($r,$c) = '${grid[r][c]}'")
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc

                    if (nr in 0 until rows && nc in 0 until cols) {

                        if(grid[nr][nc] == '@'){
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

}