package adventcode.my.twenty5

import adventcode.my.twenty5.utils.printAdjacent
import adventcode.my.twenty5.utils.printAdjacentForFilteredCharacter
import adventcode.my.twenty5.utils.printAdjacentForFilteredCharacterAndReturnUpdatedList
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

    val input = readLinesAsList("day4_input_test.txt")
    println("Received Input list is $input")
    day4_part1(input)
    day4_part2(input)
}

fun day4_part1(inputList:List<String>){
    val result = printAdjacentForFilteredCharacter(inputList)
    println("Received Result for Part1 is $result")
    println("**********************************************************")
    println("**********************************************************")
}

fun day4_part2(inputList:List<String>){
    println("**********************************************************")
    var finalResult = 0
    var tempMutableList = inputList
    var tempCount: Int
    do {
        val (count, newGrid) = printAdjacentForFilteredCharacterAndReturnUpdatedList(tempMutableList)
        tempCount = count
        tempMutableList = newGrid.toMutableList()
        finalResult += tempCount

    }while(tempCount > 0)


  println("Final Result  for part2 is $finalResult")


}
