package adventcode.my.twenty5

import adventcode.my.twenty5.utils.applyOperation
import adventcode.my.twenty5.utils.performVerticalGridOperation
import adventcode.my.twenty5.utils.readLinesAsList

fun main(){
    val input = readLinesAsList("day6_input_test.txt")
    println("Read Input is $input")
   // part1(input)
    part2_6(input)
   // val trimmedList = input.map { it.trim() }

}

fun part1(input:List<String>){
    performVerticalGridOperation(input)
}

fun part2_6(input:List<String>){

    performVerticalGridOperation_day6(input)
}


fun performVerticalGridOperation_day6(grid: List<String>){
    var finalTotal = 0L
    val matrix = grid.map { row ->
        row.trim().split(Regex("\\s+"))
    }
    val rows = matrix.size
    val cols = matrix[0].size   // number of columns

    for (col in 0 until cols) {
        println("Column $col :")
        val operator = matrix[rows - 1][col]
        println("operator is $operator")
        val numbers = matrix.dropLast(1).map { it[col] }
        println("Numbers is $numbers")
        parseListIntoIndividual(numbers)

    }
    println("Final Total is $finalTotal")
}

fun parseListIntoIndividual(input:List<String>){
   
}