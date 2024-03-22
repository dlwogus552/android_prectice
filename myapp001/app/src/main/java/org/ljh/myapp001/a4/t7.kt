package org.ljh.myapp001.a4

fun main(){
    val list = listOf<Any>("ttt","ttt","TTTT")
    println(list.toString())
    var mutable = mutableListOf<Any>("kim","lee","hong")
    mutable.add(100)
    mutable.set(0,1)
    println(mutable.toString())

    for(i in 0 until mutable.size){
        println(mutable.get(i))
    }

}