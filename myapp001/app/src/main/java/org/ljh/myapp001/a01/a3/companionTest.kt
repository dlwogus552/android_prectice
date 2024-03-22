package org.ljh.myapp001.a01.a3

class MyClass{
    companion object{
        var data=10
        fun some(){
            println("data:$data")
        }
    }
}

fun main() {
    MyClass.data=20;
    MyClass.some()
}