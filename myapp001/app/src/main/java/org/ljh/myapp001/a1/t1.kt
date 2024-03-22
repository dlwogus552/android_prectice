package org.ljh.myapp001.a1

val a = 10 // 값 못 바꿈 (const)
var b = 10 // 값 바꿀 수 있음(var)
var c : Int=5 //자료형 지정
var d:Double=10.5 //자료형 지정
var a1 : Int = 0
lateinit var data0:String // 초기화 미루기
val data5 by lazy{
10
}
fun some2(){
    data0 = "android"
    println(data0)
}

class User{
    var data :Int=0
    var data2:Int=20
    lateinit var name:String
    val age by lazy {
    10
    }
}
fun some(){
    val d1:Int
    var d2:Int
    d1=10
    d2=20
    println("d1=$d1, d2=$d2")
}

fun main(){
//    var user:User
    var a1 : Int
    some()
    some2()
    println(data5)
    println("Hello android")
    println("Hong")
    println(20)
}