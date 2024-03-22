package org.ljh.myapp001.a2

fun some1(){
    var data1:Int = 10
//    var data2:Int = null 이거는 오류
    var data2:Int? = null
    data1 +=data1
    println(data1)

    data1 = data1.plus(10)
    println(data1)
}

fun some2(){
    val a1 : Byte=0b00001011
    val a2 : Int = 123
    val a3 : Short = 123
    val a4 : Long = 123L
    val a5 : Double = 123.00
    val a6 : Float = 123.00f
    val a7 : Boolean = true
    val a8 : Char = 'a'
    val a9 : String = "abc"
    val a10 : String = """
        asdasd
        asdasd
        asd
        asd
    """.trimIndent()
    print("$a1, $a2, $a3, $a4, $a5, $a6, $a7, $a8, $a9,$a10")
}

fun main(){
    some1()
    some2()
}