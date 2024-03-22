package org.ljh.myapp001.a01.a3

fun sum(num1:Int, num2:Int):Int{
    return num1+num2
}
var sum2 ={num1:Int, num2:Int -> num1+num2}
fun main(){
    println(sum(10,20))
    println("reslut : ${sum2(10,20)}")

}