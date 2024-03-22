package org.ljh.myapp001.a3


fun main(){
    val a=Array<Int>(10,{0})
    println(a)
    println(a.size)
    println(a.contentToString())

    a[0]=10
    a[1]=20
    a.set(2,30)
    println(a.contentToString())
    println( a.get(1))

    val intArray:IntArray= IntArray(3,{1})
    val booleanArray:BooleanArray= BooleanArray(3,{false})
    val doubleArray : DoubleArray = DoubleArray(3,{3.1})
    println(intArray.contentToString())
    println(booleanArray.contentToString())
    println(doubleArray.contentToString())

    val intArrayof = intArrayOf(1,2,3,4)
    val arrayof= arrayOf(1,2,3,4)
    val arrayof2= arrayOf("sun","mon","thu","wed")
    println(intArrayof.contentToString())
    println(arrayof.contentToString())
    println(arrayof2.contentToString())

}