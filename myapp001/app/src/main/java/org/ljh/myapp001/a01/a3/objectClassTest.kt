package org.ljh.myapp001.a01.a3
//따로 클레스 생성 없이 바로 사용가능

open class Super{
    open var data=10
    open fun some(){
        println("super some():$data")
    }
}

val obj=object:Super() {
    override var data =10
    override fun some(){
        println("data:$data")
    }
}

fun main(){
    obj.data=20
    obj.some()
}