package org.ljh.myapp001.a01

class User03(name:String) {
    init {
        println("name : $name")
    }
    constructor(name:String, count:Int):this(name){
        println("name : $name, count : $count")
    }
    constructor(name:String, count:Int, email:String):this(name,count){
        println("name : $name, count : $count, email : $email")
    }
}