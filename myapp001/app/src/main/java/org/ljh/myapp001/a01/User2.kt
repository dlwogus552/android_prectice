package org.ljh.myapp001.a01

class User2(name:String, count:Int) {
    var name : String ="h"
    var count : Int = 1
    init{
        println("name : $name, count : ${count}")
        this.name=name
        this.count=count
    }
    fun some(){
        println("name : $name, count : $count")

    }

}