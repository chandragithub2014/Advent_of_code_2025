package adventcode.my.twenty5

import adventcode.my.twenty5.utils.convertArrayToList
import adventcode.my.twenty5.utils.findRepeatedSequenceNumbers
import adventcode.my.twenty5.utils.findRepeatedSequenceNumbersForAny
import adventcode.my.twenty5.utils.parseRange
import adventcode.my.twenty5.utils.readInputAsArray

fun main(){

    day_2_part1()
    day_2_part2()
}

fun day_2_part1(){
    val resultantOutput =   readInputAsArray("day_2_input.txt")
    val resultantMutableList = convertArrayToList(resultantOutput)
    val ranges = resultantMutableList.first().split(",")
    var sum:Long = 0
   // println(resultantMutableList)
    for(item in ranges){
        println(item)
        val (start, end) = parseRange(item)
        val list = findRepeatedSequenceNumbers(start, end)
        sum += list.sum()
        println("List for sequence $item is $list")

    }
    println("Final sum is $sum")

}

fun day_2_part2(){
    val resultantOutput =   readInputAsArray("day_2_input.txt")
    val resultantMutableList = convertArrayToList(resultantOutput)
    val ranges = resultantMutableList.first().split(",")
    var sum:Long = 0
    for(item in ranges){
        println(item)
        val (start, end) = parseRange(item)
        val list = findRepeatedSequenceNumbersForAny(start, end)
        sum += list.sum()
    }
    println("Final sum for part2 is $sum")
}