package org.ljh.myapp001.a4

fun main(){
    var sum:Int=0
    for(i in 0 .. 100){
        sum+=i
    }
    println(sum)
    for(i in 0 until  10 step 2){
        println(i)
    }
    for(i in 10 downTo  0 step 2){
        println(i)
    }

    var data = intArrayOf(10,20,30,40)
    for((index, value) in data.withIndex()){
        print(index)
        print(" : ")
        print(value)
        if(index!==data.size-1){
            print(",")
        }
    }


    println()
    for(i in data.indices){
        print(data.get(i))
        if(i!==data.size-1){
            print(",")
        }
    }

    for(i in 0..4){
        println()
        for(j in 0..i){
        print("*")
        }
    }


}