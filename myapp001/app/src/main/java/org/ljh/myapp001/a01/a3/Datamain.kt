package org.ljh.myapp001.a01.a3

fun main() {
    val non1 =NonDataClass("Kim","a@a",20)
    val non2 =NonDataClass("Kim","a@a",20)
    val data1 = DataClass("kim","A@A",20)
    val data2 = DataClass("kim","A@A",20)

    val data3 = DataClass("kim","A@A",20,"seoul")
    val data4 = DataClass("kim","A@A",20,"busan")

    println("non data class toString:${non1.toString()}")
    println("data class toString:${data3.toString()}")

    println("non data class equals:${non1.equals(non2)}")
    println("data class equals:${data1.equals(data2)}")
    println("data class equals:${data3.equals(data4)}")

}