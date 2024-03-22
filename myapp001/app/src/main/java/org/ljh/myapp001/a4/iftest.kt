package org.ljh.myapp001.a4

fun main(){
    var data = 7
    val result = if(data > 0){
        println("data 0보다 크다")
        true
    }else{
        println("data 0작거나 같다")
        false
    }

    println("result : $result")
}