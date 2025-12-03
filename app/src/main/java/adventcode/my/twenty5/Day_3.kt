package adventcode.my.twenty5

import adventcode.my.twenty5.utils.convertStringToCharArray
import adventcode.my.twenty5.utils.generateAllTwoDigitPairsAsInts
import adventcode.my.twenty5.utils.largest12Digit
import adventcode.my.twenty5.utils.largest12DigitBig
import adventcode.my.twenty5.utils.readInput
import adventcode.my.twenty5.utils.readInputAsArray
import adventcode.my.twenty5.utils.readLinesAsList

fun main(){
   day3_part1()
   day3_part2()
}

fun day3_part1(){
    val resultantOutput =   readLinesAsList("day3_input_test.txt")
    var sumOfJoltages = 0
    println("Resultant CharArray $resultantOutput")
    for(input in resultantOutput){
      println("$input:: ${generateAllTwoDigitPairsAsInts(input).sortedDescending()}")
        sumOfJoltages +=  generateAllTwoDigitPairsAsInts(input).sortedDescending()[0]

    }
    print("TotalSum:: $sumOfJoltages")
}

fun day3_part2(){
    val resultantOutput =   readLinesAsList("day3_input.txt")
    var sumOfJoltages = 0L
    println("Resultant CharArray $resultantOutput")
    for(input in resultantOutput){
        println("$input:: ${largest12Digit(input)}")
     //   println("$input:: ${generateAllTwoDigitPairsAsInts(input).sortedDescending()}")
       sumOfJoltages +=  largest12Digit(input).toLong()

    }
   print("TotalSum:: $sumOfJoltages")
}