package org.ljh.myapp001.a4

fun main(){
    var data = 20
    when(data){
        10-> println("data is 10")
        20-> println("data is 20")
        else-> println("data is not valid data")
    }
    var data2 = 'a'
    when(data2){
        'a'-> println("data is 10")
        'b'-> println("data is 20")
        else-> println("data is not valid data")
    }

    var data3:Any = "b"
    data3= 3
    when (data3){
        is String -> println("data is String")
        is Int -> println("data is Int")
    }

    var result = when{
        data<=0 -> "data is <=0"
        data>100->"data is >100"
        else -> {"data is not valid data"}
    }
    println(result)
}