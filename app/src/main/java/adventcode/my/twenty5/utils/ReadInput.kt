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

fun convertInputResultToArray(inputResult:String) =  inputResult.lines().toTypedArray()