package org.ljh.myapp001.a2

fun some3(){
    var data1:Any=10
    data1="hello"
}

fun func1(data1:Int, data2:Double) : Double{
    return data1+ data2
}

fun func2():Nothing?{
    return null
}
fun func3():Nothing{
    throw Exception()

}

fun main(){
    println(func2())
}