import adventcode.my.twenty5.utils.convertInputResultToArray
import adventcode.my.twenty5.utils.readInput
import adventcode.my.twenty5.utils.readInputAsArray

fun main(){

    day_1_part2()
}

fun day_1_part1() : MutableList<Int>  {
    val resultantOutput =   readInputAsArray("day_1_part_1_input_test.txt")
    var dial = 50
    val finalResult = mutableListOf<Int>()
    for(i in resultantOutput){
        val extractedNumber = i.drop(1).toInt()
        if(i.contains("L")){
            dial -= extractedNumber
        }else{

            dial += extractedNumber
        }
        while (dial < 0) {
            dial += 100
           }

        while (dial > 100) {
            dial -= 100

        }

        if (dial == 0 || dial == 100) {
            finalResult.add(0)
        }

    }
  //  println(finalResult.size)
    return  finalResult

    }


fun day_1_part2(){
    val resultantOutput =   readInputAsArray("day_1_part_1_input.txt")
    var dial = 50
    val finalResult = day_1_part1()
    println("Result From part1 is ${finalResult.size}")
    val finalResultPart2 = mutableListOf<Int>()
    for(i in resultantOutput){
        println("Dialed Number is $i")
        val extractedNumber = i.drop(1).toInt()
        if(i.contains("L")){
            repeat(extractedNumber){
                println("Dialed Number in Left is $dial")
                if(dial == 0) {
                    dial = 100
                }
                dial -= 1
                if(dial == 0){
                    println("Dialed Number in Left when 0 is $dial")
                    finalResultPart2.add(dial)
                    dial = 100
                }
            }
          //  println("Final Result in Left is $finalResult")
        }


        if(i.contains("R")){
            repeat(extractedNumber){
                println("Dialed Number in Right is $dial")
                if(dial == 100) {
                    dial = 0
                }
                dial += 1
                if(dial == 100){
                    println("Dialed Number in Right when 100 is $dial")
                    finalResultPart2.add(dial)
                    dial = 0
                }
            }
      //   println("Final Result in Right is $finalResult")
        }

    }
    println(finalResultPart2.size)
}


