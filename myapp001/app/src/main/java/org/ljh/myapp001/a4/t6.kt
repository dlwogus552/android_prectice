package org.ljh.myapp001.a4

fun main(){
    var list = listOf<Int>(10,20,30)
    println("""
        list.size:${list.size}
        list.data:${list[0]},${list[1]},${list.get(2)}
    """.trimIndent())
    val mutable = mutableListOf<Int>(10,20,30)
    mutable.add(40)
    mutable.set(0,100)
    println(mutable.toString())
}